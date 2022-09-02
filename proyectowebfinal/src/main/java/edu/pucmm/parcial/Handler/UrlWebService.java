package edu.pucmm.parcial.Handler;


import edu.pucmm.parcial.Encapsulation.Url;
import edu.pucmm.parcial.Encapsulation.UrlSoap;
import edu.pucmm.parcial.Encapsulation.User;
import edu.pucmm.parcial.Services.UserServices;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@WebService
public class UrlWebService {

    @WebMethod
    public List<UrlSoap> getUrl(long usuario) {
        List<UrlSoap> urlDaos = new ArrayList<>();
        User user = UserServices.getInstancia().buscar(usuario);
        Set<Url> urls = user.getUrls();
        UrlSoap urlDao = new UrlSoap();
        for (Url url : urls) {
            urlDao.setRedirect(url.getRedirect());
            urlDao.setUrl(url.getUrl());
            urlDaos.add(urlDao);
        }
        return urlDaos;
    }

    @WebMethod
    public String helloWorld() {
        return "Hola, titiri mundati";
    }
}

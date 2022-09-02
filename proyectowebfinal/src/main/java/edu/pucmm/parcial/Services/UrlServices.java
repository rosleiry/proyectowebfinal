package edu.pucmm.parcial.Services;

import edu.pucmm.parcial.Encapsulation.Url;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UrlServices  extends DatabaseServices<Url>  {
    private static UrlServices instancia;

    private UrlServices() {
        super(Url.class);
    }

    public static UrlServices getInstancia() {
        if (instancia == null) {
            instancia = new UrlServices();
        }
        return instancia;
    }


    public Url getUrl(String redirect) {
        EntityManager em = getEntityManager();
        Query query = em.createQuery("select e from Url e where redirect = :redirect", Url.class);
        query.setParameter("redirect", redirect);
        List<Url> list = query.getResultList();
        if (list.size() > 0)
            return list.get(0);
        else
            return null;
    }


}

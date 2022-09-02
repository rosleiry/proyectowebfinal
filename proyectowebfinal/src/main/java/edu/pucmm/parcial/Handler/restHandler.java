package edu.pucmm.parcial.Handler;

import com.google.gson.Gson;
import edu.pucmm.parcial.Encapsulation.Url;
import edu.pucmm.parcial.Encapsulation.UrlSoap;
import edu.pucmm.parcial.Encapsulation.User;
import edu.pucmm.parcial.Services.UrlServices;
import edu.pucmm.parcial.Services.UserServices;
import edu.pucmm.parcial.Transformation.JsonTransformer;

import java.util.ArrayList;
import java.util.List;

import static spark.Spark.*;


public class restHandler {
    public restHandler() {
        currentuser = new User("restRequest", false);
        UserServices.getInstancia().insert(currentuser);
    }

    Gson gson = new Gson();
    User currentuser;
    public final static String ACCEPT_TYPE_JSON = "application/json";

    public void startup() {
        path("/api", () -> {
            path("/url", () -> {
                get("/", (request, response) -> {
                    List<Url> urls= UrlServices.getInstancia().buscarTodos();
                    List<UrlSoap> return_val = new ArrayList<>();
                    for (Url item:
                            urls) {
                        return_val.add(new UrlSoap(item.getUrl(),item.getRedirect()));
                    }
                    return return_val;
                }, JsonTransformer.json());

                post("/", restHandler.ACCEPT_TYPE_JSON, (request, response) -> {
                    Url fu = gson.fromJson(request.body(), Url.class);
                    Url returned_val = mainHandler.generateURL(fu.getUrl());
                    if (returned_val.getUrl() == null) {
                        response.status(404);
                        return null;
                    } else {
                        UrlServices.getInstancia().insert(returned_val);
                        return returned_val;
                    }
                }, JsonTransformer.json());

                put("/", restHandler.ACCEPT_TYPE_JSON, (request, response) -> {
                    Url fu = gson.fromJson(request.body(), Url.class);
                    if (fu.getUrl() == null) {
                        response.status(404);
                        return null;
                    } else {
                        UrlServices.getInstancia().modificar(fu);
                        return fu;
                    }
                }, JsonTransformer.json());


            });

            path("/user", () -> {
                get("/", (request, response) -> {
                    List<User> u = UserServices.getInstancia().buscarTodos();
                    for (User us:
                            u) {
                        us.setUrls(null);
                    }
                    return u;
                }, JsonTransformer.json());

                post("/", restHandler.ACCEPT_TYPE_JSON, (request, response) -> {
                    User fu = gson.fromJson(request.body(), User.class);
                    if (fu.getUsername() == null) {
                        response.status(404);
                        return null;
                    } else {
                        UserServices.getInstancia().insert(fu);
                        return fu;
                    }
                }, JsonTransformer.json());

                put("/", restHandler.ACCEPT_TYPE_JSON, (request, response) -> {
                    User fu = gson.fromJson(request.body(), User.class);
                    if (fu.getUsername() == null) {
                        response.status(404);
                        return null;
                    } else {
                        UserServices.getInstancia().modificar(fu);
                        return fu;
                    }
                }, JsonTransformer.json());

                delete("/:id", restHandler.ACCEPT_TYPE_JSON, (request, response) -> {
                    if(request.params("id") == null)
                    {
                        response.status(404);
                        return null;
                    }
                    else
                    {
                        User url = UserServices.getInstancia().buscar(Long.parseLong(request.params("id")));
                        UrlServices.getInstancia().eliminar(url);
                        return url;
                    }
                }, JsonTransformer.json());
            });
        });
    }
}
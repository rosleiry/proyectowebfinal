package edu.pucmm.parcial.Handler;

import com.sun.net.httpserver.HttpContext;
import org.eclipse.jetty.http.spi.HttpSpiContextHandler;
import org.eclipse.jetty.http.spi.JettyHttpContext;
import org.eclipse.jetty.http.spi.JettyHttpServer;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.server.handler.ContextHandlerCollection;

import javax.xml.ws.Endpoint;
import java.lang.reflect.Method;

public class soapHandler {

    public static void init() throws Exception {
        Server server = new Server(8081);
        ContextHandlerCollection contextHandlerCollection = new ContextHandlerCollection();
        server.setHandler(contextHandlerCollection);
        server.start();

        HttpContext context = build(server, "/ws");

        UrlWebService usuarioWebService = new UrlWebService();
        Endpoint endpoint = Endpoint.create(usuarioWebService);
        endpoint.publish(context);
    }
    private static com.sun.net.httpserver.HttpContext build(Server server, String contextString) throws Exception {
        JettyHttpServer jettyHttpServer = new JettyHttpServer(server, true);
        JettyHttpContext ctx = (JettyHttpContext) jettyHttpServer.createContext(contextString);
        Method method = JettyHttpContext.class.getDeclaredMethod("getJettyContextHandler");
        method.setAccessible(true);
        HttpSpiContextHandler contextHandler = (HttpSpiContextHandler) method.invoke(ctx);
        contextHandler.start();
        return ctx;
    }

}

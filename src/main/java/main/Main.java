package main;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServer;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class Main {

    public static void main(String[] args) {

	try {
	    HttpServer server = Vertx.vertx().createHttpServer();
	    Router router = Router.router(Vertx.vertx());
	    router.route().handler(RoutingContext -> {

		
		    HttpServerResponse response = RoutingContext.response();
		    response.putHeader("content-type", "text/plain");
		    response.end("Hello World with port 8181 and router");
		});

	    server.requestHandler(router::accept).listen(8181);
	    System.out.println("Corrió bien");
	} catch (Exception e) {
	    System.out.println("Error");
	}

    }
}

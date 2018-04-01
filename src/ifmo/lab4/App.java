package ifmo.lab4;
import com.sun.jersey.api.container.grizzly2.GrizzlyServerFactory;
import com.sun.jersey.api.core.ClassNamesResourceConfig;
import java.io.IOException;
import java.net.URI;

import lombok.val;
import org.glassfish.grizzly.http.server.HttpServer;

public class App {

    private static final URI BASE_URI = URI.create("http://localhost:8080/rest/");

    public static void main(String[] args) {
        HttpServer server;
        try {
            val resourceConfig = new ClassNamesResourceConfig(CountryResource.class);
            server = GrizzlyServerFactory.createHttpServer(BASE_URI, resourceConfig);
            server.start();
            System.in.read();
            stopServer(server);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static void stopServer(HttpServer server) {
        if (server != null) {
            server.stop();
        }
    }
}
package ifmo.file;

import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.multipart.FormDataMultiPart;
import com.sun.jersey.multipart.file.FileDataBodyPart;
import lombok.val;

import javax.ws.rs.core.MediaType;
import java.io.File;
import java.net.URI;

public class FileUploadClient {

    private static final URI BASE_URI = URI.create("http://localhost:8080/rest/");

    public static void main(String[] args) {
        final val config = new DefaultClientConfig();
        final val client = Client.create(config);

        final val resource = client.resource(BASE_URI).path("upload");

        final val file = new File("/home/andrey/test.txt");

        final val multiPart = new FormDataMultiPart();
        multiPart.bodyPart(new FileDataBodyPart("file", file,
                MediaType.APPLICATION_OCTET_STREAM_TYPE));

        final val clientResp = resource.type(
                MediaType.MULTIPART_FORM_DATA_TYPE).post(ClientResponse.class,
                multiPart);

        val status = clientResp.getStatusInfo();
        System.out.format("Response: %d - %s", status.getStatusCode(), status.getReasonPhrase());

        client.destroy();
    }

}

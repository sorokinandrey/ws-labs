package ifmo.file;

import com.sun.jersey.core.header.FormDataContentDisposition;
import com.sun.jersey.multipart.FormDataParam;
import lombok.val;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.*;

@Path("/upload")
public class FileUploadService {
    public FileUploadService() {
    }

    private static final String UPLOAD_DIR = "upload/";

    @POST
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public Response uploadFile(
            @FormDataParam("file") InputStream uploadStream,
            @FormDataParam("file") FormDataContentDisposition fileDetails) throws FileServiceException {
        if (uploadStream == null || fileDetails == null)
            throw new FileServiceException(400, "Empty data");
        try {
            createFolderIfNotExists(UPLOAD_DIR);
        } catch (SecurityException se) {
            throw new FileServiceException(500, "Couldn't create destination directory");
        }
        String filePath = UPLOAD_DIR + fileDetails.getFileName();
        try {
            consumeUploadStream(uploadStream, filePath);
        } catch (IOException e) {
            throw new FileServiceException(500, "Couldn't create file");
        }
        return Response.ok(filePath).build();
    }

    private void consumeUploadStream(InputStream inStream, String target)
            throws IOException {
        int read;
       val bytes = new byte[8192];
        try(OutputStream out = new FileOutputStream(new File(target))){
            while ((read = inStream.read(bytes)) != -1) {
                out.write(bytes, 0, read);
            }
        }
    }

    void createFolderIfNotExists(String dir)
            throws SecurityException {
        val dirFile = new File(dir);
        if (!dirFile.exists()) {
            dirFile.mkdir();
        }
    }
}
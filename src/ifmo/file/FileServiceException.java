package ifmo.file;

public class FileServiceException extends Exception {

    private final int status;

    public FileServiceException(int status, String message) {
        super(message);
        this.status = status;
    }

    public int getStatus() {
        return status;
    }
}

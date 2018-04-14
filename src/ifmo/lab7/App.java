package ifmo.lab7;

public class App {

    private static final String PUBLISH = "publish";
    private static final String CALL = "call";

    public static void main(String[] args) {
        if (args.length != 1) {
            help();
            return;
        }
        String command = args[0];
        switch (command) {
            case PUBLISH:
                JuddiPublisher.publishSample();
                break;
            case CALL:
                JuddiCaller.callSample();
                break;
            default:
                help();
        }
    }

    private static void help() {
        System.out.println("Please specify command, either " + PUBLISH + " or " + CALL);
    }
}

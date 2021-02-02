package es.duonet.providers;

/**
 * Class that process the arguments
 */
public class ArgsProcessor {

    private final static int POSITION_ID_CLIENT = 0;

    /**
     * Validate the arguments and retrieve the IDClient from them
     *
     * @param args Array of String with arguments values
     *
     * @return ID Client
     */
    public static int getIdClient(String ...args) {
        validArgs(args);
        return retrieveIdClient(args);
    }

    /**
     * Verify if number of arguments is the correct
     *
     * @param args Array of string with the arguments
     *
     * @throws RuntimeException if the number of arguments is not 1
     */
    private static void validArgs(String ...args) {
        if (args.length != 1) {
            throw new RuntimeException("Number of args must be 1");
        }
    }

    /**
     * Get the ID client from the arguments array
     *
     * @param args Array of string with the values of arguments
     *
     * @return ID Client to be process
     *
     * @throws RuntimeException if the argument is a positive number
     */
    private static int retrieveIdClient(String ...args) {
        int idClient;

        try {
            idClient = Integer.parseInt(args[POSITION_ID_CLIENT]);
        } catch (NumberFormatException exception) {
            throw new RuntimeException("ID client must be a int");
        }

        if (idClient < 0) {
            throw new RuntimeException("ID client must be positive");
        }

        return idClient;
    }
}

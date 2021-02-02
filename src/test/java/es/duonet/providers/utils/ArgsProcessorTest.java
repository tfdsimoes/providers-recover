package es.duonet.providers.utils;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArgsProcessorTest {

    /**
     * Assert the case there is only 1 argument and valid
     */
    @Test
    public void getIdClientSuccess() {
        String[] args = {"1"};

        int idClient = ArgsProcessor.getIdClient(args);

        assertEquals(1, 1, "Error the value expected is 1");
    }

    /**
     * Assert the case the argument is not a number
     */
    @Test
    public void getIdClientErrorNoInt() {
        String[] args = {"a"};

        try {
            ArgsProcessor.getIdClient(args);
        } catch (RuntimeException exception) {
            assertEquals("ID client must be a int", exception.getMessage(), "Error message is not the expected one");
        }
    }

    /**
     * Assert the case the argument is not a positive number
     */
    @Test
    public void getIdClientErrorNegativeInt() {
        String[] args = {"-1"};

        try {
            ArgsProcessor.getIdClient(args);
        } catch (RuntimeException exception) {
            assertEquals("ID client must be positive", exception.getMessage(), "Error message is not the expected one");
        }
    }

    /**
     * Assert the cases the number of arguments is not 1
     */
    @Test
    public void getIdClientErrorSizeArgs() {
        String[] args = {"1", "2"};

        try {
            ArgsProcessor.getIdClient(args);
        } catch (RuntimeException exception) {
            assertEquals("Number of args must be 1", exception.getMessage(), "Error message is not the expected one");
        }

        args = new String[0];

        try {
            ArgsProcessor.getIdClient(args);
        } catch (RuntimeException exception) {
            assertEquals("Number of args must be 1", exception.getMessage(), "Error message is not the expected one");
        }
    }
}
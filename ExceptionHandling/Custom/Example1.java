package ExceptionHandling.Custom;

// extend Exception class to create custom checked exception
class CustomCheckedException extends Exception {

    CustomCheckedException(String msg) {
        super(msg);
    }
}

// extend RuntimeException class to create custom unchecked exception
class CustomUncheckedException extends RuntimeException {

    CustomUncheckedException(String msg) {
        super(msg);
    }
}

class Example1 {

    public static void main(String[] args) {

        try {
            throw new CustomCheckedException("This is a custom checked exception");
        } catch (CustomCheckedException ex) {
            System.out.println("Caught custom checked exception : " + ex.getMessage());
        }

        try {
            throw new CustomUncheckedException("This is a custom unchecked exception");
        } catch (CustomUncheckedException ex) {
            System.out.println("Caught custom unchecked exception : " + ex.getMessage());
        }
    }
}

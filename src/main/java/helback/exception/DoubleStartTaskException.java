package helback.exception;

public class DoubleStartTaskException extends RuntimeException {

    public DoubleStartTaskException() {
        super("Выбранная задача уже начала!");
    }
}

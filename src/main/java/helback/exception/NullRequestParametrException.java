package helback.exception;

public class NullRequestParametrException extends RuntimeException {
    public NullRequestParametrException() {
        super("Некорректные передаваемые параметры!");
    }
}

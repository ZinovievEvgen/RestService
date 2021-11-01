package helback.exception;


public class EmptyAllowListTaskException extends RuntimeException {

    public EmptyAllowListTaskException() {
        super("Список доступных задач пуст! Обратитесь к адинистратору");
    }
}

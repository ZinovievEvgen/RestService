package helback.exception;

public class NotFoundTraslationException extends Exception {

    public NotFoundTraslationException() {
        super("Не найдены записи по данной локализации в БД!");
    }
}

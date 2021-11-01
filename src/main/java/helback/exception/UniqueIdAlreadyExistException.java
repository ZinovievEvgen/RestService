package helback.exception;


public class UniqueIdAlreadyExistException extends RuntimeException{

    public UniqueIdAlreadyExistException() {
        super("Ошибка при добавлении пользователя. Значение уникального ключа пользователя уже используется");
    }
}

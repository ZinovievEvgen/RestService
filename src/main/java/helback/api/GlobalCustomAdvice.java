package helback.api;

import helback.exception.NotFoundTraslationException;
import helback.exception.PersonNotFoundException;
import helback.models.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * При необходимости дописать обработку необходимых ошибок
 */
@ControllerAdvice
public class GlobalCustomAdvice {

    @ExceptionHandler(value = {Exception.class})
    public ResponseEntity<Response> handleException() {

        Response response = new Response("Server error");
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = {NotFoundTraslationException.class})
    public ResponseEntity<Response> handleNotFoundTraslationException() {
        Response response = new Response("Request parameters are not correct");
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(value = {PersonNotFoundException.class})
    public ResponseEntity<Response> handleNotFoundPersonException() {
        Response response = new Response("Person was not found! Please call to administrator!");
        return new ResponseEntity<>(response, HttpStatus.UNAUTHORIZED);
    }

}

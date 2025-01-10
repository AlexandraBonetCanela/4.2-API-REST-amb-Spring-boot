package cat.itacademy.s04.t02.n01.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(FruitAlreadyExistsException.class)
    public ResponseEntity<String> handleFruitAlreadyExistsException(FruitAlreadyExistsException ex) {
        log.error( "Fruit conflict error" , ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @ExceptionHandler(FruitNotFouncException.class)
    public ResponseEntity<String> handleFruitNotFouncException(FruitNotFouncException ex) {
        log.error("Fruit not found error" , ex.getMessage());
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception ex) {
        log.error( "An Unexpected error occured" , ex.getMessage());
        return new ResponseEntity<>("An unexpected error occured. " + ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

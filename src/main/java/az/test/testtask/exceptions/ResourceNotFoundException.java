package az.test.testtask.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

    public ResourceNotFoundException() {
        this("No data found");
    }

    public ResourceNotFoundException(Long id) {
        this(String.format("No data found for given id: %d", id));
    }

    public ResourceNotFoundException(String message) {
        super(message);
    }
}

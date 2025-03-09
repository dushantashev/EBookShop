package mk.ukim.finki.eshopapp.model.exptions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BookNotFound extends RuntimeException{
    public BookNotFound(Long id) {
        super(String.format("Category with id: %d is not found", id));
    }

}
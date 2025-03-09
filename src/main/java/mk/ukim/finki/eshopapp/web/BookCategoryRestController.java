package mk.ukim.finki.eshopapp.web;



import mk.ukim.finki.eshopapp.model.enums.BookCategory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
@RequestMapping("/api/bookcategories")
public class BookCategoryRestController {

    @GetMapping("/list")
    public List<BookCategory> getAllCategories() {
        return Arrays.asList(BookCategory.values());
    }

}
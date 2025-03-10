package mk.ukim.finki.eshopapp.web;

import mk.ukim.finki.eshopapp.model.Book;
import mk.ukim.finki.eshopapp.model.dto.BookDto;
import mk.ukim.finki.eshopapp.model.exptions.BookNotFound;
import mk.ukim.finki.eshopapp.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
public class BookRestController {

    private final BookService bookService;

    public BookRestController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    private List<Book> findAll() {
        return this.bookService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> findById(@PathVariable Long id) {
        return this.bookService.findById(id)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/add")
    public ResponseEntity<Book> save(@RequestBody BookDto bookDto) {
        return this.bookService.save(bookDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @PutMapping("/edit/{id}")
    public ResponseEntity<Book> save(@PathVariable Long id, @RequestBody BookDto bookDto) {
        return this.bookService.edit(id, bookDto)
                .map(product -> ResponseEntity.ok().body(product))
                .orElseGet(() -> ResponseEntity.badRequest().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteById(@PathVariable Long id) {
        this.bookService.deleteById(id);
        if(this.bookService.findById(id).isEmpty()) return ResponseEntity.ok().build();
        return ResponseEntity.badRequest().build();
    }
    @PutMapping("/markAsTaken/{id}")
    public ResponseEntity<Book> markBookAsTaken(@PathVariable Long id){
        Book book = bookService.findById(id).orElseThrow(()-> new BookNotFound(id));
        if(book == null){
            return ResponseEntity.notFound().build();
        }
        else {
            bookService.markBookAsTaken(id);
            return ResponseEntity.ok(book);
        }
    }
    @GetMapping("/search")
    public ResponseEntity<List<Book>> searchBooks(@RequestParam(required = false) String name,
                                                  @RequestParam(required = false) String author) {

        if (name != null && author != null) {
            List<Book> books = bookService.searchBooksByNameAndAuthor(name, author);
            return ResponseEntity.ok(books);
        } else if (name != null) {
            List<Book> books = bookService.searchBooksByName(name);
            return ResponseEntity.ok(books);
        } else if (author != null) {
            List<Book> books = bookService.searchBooksByAuthor(author);
            return ResponseEntity.ok(books);
        } else {
            return ResponseEntity.badRequest().body(null);
        }
    }
}
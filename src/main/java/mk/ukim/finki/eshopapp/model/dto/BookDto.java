package mk.ukim.finki.eshopapp.model.dto;

import lombok.Data;
import mk.ukim.finki.eshopapp.model.Author;
import mk.ukim.finki.eshopapp.model.enums.BookCategory;

@Data
public class BookDto {
    private String name;
    private BookCategory category;
    private Author author;
    private Integer availableCopies;

    public BookDto() {
    }

    public BookDto(String name, BookCategory category, Author author, Integer availableCopies) {
        this.name = name;
        this.category = category;
        this.author=author;
        this.availableCopies=availableCopies;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BookCategory getCategory() {
        return category;
    }

    public void setCategory(BookCategory category) {
        this.category = category;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }
}
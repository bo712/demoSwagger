package io.github.bo712.demoswagger.controller;

import java.util.List;

import javax.validation.constraints.NotNull;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.github.bo712.demoswagger.model.Book;
import io.github.bo712.demoswagger.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;

/**
 * @author K.Babakov
 * @since 20 янв. 2022 г.
 */
@RestController
@RequestMapping("api/")
@Tag(name = "Книжный контроллер (основной)", description = "Получение книг")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    @Operation(
            summary = "Получение полного списка книг",
            description = "Позволяет получить все книги из библиотеки"
    )
    public List<Book> getAll() {
        return bookService.getAll();
    }

    @PostMapping("/books")
    @Operation(
            summary = "Добавление новой книги",
            description = "Новая книга добавляется, индекс присваевается инкрементно"
    )
    public HttpStatus add(@RequestBody Book newBook) {
        bookService.add(newBook);
        return HttpStatus.CREATED;
    }

    @DeleteMapping("/books/{id}")
    @Operation(
            summary = "Удаление книги",
            description = "Книга удаляется по id"
    )
    public HttpStatus delete(@PathVariable("id") @Parameter(description = "айдишник книги для удаления") @NotNull int id) {
        if (bookService.isPresent(id)) {
            bookService.delete(id);
            return HttpStatus.OK;
        }
        return HttpStatus.NOT_FOUND;
    }

    @GetMapping("/books/author/{authorName}")
    @Operation(
            summary = "Найти все книги по имени автора",
            description = "Находит все книги с точным соответствием по имени автора"
    )
    public ResponseEntity<List<Book>> findByAuthor(@PathVariable("authorName") String authorName){
        List<Book> booksOfAuthor = bookService.findByAuthor(authorName);
        return new ResponseEntity<>(booksOfAuthor, HttpStatus.OK);
    }

    @GetMapping("/books/title/{bookTitle}")
    @Operation(
            summary = "Найти все книги по названию",
            description = "Находит все книги с точным соответствием названию"
    )
    public ResponseEntity<List<Book>> findByBookTitle(@PathVariable("bookTitle") String bookTitle){
        List<Book> booksWithSameTitle = bookService.findByBookTitle(bookTitle);
        return new ResponseEntity<>(booksWithSameTitle, HttpStatus.OK);
    }

    @GetMapping("/books/year/{yearOfRelease}")
    @Operation(
            summary = "Найти все книги по дате выхода",
            description = "Находит все книги с заданным годом выпуска"
    )
    public ResponseEntity<List<Book>> findByYearOfRelease(@PathVariable("yearOfRelease") int yearOfRelease){
        List<Book> booksWithSameYearOfRelease = bookService.findByYearOfRelease(yearOfRelease);
        return new ResponseEntity<>(booksWithSameYearOfRelease, HttpStatus.OK);
    }
}

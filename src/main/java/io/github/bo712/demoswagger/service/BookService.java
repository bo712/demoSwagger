package io.github.bo712.demoswagger.service;

import java.util.List;

import org.springframework.stereotype.Service;

import io.github.bo712.demoswagger.model.Book;
import io.github.bo712.demoswagger.repository.BookDao;

/**
 * @author K.Babakov
 * @since 20 янв. 2022 г.
 */
@Service
public class BookService {

    private final BookDao bookDb;

    public BookService(BookDao bookDb) {
        this.bookDb = bookDb;
    }

    public List<Book> getAll() {
        return bookDb.getAll();
    }

    public void add(Book newBook) {
        bookDb.add(newBook);
    }

    public boolean isPresent(int id) {
        return bookDb.isPresent(id);
    }

    public void delete(int id) {
        bookDb.delete(id);
    }

    public List<Book> findByAuthor(String authorName) {
        return bookDb.findByAuthor(authorName);
    }

    public List<Book> findByBookTitle(String bookTitle) {
        return bookDb.findByBookTitle(bookTitle);

    }

    public List<Book> findByYearOfRelease(Integer yearOfRelease) {
        return bookDb.findByYearOfRelease(yearOfRelease);

    }
}

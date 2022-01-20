package io.github.bo712.demoswagger.repository;

import java.util.*;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import io.github.bo712.demoswagger.model.Book;

/**
 * @author K.Babakov
 * @since 20 янв. 2022 г.
 */
@Repository
public class BookDao {

    private final List<Book> booksDb = new ArrayList<>();
    private int idCount;

    public BookDao() {
        booksDb.add(new Book(1, "Ruslan & Ludmila", "Pushkin", 1820, "123-3-13-233-2"));
        booksDb.add(new Book(2, "Сказка о царе Салтане", "Pushkin", 1822, "123-3-13-233-2"));
        booksDb.add(new Book(3, "Nochnoy Dozor", "Lukyanenko", 1997, "123-3-13-544-3"));
        booksDb.add(new Book(4, "Vyedmak", "Sapkovsky", 1995, "213-3-13-233-2"));
        booksDb.add(new Book(5, "Vyedmak 2", "Sapkovsky", 1997, "213-3-13-233-2"));
        idCount = booksDb.size();
    }

    public List<Book> getAll() {
        return booksDb;
    }

    public void add(Book newBook) {
        idCount += 1;
        newBook.setId(idCount);
        booksDb.add(newBook);
    }

    public boolean isPresent(int id) {
        Optional<Book> searchingBook = booksDb.stream().filter(book -> book.getId() == id).findFirst();
        return searchingBook.isPresent();
    }

    public void delete(int id) {
        Book bookForDeleting = booksDb.stream().filter(book -> book.getId() == id).findFirst().orElseThrow(() -> new RuntimeException("Книга пропала!"));
        booksDb.remove(bookForDeleting);
    }

    public List<Book> findByAuthor(String authorName) {
        return booksDb.stream().filter(book -> book.getAuthor().equals(authorName)).collect(Collectors.toList());
    }

    public List<Book> findByBookTitle(String bookTitle) {
        return booksDb.stream().filter(book -> book.getTitle().equals(bookTitle)).collect(Collectors.toList());
    }

    public List<Book> findByYearOfRelease(Integer yearOfRelease) {
        return booksDb.stream().filter(book -> book.getYearOfRelease().equals(yearOfRelease)).collect(Collectors.toList());
    }
}

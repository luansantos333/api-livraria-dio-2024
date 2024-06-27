package me.dio.livraria.api_2024.service;

import me.dio.livraria.api_2024.model.Book;
import me.dio.livraria.api_2024.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

public class BookService {


    @Autowired
    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }


    public ResponseEntity<Book> findById(Long id) {
        return ResponseEntity.ok(bookRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }


    public ResponseEntity<Iterable<Book>> findAll() {
        return ResponseEntity.ok(bookRepository.findAll());
    }


    public ResponseEntity<Book> createNewBook(Book book) {

        if (book!=null) {

            return ResponseEntity.ok(bookRepository.save(book));

        } else {

            return null;

        }

    }


    public ResponseEntity<Book> updateBook(Long id, Book bookToUpdate) {

        if (bookRepository.existsById(id)) {

           return ResponseEntity.ok(bookRepository.save(bookToUpdate));


        } else return null;

    }


    public void deleteBookById(Long id) {

        bookRepository.deleteById(id);

    }
}

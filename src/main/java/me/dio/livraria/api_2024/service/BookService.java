package me.dio.livraria.api_2024.service;

import me.dio.livraria.api_2024.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class BookService implements ServiceAbstractEntity{


    @Autowired
    private final BookRepository bookRepository;


    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public Object findById(Long id) {
        return null;
    }

    @Override
    public Iterable<Object> findAll() {
        return null;
    }

    @Override
    public Object createNewObject(Object object) {
        return null;
    }

    @Override
    public Object updateObject(Long id, Object objectToUpdate) {
        return null;
    }

    @Override
    public Object deleteObjectById(Long id) {
        return null;
    }
}

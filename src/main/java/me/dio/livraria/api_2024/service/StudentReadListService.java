package me.dio.livraria.api_2024.service;

import me.dio.livraria.api_2024.model.Book;
import me.dio.livraria.api_2024.model.StudentReadList;
import me.dio.livraria.api_2024.model.NoBookStoredException;
import me.dio.livraria.api_2024.repository.BookRepository;
import me.dio.livraria.api_2024.repository.StudentReadListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service

public class StudentReadListService {

    @Autowired
    private final StudentReadListRepository clientRepository;
    @Autowired
    final BookRepository bookRepository;


    public StudentReadListService(StudentReadListRepository studentReadListRepository, BookRepository bookRepository) {
        this.clientRepository = studentReadListRepository;
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<StudentReadList> findById(Long id) {
        return ResponseEntity.ok(clientRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }


    public ResponseEntity<Iterable<StudentReadList>> findAll() {
        return ResponseEntity.ok(clientRepository.findAll());
    }


    public ResponseEntity<StudentReadList> createNewClient(StudentReadList studentReadList) throws NoBookStoredException {


        if (studentReadList !=null) {

            if (studentReadList.getClientBookList().isEmpty()) {

                throw new NoBookStoredException("No book added to this client");

            }

            List<Book> bookList = new ArrayList<>(studentReadList.getClientBookList());
            bookRepository.saveAll(bookList);


            return ResponseEntity.ok(clientRepository.save(studentReadList));

        } else {

            return null;

        }

    }


    public ResponseEntity<StudentReadList> updateClient(Long id, StudentReadList studentReadListToUpdate) throws NoBookStoredException {

        if (clientRepository.existsById(id)) {

            if (studentReadListToUpdate.getClientBookList().isEmpty()) {

                throw new NoBookStoredException("No book added to this client");


            }

            return ResponseEntity.ok(clientRepository.save(studentReadListToUpdate));


        } else return null;

    }


    public void deleteClientById(Long id) {

        clientRepository.deleteById(id);

    }






}

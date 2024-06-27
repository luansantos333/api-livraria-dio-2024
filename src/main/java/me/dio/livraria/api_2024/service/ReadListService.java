package me.dio.livraria.api_2024.service;

import me.dio.livraria.api_2024.model.Book;
import me.dio.livraria.api_2024.model.CollegeReadList;
import me.dio.livraria.api_2024.model.NoBookStoredException;
import me.dio.livraria.api_2024.repository.BookRepository;
import me.dio.livraria.api_2024.repository.CollegeReadListRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

@Service

public class ReadListService {

    @Autowired
    private final CollegeReadListRepository clientRepository;
    @Autowired
    final BookRepository bookRepository;


    public ReadListService(CollegeReadListRepository collegeReadListRepository, BookRepository bookRepository) {
        this.clientRepository = collegeReadListRepository;
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<CollegeReadList> findById(Long id) {
        return ResponseEntity.ok(clientRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }


    public ResponseEntity<Iterable<CollegeReadList>> findAll() {
        return ResponseEntity.ok(clientRepository.findAll());
    }


    public ResponseEntity<CollegeReadList> createNewClient(CollegeReadList collegeReadList) throws NoBookStoredException {


        if (collegeReadList !=null) {

            if (collegeReadList.getClientBookList().isEmpty()) {

                throw new NoBookStoredException("No book added to this client");

            }

            List<Book> bookList = new ArrayList<>(collegeReadList.getClientBookList());
            bookRepository.saveAll(bookList);


            return ResponseEntity.ok(clientRepository.save(collegeReadList));

        } else {

            return null;

        }

    }


    public ResponseEntity<CollegeReadList> updateClient(Long id, CollegeReadList collegeReadListToUpdate) throws NoBookStoredException {

        if (clientRepository.existsById(id)) {

            if (collegeReadListToUpdate.getClientBookList().isEmpty()) {

                throw new NoBookStoredException("No book added to this client");


            }

            return ResponseEntity.ok(clientRepository.save(collegeReadListToUpdate));


        } else return null;

    }


    public void deleteClientById(Long id) {

        clientRepository.deleteById(id);

    }






}

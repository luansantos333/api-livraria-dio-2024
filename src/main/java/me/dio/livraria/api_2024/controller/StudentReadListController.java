package me.dio.livraria.api_2024.controller;

import me.dio.livraria.api_2024.model.StudentReadList;
import me.dio.livraria.api_2024.model.NoBookStoredException;
import me.dio.livraria.api_2024.service.StudentReadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")

public class StudentReadListController {

    @Autowired
    StudentReadListService studentReadListService;


    @GetMapping
    public ResponseEntity<Iterable<StudentReadList>> getAllClients () {


        return studentReadListService.findAll();

    }



    @GetMapping ("/{id}")
    public ResponseEntity<StudentReadList> getClientByID (@PathVariable("id") Long id) {

        return studentReadListService.findById(id);

    }


    @PostMapping("/add")
    public ResponseEntity<StudentReadList> addNewClient (@RequestBody StudentReadList studentReadList) {

        try {
            return studentReadListService.createNewClient(studentReadList);
        } catch (NoBookStoredException e) {
            throw new RuntimeException(e);
        }

    }


    @PutMapping ("/update/{id}")
    public ResponseEntity<StudentReadList> updateClient (@PathVariable ("id") Long id, StudentReadList studentReadList) {

        try {
            return studentReadListService.updateClient(id, studentReadList);
        } catch (NoBookStoredException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/remove/{id}")
    public void removeById (@PathVariable("id") Long id) {

        studentReadListService.deleteClientById(id);

    }



}

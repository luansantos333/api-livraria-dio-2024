package me.dio.livraria.api_2024.controller;

import me.dio.livraria.api_2024.model.CollegeReadList;
import me.dio.livraria.api_2024.model.NoBookStoredException;
import me.dio.livraria.api_2024.service.ReadListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/client")

public class CollegeReadListController {

    @Autowired
    ReadListService readListService;


    @GetMapping
    public ResponseEntity<Iterable<CollegeReadList>> getAllClients () {


        return readListService.findAll();

    }



    @GetMapping ("/{id}")
    public ResponseEntity<CollegeReadList> getClientByID (@PathVariable("id") Long id) {

        return readListService.findById(id);

    }


    @PostMapping("/add")
    public ResponseEntity<CollegeReadList> addNewClient (@RequestBody CollegeReadList collegeReadList) {

        try {
            return readListService.createNewClient(collegeReadList);
        } catch (NoBookStoredException e) {
            throw new RuntimeException(e);
        }

    }


    @PutMapping ("/update/{id}")
    public ResponseEntity<CollegeReadList> updateClient (@PathVariable ("id") Long id, CollegeReadList collegeReadList) {

        try {
            return readListService.updateClient(id, collegeReadList);
        } catch (NoBookStoredException e) {
            throw new RuntimeException(e);
        }
    }

    @DeleteMapping ("/remove/{id}")
    public void removeById (@PathVariable("id") Long id) {

        readListService.deleteClientById(id);

    }



}

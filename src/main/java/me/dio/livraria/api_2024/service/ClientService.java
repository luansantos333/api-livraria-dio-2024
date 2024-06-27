package me.dio.livraria.api_2024.service;

import me.dio.livraria.api_2024.model.Book;
import me.dio.livraria.api_2024.model.Client;
import me.dio.livraria.api_2024.repository.ClientRepository;
import me.dio.livraria.api_2024.repository.ClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import java.util.NoSuchElementException;

public class ClientService {

    @Autowired
    private final ClientRepository clientRepository;


    public ClientService(ClientRepository clientRepository) {
        this.clientRepository = clientRepository;
    }

    public ResponseEntity<Client> findById(Long id) {
        return ResponseEntity.ok(clientRepository.findById(id).orElseThrow(NoSuchElementException::new));
    }


    public ResponseEntity<Iterable<Client>> findAll() {
        return ResponseEntity.ok(clientRepository.findAll());
    }


    public ResponseEntity<Client> createNewClient(Client client) {

        if (client!=null) {

            return ResponseEntity.ok(clientRepository.save(client));

        } else {

            return null;

        }

    }


    public ResponseEntity<Client> updateClient(Long id, Client clientToUpdate) {

        if (clientRepository.existsById(id)) {

            return ResponseEntity.ok(clientRepository.save(clientToUpdate));


        } else return null;

    }


    public void deleteClientById(Long id) {

        clientRepository.deleteById(id);

    }






}

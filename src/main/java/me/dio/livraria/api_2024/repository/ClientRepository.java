package me.dio.livraria.api_2024.repository;

import me.dio.livraria.api_2024.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClientRepository extends CrudRepository <Client, Long> {


}

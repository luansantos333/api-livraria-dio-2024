package me.dio.livraria.api_2024.repository;

import me.dio.livraria.api_2024.model.StudentReadList;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface CollegeReadListRepository extends CrudRepository <StudentReadList, Long> {


}

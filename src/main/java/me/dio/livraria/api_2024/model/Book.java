package me.dio.livraria.api_2024.model;

import jakarta.persistence.*;

@Entity(name = "tb_livro")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String author;
    private Double price;



}

package me.dio.livraria.api_2024.model;

import jakarta.persistence.*;

import java.util.List;

@Entity(name = "tb_client")
public class CollegeReadList {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(length = 10)
    private String username;
    private String name;
    private int age;
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Book> clientBookList;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Book> getClientBookList() {
        return clientBookList;
    }

    public void setClientBookList(List<Book> clientBookList) {
        this.clientBookList = clientBookList;
    }
}

package com.example.AI_proj_software.jogador;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;

@Document
public class Jogador {
    @Id
    private Integer id;

    private String nome;

    private Integer idade;

    private ArrayList<String> times = new ArrayList<>();

    public Jogador() {
    }

    public Jogador(Integer id, String nome, Integer idade, ArrayList<String> times) {
        this.id = id;
        this.nome = nome;
        this.idade = idade;
        this.times = times;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public ArrayList<String> getTimes() {
        return times;
    }

    public void setTimes(ArrayList<String> times) {
        this.times = times;
    }
}


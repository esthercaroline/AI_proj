package com.example.AI_proj_software.jogador;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JogadorRepository extends MongoRepository<Jogador, Integer> {

}

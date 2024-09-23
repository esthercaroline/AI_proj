package com.example.AI_proj_software.time;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class TimeService {
    public ResponseEntity<Time> getTime(Integer identificador) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForEntity(
                "http://campeonato:8080/time/" + identificador,
                Time.class);

    }
}

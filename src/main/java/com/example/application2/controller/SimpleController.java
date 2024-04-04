package com.example.application2.controller;

import com.example.application2.model.RequestDTO;
import com.example.application2.model.Response;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("application2")
@AllArgsConstructor
public class SimpleController {
    private RestTemplate restTemplate;

    @GetMapping
    public Response getResponse() {
        ResponseEntity<Response> response = restTemplate.getForEntity("http://localhost:8080/response",
                Response.class);
        return response.getBody();
    }

    @PostMapping
    public String getName(@RequestBody RequestDTO requestDTO) {
        HttpEntity<RequestDTO> requestDTOHttpEntity = new HttpEntity<>(requestDTO);
        ResponseEntity<String> stringResponseEntity = restTemplate.postForEntity("http://localhost:8080/response",
                requestDTOHttpEntity, String.class);
        return stringResponseEntity.getBody();

    }
}

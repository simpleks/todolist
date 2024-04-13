package com.example.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

//@WebServlet(name = "Lang", urlPatterns = {"/chuj/langs"}) //jak będzie localhost:8080/chuj/"WYJEBANE CO" wyświetli się resp.getWrtitter()
@RestController
@RequestMapping("/api")
class LangServlet {

    private final Logger logger = LoggerFactory.getLogger(LangServlet.class);
    private LangService service;

    LangServlet(LangRepository repository) {
        this.service = new LangService(repository);
    }

    @GetMapping("/langs")
    ResponseEntity<List<LangDTO>> findAllLangs() {
        logger.info("Got request ");
        return ResponseEntity.ok(service.findAll());
    }
}

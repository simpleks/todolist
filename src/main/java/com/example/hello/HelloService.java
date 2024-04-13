package com.example.hello;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class HelloService {
    public static final String FALLBACK_NAME = "world"; // fajny skrót ctrl + alt + c  // jeśli url będzie bez parametrów
    //to wyświetli się deflautowo język ang z napisem hello world

    static final Lang FALLBACK_LANG = new Lang(1, "Hello [en]", "en"); // fajny skrót ctrl + alt + c
    //jeśli lang wyjdzie poza zakres to wyświetli się hello [en] + fallback_name
    private final Logger logger = LoggerFactory.getLogger(HelloService.class);

    private LangRepository repository;

    HelloService(LangRepository repository) {
        this.repository = repository;
    }

    //http://localhost:8080/chuj?name=sperma

    public String prepareGreeting(String name, Integer langId) {
        langId = Optional.ofNullable(langId).orElse(FALLBACK_LANG.getId());
        var welcomeMsg = repository.findById(langId).orElse(FALLBACK_LANG).getWelcomeMsg();
        var nameToWelcome = Optional.ofNullable(name).orElse(FALLBACK_NAME);
        return welcomeMsg + " " + nameToWelcome + " !";
    }
}

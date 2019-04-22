package com.urlshortener.redirectshorturl.controllers;

import com.urlshortener.redirectshorturl.models.ShortenedURLInformation;
import com.urlshortener.redirectshorturl.services.ShortURLRedirector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/**")
public class LambdaController {

    @Autowired
    private ShortURLRedirector shortUrlRedirector;

    @PostMapping
    public ResponseEntity<ShortenedURLInformation> get(
            @Validated @RequestBody ShortenedURLInformation shortenedURLInformation
    ) {
        Optional<ShortenedURLInformation> response = shortUrlRedirector.apply(shortenedURLInformation);

        return response.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

}

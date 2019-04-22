package com.urlshortener.createshorturl.controllers;

import com.urlshortener.createshorturl.models.ShortenedURLInformation;
import com.urlshortener.createshorturl.services.URLShortener;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/**")
public class LambdaController {

    @Autowired
    private URLShortener urlShortener;

    @PostMapping
    public ResponseEntity<ShortenedURLInformation> get(
            @Validated @RequestBody ShortenedURLInformation shortenedURLInformation
    ) {
        Optional<ShortenedURLInformation> response = urlShortener.apply(shortenedURLInformation);

        return response.map(ResponseEntity::ok).orElse(ResponseEntity.badRequest().build());
    }

}

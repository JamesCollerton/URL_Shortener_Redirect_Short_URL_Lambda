package com.urlshortener.redirectshorturl.controllers;

import com.urlshortener.redirectshorturl.exceptions.ResourceNotFoundException;
import com.urlshortener.redirectshorturl.models.ShortenedUrlInformation;
import com.urlshortener.redirectshorturl.services.ShortUrlRedirector;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.xml.ws.Response;
import java.util.Optional;

@Controller
@Slf4j
@RequestMapping("/**")
public class LambdaController {


    @Autowired
    private ShortUrlRedirector shortUrlRedirector;

    @PostMapping
    public RedirectView get(
            @Validated @RequestBody ShortenedUrlInformation shortenedUrlInformation
    ) {
        Optional<ShortenedUrlInformation> response = shortUrlRedirector.apply(shortenedUrlInformation);

        return response.map(ShortenedUrlInformation::getLongUrl).map(RedirectView::new).orElseThrow(
                () -> new ResourceNotFoundException(shortenedUrlInformation.getShortUrl())
        );
    }

}

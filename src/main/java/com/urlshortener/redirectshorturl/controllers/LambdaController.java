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
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import javax.xml.ws.Response;
import java.util.Optional;
import java.util.UUID;

@Controller
@Slf4j
@RequestMapping("/shortened-url-information/{short-url}/**")
public class LambdaController {

    @Autowired
    private ShortUrlRedirector shortUrlRedirector;

    @GetMapping
    public RedirectView get(
            @PathVariable("short-url") String shortUrl
    ) {
        String uuid = UUID.randomUUID().toString();

        log.info(String.format("%s Received request with path parameter %s", uuid, shortUrl));

        Optional<ShortenedUrlInformation> response = shortUrlRedirector.apply(shortUrl);

        log.info(String.format("%s Returning response %s", uuid, response));

        return response.map(ShortenedUrlInformation::getLongUrl).map(RedirectView::new).orElseThrow(
                () -> new ResourceNotFoundException(shortUrl)
        );
    }

}

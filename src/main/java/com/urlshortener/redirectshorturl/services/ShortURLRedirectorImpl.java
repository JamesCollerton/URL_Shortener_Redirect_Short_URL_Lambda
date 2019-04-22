package com.urlshortener.redirectshorturl.services;

import com.urlshortener.redirectshorturl.models.ShortenedURLInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortURLRedirectorImpl implements ShortURLRedirector {

    @Autowired
    URLHasher urlHasher;

    @Override
    public Optional<ShortenedURLInformation> apply(ShortenedURLInformation shortenedURLInformation) {

        Optional<String> shortUrl = Optional.of(shortenedURLInformation.getShortUrl());

        // Still needs DB step
        return shortUrl
                .map(s -> new ShortenedURLInformation("https://www.google.com/maps", s));

    }

}

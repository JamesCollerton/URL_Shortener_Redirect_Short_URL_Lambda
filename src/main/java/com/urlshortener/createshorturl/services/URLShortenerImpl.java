package com.urlshortener.createshorturl.services;

import com.urlshortener.createshorturl.models.ShortenedURLInformation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class URLShortenerImpl implements URLShortener {

    @Autowired
    URLHasher urlHasher;

    @Override
    public Optional<ShortenedURLInformation> apply(ShortenedURLInformation shortenedURLInformation) {

        Optional<String> longUrl = Optional.of(shortenedURLInformation.getLongUrl());

        // Still needs DB step
        return longUrl
                .map(urlHasher)
                .map(s -> new ShortenedURLInformation(longUrl.get(), s));

    }

}

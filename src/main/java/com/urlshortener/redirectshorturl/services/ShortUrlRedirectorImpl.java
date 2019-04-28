package com.urlshortener.redirectshorturl.services;

import com.urlshortener.redirectshorturl.models.ShortenedUrlInformation;
import com.urlshortener.redirectshorturl.repositories.ShortenedUrlInformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ShortUrlRedirectorImpl implements ShortUrlRedirector {

    @Autowired
    ShortenedUrlInformationRepository shortenedUrlInformationRepository;

    @Override
    public Optional<ShortenedUrlInformation> apply(ShortenedUrlInformation shortenedUrlInformation) {

//        Optional<ShortenedUrlInformation> storedUrlInformation = shortenedUrlInformationRepository.findByShortUrl(
//                shortenedUrlInformation.getShortUrl()
//        );

        Optional<String> shortUrl = Optional.of(shortenedUrlInformation.getShortUrl());

        // Still needs DB step
        return shortUrl
                .map(s -> new ShortenedUrlInformation("id", "https://www.google.com/maps", s));

    }

}

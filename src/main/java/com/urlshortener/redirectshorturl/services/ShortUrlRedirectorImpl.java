package com.urlshortener.redirectshorturl.services;

import com.urlshortener.redirectshorturl.models.ShortenedUrlInformation;
import com.urlshortener.redirectshorturl.repositories.ShortenedUrlInformationRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@Service
public class ShortUrlRedirectorImpl implements ShortUrlRedirector {

    @Autowired
    ShortenedUrlInformationRepository shortenedUrlInformationRepository;

    @Override
    public Optional<ShortenedUrlInformation> apply(String shortUrl) {

        log.info(String.format("Redirecting for shortUrl %s", shortUrl));

        return shortenedUrlInformationRepository.findByShortUrl(shortUrl);

    }

}

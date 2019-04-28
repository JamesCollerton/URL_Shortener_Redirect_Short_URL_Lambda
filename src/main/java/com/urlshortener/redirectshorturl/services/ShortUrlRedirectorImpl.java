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

        return shortenedUrlInformationRepository.findByShortUrl(
                shortenedUrlInformation.getShortUrl()
        );

    }

}

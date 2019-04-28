package com.urlshortener.redirectshorturl.repositories;

import com.urlshortener.redirectshorturl.models.ShortenedUrlInformation;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

@EnableScan
public interface ShortenedUrlInformationRepository extends
        CrudRepository<ShortenedUrlInformation, String> {

    public Optional<ShortenedUrlInformation> findByShortUrl(String shortUrl);

}

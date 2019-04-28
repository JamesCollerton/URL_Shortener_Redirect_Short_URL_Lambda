package com.urlshortener.redirectshorturl.services;

import com.urlshortener.redirectshorturl.models.ShortenedUrlInformation;

import java.util.Optional;
import java.util.function.Function;

public interface ShortUrlRedirector extends Function<ShortenedUrlInformation, Optional<ShortenedUrlInformation>> {

    Optional<ShortenedUrlInformation> apply(ShortenedUrlInformation shortenedUrlInformation);

}

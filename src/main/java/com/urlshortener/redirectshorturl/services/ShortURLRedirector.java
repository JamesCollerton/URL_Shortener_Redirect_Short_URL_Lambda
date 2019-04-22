package com.urlshortener.redirectshorturl.services;

import com.urlshortener.redirectshorturl.models.ShortenedURLInformation;

import java.util.Optional;
import java.util.function.Function;

public interface ShortURLRedirector extends Function<ShortenedURLInformation, Optional<ShortenedURLInformation>> {

    Optional<ShortenedURLInformation> apply(ShortenedURLInformation shortenedURLInformation);

}

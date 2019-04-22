package com.urlshortener.createshorturl.services;

import com.urlshortener.createshorturl.models.ShortenedURLInformation;

import java.util.Optional;
import java.util.function.Function;

public interface URLShortener extends Function<ShortenedURLInformation, Optional<ShortenedURLInformation>> {

    Optional<ShortenedURLInformation> apply(ShortenedURLInformation shortenedURLInformation);

}

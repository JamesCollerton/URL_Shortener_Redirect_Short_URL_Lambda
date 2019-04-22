package com.urlshortener.redirectshorturl.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortenedURLInformation {

    private String longUrl;

    @NotEmpty(message = "{shortUrl.notEmpty}")
    private String shortUrl;

}

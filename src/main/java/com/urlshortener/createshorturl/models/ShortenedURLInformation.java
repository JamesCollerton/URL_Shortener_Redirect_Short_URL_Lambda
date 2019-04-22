package com.urlshortener.createshorturl.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShortenedURLInformation {

    @NotEmpty(message = "{longUrl.notEmpty}")
    private String longUrl;

    private String shortUrl;

}

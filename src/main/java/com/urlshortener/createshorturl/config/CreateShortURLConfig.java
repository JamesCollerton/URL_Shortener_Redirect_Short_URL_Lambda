package com.urlshortener.createshorturl.config;

import com.urlshortener.createshorturl.controllers.LambdaController;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ LambdaController.class })
public class CreateShortURLConfig {
}

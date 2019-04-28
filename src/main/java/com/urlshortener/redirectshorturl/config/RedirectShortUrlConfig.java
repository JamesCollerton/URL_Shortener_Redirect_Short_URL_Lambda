package com.urlshortener.redirectshorturl.config;

import com.urlshortener.redirectshorturl.controllers.LambdaController;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({ LambdaController.class })
public class RedirectShortUrlConfig {
}

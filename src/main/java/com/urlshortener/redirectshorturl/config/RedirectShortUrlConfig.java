package com.urlshortener.redirectshorturl.config;

import com.urlshortener.redirectshorturl.controllers.LambdaController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Slf4j
@Configuration
@Import({ LambdaController.class })
public class RedirectShortUrlConfig {
}

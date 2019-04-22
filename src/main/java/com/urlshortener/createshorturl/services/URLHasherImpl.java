package com.urlshortener.createshorturl.services;

import org.springframework.stereotype.Service;

@Service
public class URLHasherImpl implements URLHasher {

    @Override
    public String apply(String s) {
        return Integer.toString(s.hashCode());
    }

}

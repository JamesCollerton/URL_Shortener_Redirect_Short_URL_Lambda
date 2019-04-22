package com.urlshortener.redirectshorturl.services;

import java.util.function.Function;

public interface URLHasher extends Function<String, String> {

    String apply(String s);

}
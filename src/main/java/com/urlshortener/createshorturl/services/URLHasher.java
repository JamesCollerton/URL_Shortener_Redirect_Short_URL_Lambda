package com.urlshortener.createshorturl.services;

import java.util.function.Function;

public interface URLHasher extends Function<String, String> {

    String apply(String s);

}

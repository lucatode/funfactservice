package com.lucatode.funfactservice.domain.repository;

public interface Logger  {

    void info(String source, String message);
    void warn(String source, String message);
    void err(String source, String message);

}

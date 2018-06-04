package com.lucatode.funfactservice.domain;

public interface TimeProvider {

    void init();
    boolean isDayTime();
    int getDelay();
}

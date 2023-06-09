package com.demo.design.mode_c_behavior.c_observer;

/**
 * Subject: 目标
 */
public interface Subject {
    void attach(Observer observer);

    void detach(Observer observer);

    void changData(float v, float v1);

    void notifyObserver();
}
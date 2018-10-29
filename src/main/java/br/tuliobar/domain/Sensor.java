package br.tuliobar.domain;

public interface Sensor {

    String getUuid();
    int getValue();
    void setValue(int value);
}

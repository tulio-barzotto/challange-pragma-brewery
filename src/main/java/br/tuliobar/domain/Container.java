package br.tuliobar.domain;

import br.tuliobar.enums.Beer;
import br.tuliobar.exception.SensorException;

public interface Container {

    String getUuid();
    SensorTemperature getSensorTemperature();
    void updateSensorTemperature(int temperature) throws SensorException;
    Beer getBeer();
}

package br.tuliobar.domain;

import br.tuliobar.enums.Beer;
import br.tuliobar.exception.SensorException;

import java.util.Objects;
import java.util.UUID;

public class ContainerImpl implements Container {

    private String uuid;

    private SensorTemperature sensorTemperature;

    private Beer beer;

    public ContainerImpl(String uuid, Beer beer) throws IllegalArgumentException {
        if(uuid == null || beer == null) {
            throw new IllegalArgumentException();
        }
        this.uuid = uuid;
        this.sensorTemperature = new SensorTemperature(UUID.randomUUID().toString());
        this.beer = beer;
    }

    @Override
    public String getUuid() {
        return this.uuid;
    }

    public SensorTemperature getSensorTemperature() {
        return this.sensorTemperature;
    }

    @Override
    public void updateSensorTemperature(int temperature) throws SensorException {
        if(temperature < beer.getMinTemperature()) {
            throw new SensorException("Temperatura do Container está abaixo do permitido. Atual " + temperature + "° C");
        } else if (temperature > beer.getMaxTemperature()) {
            throw new SensorException("Temperatura do Container está acima do permitido. Atual " + temperature + "° C");
        } else {
            this.sensorTemperature.setValue(temperature);
        }
    }

    public Beer getBeer() {
        return this.beer;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContainerImpl container = (ContainerImpl) o;
        return Objects.equals(sensorTemperature, container.sensorTemperature) &&
                beer == container.beer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(sensorTemperature, beer);
    }
}

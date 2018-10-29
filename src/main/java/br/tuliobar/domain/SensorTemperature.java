package br.tuliobar.domain;

public class SensorTemperature implements Sensor {

    private String uuid;
    private int temperature;

    public SensorTemperature(String uuid) {
        this.uuid = uuid;
        this.temperature = 0; //Default value
    }

    public String getUuid() {
        return this.uuid;
    }

    public int getValue() {
        return this.temperature;
    }

    public void setValue(int temperature) {
        this.temperature = temperature;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SensorTemperature that = (SensorTemperature) o;
        if (temperature != that.temperature) return false;
        return uuid.equals(that.uuid);
    }

    @Override
    public int hashCode() {
        int result = uuid.hashCode();
        result = 31 * result + temperature;
        return result;
    }
}

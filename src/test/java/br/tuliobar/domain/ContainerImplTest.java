package br.tuliobar.domain;

import br.tuliobar.enums.Beer;
import br.tuliobar.exception.SensorException;
import org.junit.Test;

import java.util.UUID;


public class ContainerImplTest {

    @Test(expected = IllegalArgumentException.class)
    public void deveLancarExcecaoParametroInvalidos() {
        new ContainerImpl(null, null);
    }

    @Test(expected = SensorException.class)
    public void deveLancarExcecaoSensorTemperatura() throws SensorException {
        Container container = new ContainerImpl(UUID.randomUUID().toString(), Beer.IPA);
        container.updateSensorTemperature(-20);
    }
}
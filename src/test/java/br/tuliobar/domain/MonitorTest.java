package br.tuliobar.domain;

import br.tuliobar.enums.Beer;
import org.junit.Before;
import org.junit.Test;

import java.util.UUID;

import static org.junit.Assert.*;

public class MonitorTest {

    private Monitor monitor;

    @Before
    public void setUp() {
        monitor = new Monitor();
    }

    @Test
    public void getContainerByUuid() {
        String uuid = UUID.randomUUID().toString();
        monitor.addContainer(new ContainerImpl(uuid, Beer.IPA));
        Container container = monitor.getContainerByUuid(uuid);
        assertNotNull(container);
        assertEquals(uuid, container.getUuid());
    }

    @Test
    public void deveAtualizarSemGerarNotificacao() {
        int temperature = -6;
        String uuid = UUID.randomUUID().toString();
        monitor.addContainer(new ContainerImpl(uuid, Beer.IPA));
        monitor.updateSensorTemperatureByUuidContainer(uuid, temperature);
        Container container = monitor.getContainerByUuid(uuid);
        assertTrue(monitor.getNotifications().isEmpty());
        assertEquals(temperature, container.getSensorTemperature().getValue());
    }

    @Test
    public void deveAtualizarEGerarNotificacao() {
        int temperature = -12;
        String uuid = UUID.randomUUID().toString();
        monitor.addContainer(new ContainerImpl(uuid, Beer.WHEAT_BEER));
        monitor.updateSensorTemperatureByUuidContainer(uuid, temperature);
        Container container = monitor.getContainerByUuid(uuid);
        assertFalse(monitor.getNotifications().isEmpty());
        assertEquals(temperature, container.getSensorTemperature().getValue());
    }
}
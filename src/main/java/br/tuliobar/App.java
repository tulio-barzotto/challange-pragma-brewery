package br.tuliobar;

import br.tuliobar.domain.Container;
import br.tuliobar.domain.ContainerImpl;
import br.tuliobar.domain.Monitor;
import br.tuliobar.enums.Beer;
import br.tuliobar.utils.TemperatureGenerator;

import java.util.List;
import java.util.UUID;

public class App {
    /**
     * Program entry point
     *
     * @param args command line args
     */
    public static void main(String[] args) {
        Monitor monitor = initializeMonitorDefault();
        simulateUpdateSensorTemperature(10, monitor);
    }

    private static void simulateUpdateSensorTemperature(int times, Monitor monitor) {
        List<Container> containerList = monitor.getAllContainers();
        for(int i=0; i < times; i ++) {
            for(Container container : containerList) {
                monitor.updateSensorTemperatureByUuidContainer(container.getUuid(), TemperatureGenerator.getRandomTemperature());
            }
        }
    }

    private static Monitor initializeMonitorDefault() {
        Monitor monitor = new Monitor();

        Container container1 = new ContainerImpl(UUID.randomUUID().toString(), Beer.PILSNER);
        Container container2 = new ContainerImpl(UUID.randomUUID().toString(), Beer.IPA);
        Container container3 = new ContainerImpl(UUID.randomUUID().toString(), Beer.LAGER);
        Container container4 = new ContainerImpl(UUID.randomUUID().toString(), Beer.STOUT);
        Container container5 = new ContainerImpl(UUID.randomUUID().toString(), Beer.WHEAT_BEER);
        Container container6 = new ContainerImpl(UUID.randomUUID().toString(), Beer.PALE_ALE);

        monitor.addContainer(container1);
        monitor.addContainer(container2);
        monitor.addContainer(container3);
        monitor.addContainer(container4);
        monitor.addContainer(container5);
        monitor.addContainer(container6);

        return monitor;
    }
}

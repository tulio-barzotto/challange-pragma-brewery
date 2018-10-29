package br.tuliobar.domain;

import br.tuliobar.exception.SensorException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class Monitor implements Monitorable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ContainerImpl.class);

    private List<Container> containers;

    private List<Notification> notifications;

    public Monitor() {
        this.containers = new ArrayList<>();
        this.notifications = new ArrayList<>();
    }

    @Override
    public Container getContainerByUuid(String uuid) {
        return containers.stream()
                .filter(container -> container.getUuid()
                        .equals(uuid))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addContainer(Container container) {
        if(container != null) {
            this.containers.add(container);
        }
    }

    @Override
    public List<Container> getAllContainers() {
        return containers;
    }

    @Override
    public void updateSensorTemperatureByUuidContainer(String uuid, int temperature) {
        Container container = this.getContainerByUuid(uuid);
        if(container != null) {
            try {
                container.updateSensorTemperature(temperature);
            } catch (SensorException se) {
                Notification notification = new Notification(container, se.getMessage());
                notifications.add(notification);
                LOGGER.info(notification.getMessage());
            }
        }
    }

    @Override
    public List<Notification> getNotifications() {
        return notifications;
    }
}

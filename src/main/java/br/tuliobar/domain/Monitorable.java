package br.tuliobar.domain;

import java.util.List;

public interface Monitorable {

    Container getContainerByUuid(String uuid);
    void addContainer(Container container);
    List<Container> getAllContainers();
    void updateSensorTemperatureByUuidContainer(String uuid, int temperature);
    List<Notification> getNotifications();
}

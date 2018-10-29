package br.tuliobar.domain;

import br.tuliobar.utils.DateFormatterUtil;

import java.time.LocalDateTime;

public class Notification {

    private Container container;

    private LocalDateTime dateTime;

    private String message;

    public Notification(Container container, String message) {
        this.container = container;
        this.dateTime = LocalDateTime.now();
        this.message = message;
    }

    public String getMessage() {
        return String.format("[%s]. O Container uuid: %s , Tipo cerveja: %s , Mensagem: %s",
                DateFormatterUtil.formatLocalDateTime(dateTime),
                container.getUuid(),
                container.getBeer().getName(),
                message);
    }
}

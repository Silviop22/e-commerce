package de.dlh.lhind.order.infrastructure.jms.configuration.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(value = "order.application.jms.producer.order")
public class JmsPublisherConfigurationProperties {

    private boolean deliveryPersistent;
    private boolean sessionTransacted;
    private String defaultTopic;

    public boolean isDeliveryPersistent() {
        return deliveryPersistent;
    }

    public void setDeliveryPersistent(boolean deliveryPersistent) {
        this.deliveryPersistent = deliveryPersistent;
    }

    public boolean isSessionTransacted() {
        return sessionTransacted;
    }

    public void setSessionTransacted(boolean sessionTransacted) {
        this.sessionTransacted = sessionTransacted;
    }

    public String getDefaultTopic() {
        return defaultTopic;
    }

    public void setDefaultTopic(String defaultTopic) {
        this.defaultTopic = defaultTopic;
    }
}

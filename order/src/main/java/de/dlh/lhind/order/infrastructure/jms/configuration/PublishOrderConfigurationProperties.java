package de.dlh.lhind.order.infrastructure.jms.configuration;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("order.application.jms.publish.order")
public class PublishOrderConfigurationProperties {

    private String topic;
    private boolean deliveryPersistent;
    private boolean sessionTruncated;

    public String getTopic() {
        return topic;
    }

    public void setTopic(final String topic) {
        this.topic = topic;
    }

    public boolean isDeliveryPersistent() {
        return deliveryPersistent;
    }

    public void setDeliveryPersistent(final boolean deliveryPersistent) {
        this.deliveryPersistent = deliveryPersistent;
    }

    public boolean isSessionTruncated() {
        return sessionTruncated;
    }

    public void setSessionTruncated(final boolean sessionTruncated) {
        this.sessionTruncated = sessionTruncated;
    }
}

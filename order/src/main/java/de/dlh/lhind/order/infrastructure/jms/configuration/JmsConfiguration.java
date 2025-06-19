package de.dlh.lhind.order.infrastructure.jms.configuration;

import de.dlh.lhind.order.infrastructure.jms.configuration.properties.JmsPublisherConfigurationProperties;
import jakarta.jms.ConnectionFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@EnableConfigurationProperties(JmsPublisherConfigurationProperties.class)
@EnableJms
@Configuration
public class JmsConfiguration {

    @Bean
    public JmsTemplate jmsTemplate(final ConnectionFactory connectionFactory,
                                   final JmsPublisherConfigurationProperties jmsPublisherConfigurationProperties) {
        final JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setDeliveryPersistent(jmsPublisherConfigurationProperties.isDeliveryPersistent());
        jmsTemplate.setSessionTransacted(jmsPublisherConfigurationProperties.isSessionTransacted());
        jmsTemplate.setDefaultDestinationName(jmsPublisherConfigurationProperties.getDefaultTopic());

        return jmsTemplate;
    }
}

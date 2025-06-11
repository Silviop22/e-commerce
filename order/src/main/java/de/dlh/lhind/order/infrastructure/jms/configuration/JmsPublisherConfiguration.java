package de.dlh.lhind.order.infrastructure.jms.configuration;

import jakarta.jms.ConnectionFactory;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.core.JmsTemplate;

@Configuration
@EnableJms
@EnableConfigurationProperties(PublishOrderConfigurationProperties.class)
public class JmsPublisherConfiguration {

    @Bean
    public JmsTemplate jmsTemplate(final ConnectionFactory connectionFactory,
                                   final PublishOrderConfigurationProperties publishOrderConfigurationProperties) {

        final JmsTemplate template = new JmsTemplate(connectionFactory);
        template.setDeliveryPersistent(publishOrderConfigurationProperties.isDeliveryPersistent());
        template.setSessionTransacted(publishOrderConfigurationProperties.isSessionTruncated());

        template.setDefaultDestinationName(publishOrderConfigurationProperties.getTopic());

        return template;
    }
}

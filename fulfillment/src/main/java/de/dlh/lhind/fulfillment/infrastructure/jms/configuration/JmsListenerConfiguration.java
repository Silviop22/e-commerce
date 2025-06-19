package de.dlh.lhind.fulfillment.infrastructure.jms.configuration;

import jakarta.jms.ConnectionFactory;
import jakarta.jms.Session;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@EnableJms
@Configuration
public class JmsListenerConfiguration {

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(final ConnectionFactory connectionFactory) {
        final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("1");
        factory.setSessionAcknowledgeMode(Session.SESSION_TRANSACTED);
        factory.setSessionTransacted(true);

        return factory;
    }
}

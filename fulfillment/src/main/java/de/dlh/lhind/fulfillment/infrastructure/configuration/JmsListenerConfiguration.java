package de.dlh.lhind.fulfillment.infrastructure.configuration;

import jakarta.jms.ConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

@Configuration
@EnableJms
public class JmsListenerConfiguration {

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerFactory(final ConnectionFactory connectionFactory) {
        final DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        factory.setConnectionFactory(connectionFactory);
        factory.setConcurrency("1-5");
        factory.setSessionTransacted(true);
        return factory;
    }
}

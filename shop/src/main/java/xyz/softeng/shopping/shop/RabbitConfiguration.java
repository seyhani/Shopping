package xyz.softeng.shopping.shop;

import org.springframework.amqp.core.ExchangeBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import xyz.softeng.shopping.common.configuration.RabbitBaseConfiguration;

@Configuration
@Import(RabbitBaseConfiguration.class)
public class RabbitConfiguration {
    @Bean
    public FanoutExchange purchaseExchange(ShopServiceProperties properties) {
        return ExchangeBuilder.fanoutExchange(properties.getPurchaseExchange()).build();
    }

    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory, FanoutExchange purchaseExchange, MessageConverter messageConverter) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setExchange(purchaseExchange.getName());
        rabbitTemplate.setMessageConverter(messageConverter);
        return rabbitTemplate;
    }
}

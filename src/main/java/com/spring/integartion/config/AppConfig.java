package com.spring.integartion.config;

import com.spring.integartion.model.Event;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.annotation.Filter;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.integration.channel.QueueChannel;
import org.springframework.integration.config.EnableIntegration;
import org.springframework.integration.core.MessageSelector;
import org.springframework.integration.dsl.IntegrationFlow;
import org.springframework.integration.router.RecipientListRouter;
import org.springframework.messaging.MessageChannel;

@Configuration

public class AppConfig {
    @Bean
    public MessageChannel eventChannel(){
        return new PublishSubscribeChannel();
    }

    @Bean
    public MessageChannel queueChannel1(){
        return new QueueChannel();
    }
    @Bean
    public MessageChannel queueChannel2(){
        return new QueueChannel();
    }
    @Bean
    public MessageChannel queueChannel3(){
        return new QueueChannel();
    }

    @Bean
    public MessageChannel filterChannel(){
        return new QueueChannel();
    }
    @ServiceActivator(inputChannel = "queueChannel1")
    @Bean(name = "Router1")
    public RecipientListRouter router(){
        RecipientListRouter router=new RecipientListRouter();
        router.addRecipient("queueChannel2");
        router.addRecipient("queueChannel3");
        return router;
    }

    @ServiceActivator(inputChannel = "queueChannel1")
    @Bean(name = "Router2")
    public RecipientListRouter router2(){
        RecipientListRouter router=new RecipientListRouter();
        router.addRecipient("queueChannel3");
        return router;
    }

    @Bean
    @Filter(inputChannel = "filterChannel",outputChannel ="queueChannel1" )
    public MessageSelector nocostFilter(){
        return message -> ((Event)message.getPayload()).getEventId()>5;
    }
}

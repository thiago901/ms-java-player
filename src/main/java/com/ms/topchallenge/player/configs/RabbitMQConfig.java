package com.ms.topchallenge.player.configs;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.databind.ObjectMapper;



@Configuration
public class RabbitMQConfig {


  @Value("${brocker.queue.player.create.name}")
  private String createQueue;
  
  @Value("${brocker.queue.player.list.name}")
  private String listQueue;
  
  @Value("${brocker.queue.player.update.name}")
  private String updateQueue;
  
  @Value("${brocker.queue.player.delete.name}")
  private String deleteQueue;
  
  @Value("${brocker.queue.player.show.name}")
  private String showQueue;
  

  @Bean
  public Queue createQueue(){
    return new Queue(createQueue,true);
  }

  @Bean
  public Queue listQueue(){
    return new Queue(listQueue,true);
  }
  @Bean
  public Queue updateQueue(){
    return new Queue(updateQueue,true);
  }
  @Bean
  public Queue deleteQueue(){
    return new Queue(deleteQueue,true);
  }
  @Bean
  public Queue showQueue(){
    return new Queue(showQueue,true);
  }


  @Bean
  public Jackson2JsonMessageConverter messageConverter(){
    ObjectMapper objectMapper = new ObjectMapper();
    return new Jackson2JsonMessageConverter(objectMapper);
  }
}

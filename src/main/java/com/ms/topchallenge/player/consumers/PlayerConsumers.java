package com.ms.topchallenge.player.consumers;


import org.springframework.amqp.rabbit.annotation.RabbitListener;

import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ms.topchallenge.player.dtos.RequestCreatePlayerDto;
import com.ms.topchallenge.player.dtos.RequestDeletePlayerDto;
import com.ms.topchallenge.player.dtos.RequestShowPlayerDto;
import com.ms.topchallenge.player.dtos.RequestUpdatePlayerDto;

import com.ms.topchallenge.player.models.PlayerModel;
import com.ms.topchallenge.player.useCases.CreatePlayerService;
import com.ms.topchallenge.player.useCases.DeletePlayerByIdService;
import com.ms.topchallenge.player.useCases.FetchPlayersService;
import com.ms.topchallenge.player.useCases.FindPlayerByIdService;
import com.ms.topchallenge.player.useCases.UpdatePlayerService;

@Component
public class PlayerConsumers {

  @Autowired
  CreatePlayerService createPlayerService;

  @Autowired
  DeletePlayerByIdService deletePlayerByIdService;

  @Autowired
  FetchPlayersService fetchPlayersService;

  @Autowired
  FindPlayerByIdService findPlayerByIdService;

  @Autowired
  UpdatePlayerService updatePlayerService;
  
  @RabbitListener(
    queues = "${brocker.queue.player.create.name}"
  )
  public void createPlayer(
    @Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String key,
    @Payload RequestCreatePlayerDto payload
  ){
    System.out.println("CREATE PLAYER" + payload);
    this.createPlayerService.execute(payload);
    System.out.println("Player Created");

  }
  
  @RabbitListener(
    queues = "${brocker.queue.player.list.name}"
  )
  public String  listPlayer() throws JsonProcessingException{
    
    var result = this.fetchPlayersService.execute();
    
    ObjectMapper objectMapper = new ObjectMapper();
    String jsonString = objectMapper.writeValueAsString(result);
    
    return jsonString;
  }
  
  @RabbitListener(
    queues = "${brocker.queue.player.update.name}"
  )
  public void updatePlayer(
    @Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String key,
    @Payload RequestUpdatePlayerDto payload
  ){
    System.out.println("UPDATE PLAYER" + payload);
    this.updatePlayerService.execute(payload.player_id(),payload.name());
    System.out.println("Player Updated");
  }
  
  @RabbitListener(
    queues = "${brocker.queue.player.delete.name}"
  )
  public void deletePlayer(
    @Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String key,
    @Payload RequestDeletePlayerDto payload
  ){
    System.out.println("payload " + payload + "key "+ key);
    this.deletePlayerByIdService.execute(payload.player_id());
  }
  
  @RabbitListener(
    queues = "${brocker.queue.player.show.name}"
  )
  public PlayerModel  showPlayer(
    @Header(AmqpHeaders.RECEIVED_ROUTING_KEY) String key,
    @Payload RequestShowPlayerDto payload
  ){
    System.out.println("payload " + payload + "key "+ key);
    return this.findPlayerByIdService.execute(payload.player_id());
  }
}

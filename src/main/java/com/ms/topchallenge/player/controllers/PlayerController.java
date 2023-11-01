package com.ms.topchallenge.player.controllers;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ms.topchallenge.player.dtos.RequestCreatePlayerDto;
import com.ms.topchallenge.player.models.PlayerModel;
import com.ms.topchallenge.player.useCases.CreatePlayerService;
import com.ms.topchallenge.player.useCases.DeletePlayerByIdService;
import com.ms.topchallenge.player.useCases.FetchPlayersService;
import com.ms.topchallenge.player.useCases.FindPlayerByIdService;
import com.ms.topchallenge.player.useCases.UpdatePlayerService;

import jakarta.websocket.server.PathParam;



@RestController
public class PlayerController {
  
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



  @PostMapping("/players")
  public ResponseEntity<Void> createUser(@RequestBody RequestCreatePlayerDto playerRecordDto){
    this.createPlayerService.execute(playerRecordDto);
    return ResponseEntity.status(HttpStatus.CREATED).build();
  }

  @GetMapping("/players")
  public ResponseEntity<List<PlayerModel>> listPlayers(){
    return ResponseEntity.status(HttpStatus.OK).body(this.fetchPlayersService.execute());
  }

  @GetMapping("/players/{player_id}")
  public ResponseEntity<PlayerModel> findPlayers(@PathParam("player_id") String playerId){
    return ResponseEntity.status(HttpStatus.OK).body(this.findPlayerByIdService.execute(playerId));
  }

  @DeleteMapping("/players")
  public ResponseEntity<Void> deletePlayers(@PathParam("player_id") String playerId){
    this.deletePlayerByIdService.execute(playerId);
    return ResponseEntity.status(HttpStatus.OK).build();
  }
}

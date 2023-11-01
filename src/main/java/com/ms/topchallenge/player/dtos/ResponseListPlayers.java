package com.ms.topchallenge.player.dtos;

import java.io.Serializable;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import com.ms.topchallenge.player.models.PlayerModel;

public class ResponseListPlayers implements Serializable {

  @JsonProperty
  private List<PlayerModel> players;

  static public ResponseListPlayers build(List<PlayerModel> players){
    var response = new ResponseListPlayers();
    response.setPlayers(players);
    
    
    return response;
  }

  private void setPlayers(List<PlayerModel> players) {
    this.players= players;
  }

  

  
  
}

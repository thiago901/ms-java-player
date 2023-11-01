package com.ms.topchallenge.player.useCases;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.topchallenge.player.dtos.RequestCreatePlayerDto;

import com.ms.topchallenge.player.errors.PlayerAlreadyExistsError;
import com.ms.topchallenge.player.models.PlayerModel;
import com.ms.topchallenge.player.repositories.PlayerRepository;



@Service()
public class CreatePlayerService {
  
  @Autowired
  PlayerRepository playerRepository;
  
  public PlayerModel execute(RequestCreatePlayerDto request) {
    var hasPlayer = this.playerRepository.findByEmail(request.email());
    if (hasPlayer!=null) {
      throw new PlayerAlreadyExistsError();
    }
    var playerModel = new PlayerModel();
    BeanUtils.copyProperties(request, playerModel);

    this.playerRepository.save(playerModel);
    

    return playerModel;
    
  }
}

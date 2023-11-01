package com.ms.topchallenge.player.useCases;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;





import com.ms.topchallenge.player.models.PlayerModel;
import com.ms.topchallenge.player.repositories.PlayerRepository;



@Service()
public class FetchPlayersService {
  @Autowired
  PlayerRepository playerRepository;
  
  public List<PlayerModel> execute() {
    var player = this.playerRepository.findAll();
    

    return player;
    
  }
}

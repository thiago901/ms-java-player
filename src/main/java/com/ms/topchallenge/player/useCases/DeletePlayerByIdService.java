package com.ms.topchallenge.player.useCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.ms.topchallenge.player.errors.PlayerNotFoundError;

import com.ms.topchallenge.player.repositories.PlayerRepository;



@Service()
public class DeletePlayerByIdService {
  @Autowired
  PlayerRepository playerRepository;
  
  public void execute(String player_id) {
    var hasPlayer = this.playerRepository.findById(player_id);
    if (hasPlayer.isEmpty()) {
      throw new PlayerNotFoundError();
    }

    this.playerRepository.deleteById(player_id);
    
  }
}

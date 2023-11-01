package com.ms.topchallenge.player.useCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.ms.topchallenge.player.errors.PlayerNotFoundError;
import com.ms.topchallenge.player.models.PlayerModel;
import com.ms.topchallenge.player.repositories.PlayerRepository;



@Service()
public class UpdatePlayerService {
  @Autowired
  PlayerRepository playerRepository;
  
  public PlayerModel execute(String player_id,String name) {
    var hasPlayer = this.playerRepository.findById(player_id);
    if (hasPlayer.isEmpty()) {
      throw new PlayerNotFoundError();
    }
    var player = hasPlayer.get();
    
    
    player.setName(name);
    return player;
    
  }
}

package com.ms.topchallenge.player.useCases;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




import com.ms.topchallenge.player.errors.PlayerNotFoundError;
import com.ms.topchallenge.player.models.PlayerModel;
import com.ms.topchallenge.player.repositories.PlayerRepository;



@Service()
public class FindPlayerByIdService {
  @Autowired
  PlayerRepository playerRepository;
  
  public PlayerModel execute(String player_id) {
    var hasPlayer = this.playerRepository.findById(player_id);
    if (hasPlayer.isEmpty()) {
      throw new PlayerNotFoundError();
    }
    
    return hasPlayer.get();
    
  }
}

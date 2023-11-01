package com.ms.topchallenge.player.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.ms.topchallenge.player.models.PlayerModel;

public interface PlayerRepository extends MongoRepository<PlayerModel,String> {
  PlayerModel findByEmail(String email);
}

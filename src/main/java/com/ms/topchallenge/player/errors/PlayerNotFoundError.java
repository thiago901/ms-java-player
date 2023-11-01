package com.ms.topchallenge.player.errors;



public class PlayerNotFoundError extends RuntimeException  {
  public PlayerNotFoundError(){
    super("Player not found");
  }
}

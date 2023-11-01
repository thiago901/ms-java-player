package com.ms.topchallenge.player.errors;



public class PlayerAlreadyExistsError extends RuntimeException  {
  public PlayerAlreadyExistsError(){
    super("Player already exists");
  }
}

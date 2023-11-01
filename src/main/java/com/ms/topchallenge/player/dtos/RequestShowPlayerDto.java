package com.ms.topchallenge.player.dtos;

import jakarta.validation.constraints.NotBlank;

public record RequestShowPlayerDto(
  @NotBlank String player_id
) {
  
}

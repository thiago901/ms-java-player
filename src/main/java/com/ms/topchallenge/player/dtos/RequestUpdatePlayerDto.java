package com.ms.topchallenge.player.dtos;

import jakarta.validation.constraints.NotBlank;

public record RequestUpdatePlayerDto(
  @NotBlank String player_id,
  @NotBlank String name
) {
  
}

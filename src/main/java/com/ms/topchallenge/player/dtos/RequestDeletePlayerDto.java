package com.ms.topchallenge.player.dtos;

import jakarta.validation.constraints.NotBlank;

public record RequestDeletePlayerDto(
  @NotBlank String player_id
) {
  
}

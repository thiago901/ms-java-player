package com.ms.topchallenge.player.dtos;

import jakarta.validation.constraints.NotBlank;

public record RequestCreatePlayerDto(
  @NotBlank String email,
  @NotBlank String name
) {
  
}

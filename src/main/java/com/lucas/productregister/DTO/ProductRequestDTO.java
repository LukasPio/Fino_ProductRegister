package com.lucas.productregister.DTO;

import jakarta.validation.constraints.NotNull;

public record ProductRequestDTO(@NotNull String name, @NotNull String description, @NotNull Float price, @NotNull Integer quantity) {
}

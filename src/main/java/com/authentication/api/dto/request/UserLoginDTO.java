package com.authentication.api.dto.request;

import jakarta.validation.constraints.NotNull;

public record UserLoginDTO(@NotNull String email, @NotNull String password) {
}

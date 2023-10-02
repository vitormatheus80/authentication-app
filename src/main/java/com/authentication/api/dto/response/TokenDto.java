package com.authentication.api.dto.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
public class TokenDto {

    private String token;

    private String authMessage;
}

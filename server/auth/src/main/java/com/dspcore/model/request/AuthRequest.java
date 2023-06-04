package com.dspcore.model.request;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
public class AuthRequest {
    String username;

    String keyLogin;
}


package org.grupouno.Parqueo_Is4Tech.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


public class LoginResponse {
    private String token;

    private long expiresIn;

    public LoginResponse() {
    }

    public LoginResponse(long expiresIn, String token) {
        this.expiresIn = expiresIn;
        this.token = token;
    }

    public long getExpiresIn() {
        return expiresIn;
    }

    public void setExpiresIn(long expiresIn) {
        this.expiresIn = expiresIn;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}

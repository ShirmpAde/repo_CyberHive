package com.example.module.member;

import com.fasterxml.jackson.annotation.JsonProperty;

// 카카오 토큰 응답을 위한 DTO
public class KakaoTokenResponseDto {
    @JsonProperty("token_type")
    private String tokenType;
    @JsonProperty("access_token")
    private String accessToken;
    @JsonProperty("expires_in")
    private Integer expiresIn;
    @JsonProperty("refresh_token")
    private String refreshToken;
    @JsonProperty("refresh_token_expires_in")
    private Integer refreshTokenExpiresIn;
    @JsonProperty("scope") // 동의한 항목들
    private String scope;

    // Getters and Setters
    public String getTokenType() { return tokenType; }
    public void setTokenType(String tokenType) { this.tokenType = tokenType; }
    public String getAccessToken() { return accessToken; }
    public void setAccessToken(String accessToken) { this.accessToken = accessToken; }
    public Integer getExpiresIn() { return expiresIn; }
    public void setExpiresIn(Integer expiresIn) { this.expiresIn = expiresIn; }
    public String getRefreshToken() { return refreshToken; }
    public void setRefreshToken(String refreshToken) { this.refreshToken = refreshToken; }
    public Integer getRefreshTokenExpiresIn() { return refreshTokenExpiresIn; }
    public void setRefreshTokenExpiresIn(Integer refreshTokenExpiresIn) { this.refreshTokenExpiresIn = refreshTokenExpiresIn; }
    public String getScope() { return scope; }
    public void setScope(String scope) { this.scope = scope; }
}

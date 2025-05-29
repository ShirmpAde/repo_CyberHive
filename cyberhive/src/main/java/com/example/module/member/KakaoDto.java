package com.example.module.member;

public class KakaoDto { // 또는 KakaoUserInfoVo, AppSpecificKakaoUser 등 더 명확한 이름
    private String id; // 카카오에서 제공하는 고유 사용자 ID (Long 타입이지만 문자열로 받아도 무방)
    private String email;
    private String nickname;
    // 필요하다면 프로필 이미지 URL 등 추가

    public KakaoDto(String id, String email, String nickname) {
        this.id = id;
        this.email = email;
        this.nickname = nickname;
    }

    // Getters and Setters
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getNickname() { return nickname; }
    public void setNickname(String nickname) { this.nickname = nickname; }
}
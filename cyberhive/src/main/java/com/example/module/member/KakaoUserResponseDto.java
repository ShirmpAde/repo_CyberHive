package com.example.module.member;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.Map;

// 카카오 사용자 정보 응답을 위한 DTO
public class KakaoUserResponseDto {
    private Long id; // 회원번호

    @JsonProperty("connected_at")
    private String connectedAt; // 서비스 연결 시간

    private Map<String, String> properties; // 사용자 프로퍼티 (nickname, profile_image 등)

    @JsonProperty("kakao_account")
    private KakaoAccount kakaoAccount; // 카카오계정 정보

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getConnectedAt() { return connectedAt; }
    public void setConnectedAt(String connectedAt) { this.connectedAt = connectedAt; }
    public Map<String, String> getProperties() { return properties; }
    public void setProperties(Map<String, String> properties) { this.properties = properties; }
    public KakaoAccount getKakaoAccount() { return kakaoAccount; }
    public void setKakaoAccount(KakaoAccount kakaoAccount) { this.kakaoAccount = kakaoAccount; }

    // Nested class for KakaoAccount
    public static class KakaoAccount {
        @JsonProperty("profile_nickname_needs_agreement")
        private Boolean profileNicknameNeedsAgreement;
        @JsonProperty("profile_image_needs_agreement")
        private Boolean profileImageNeedsAgreement;

        private Profile profile; // 프로필 정보 (닉네임, 프로필 이미지 등)

        @JsonProperty("has_email")
        private Boolean hasEmail;
        @JsonProperty("email_needs_agreement")
        private Boolean emailNeedsAgreement;
        @JsonProperty("is_email_valid")
        private Boolean isEmailValid;
        @JsonProperty("is_email_verified")
        private Boolean isEmailVerified;
        private String email;

        // Getters and Setters for KakaoAccount fields
        public Profile getProfile() { return profile; }
        public void setProfile(Profile profile) { this.profile = profile; }
        public Boolean getHasEmail() { return hasEmail; }
        public void setHasEmail(Boolean hasEmail) { this.hasEmail = hasEmail; }
        public Boolean getEmailNeedsAgreement() { return emailNeedsAgreement; }
        public void setEmailNeedsAgreement(Boolean emailNeedsAgreement) { this.emailNeedsAgreement = emailNeedsAgreement; }
        public Boolean getIsEmailValid() { return isEmailValid; }
        public void setIsEmailValid(Boolean isEmailValid) { this.isEmailValid = isEmailValid; }
        public Boolean getIsEmailVerified() { return isEmailVerified; }
        public void setIsEmailVerified(Boolean isEmailVerified) { this.isEmailVerified = isEmailVerified; }
        public String getEmail() { return email; }
        public void setEmail(String email) { this.email = email; }
        public Boolean getProfileNicknameNeedsAgreement() { return profileNicknameNeedsAgreement; }
        public void setProfileNicknameNeedsAgreement(Boolean profileNicknameNeedsAgreement) { this.profileNicknameNeedsAgreement = profileNicknameNeedsAgreement; }
        public Boolean getProfileImageNeedsAgreement() { return profileImageNeedsAgreement; }
        public void setProfileImageNeedsAgreement(Boolean profileImageNeedsAgreement) { this.profileImageNeedsAgreement = profileImageNeedsAgreement; }
    }

    // Nested class for Profile in KakaoAccount
    public static class Profile {
        private String nickname;
        @JsonProperty("thumbnail_image_url")
        private String thumbnailImageUrl;
        @JsonProperty("profile_image_url") //_url이 붙음
        private String profileImageUrl;
        @JsonProperty("is_default_image")
        private Boolean isDefaultImage;

        // Getters and Setters for Profile fields
        public String getNickname() { return nickname; }
        public void setNickname(String nickname) { this.nickname = nickname; }
        public String getThumbnailImageUrl() { return thumbnailImageUrl; }
        public void setThumbnailImageUrl(String thumbnailImageUrl) { this.thumbnailImageUrl = thumbnailImageUrl; }
        public String getProfileImageUrl() { return profileImageUrl; }
        public void setProfileImageUrl(String profileImageUrl) { this.profileImageUrl = profileImageUrl; }
        public Boolean getIsDefaultImage() { return isDefaultImage; }
        public void setIsDefaultImage(Boolean isDefaultImage) { this.isDefaultImage = isDefaultImage; }
    }
}
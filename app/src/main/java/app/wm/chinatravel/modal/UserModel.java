package app.wm.chinatravel.modal;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class UserModel implements Serializable {

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("profile_image")
    @Expose
    private String profileImage;
    @SerializedName("first_name")
    @Expose
    private String firstName;
    @SerializedName("last_name")
    @Expose
    private String lastName;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("gender")
    @Expose
    private String gender;
    @SerializedName("email")
    @Expose
    private String email;
    @SerializedName("email_verified")
    @Expose
    private int emailVerified;
    @SerializedName("dob")
    @Expose
    private String dob;
    @SerializedName("dial_code")
    @Expose
    private int dialCode;
    @SerializedName("mobile")
    @Expose
    private String mobile;
    @SerializedName("mobile_verified")
    @Expose
    private int mobileVerified;
    @SerializedName("status")
    @Expose
    private int status;
    @SerializedName("oauth_id")
    @Expose
    private String oauthId;
    @SerializedName("oauth_provider")
    @Expose
    private String oauthProvider;
    @SerializedName("locale")
    @Expose
    private String locale;
    @SerializedName("token")
    @Expose
    private String token;
    @SerializedName("terms_conditions")
    @Expose
    private int termsConditions;
    @SerializedName("social_profile_completed")
    @Expose
    private int socialProfileCompleted;
    @SerializedName("created_at")
    @Expose
    private String createdAt;
    @SerializedName("updated_at")
    @Expose
    private String updatedAt;
    @SerializedName("fcmData")
    @Expose
    private FCMModel fcmData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProfileImage() {
        return profileImage;
    }

    public void setProfileImage(String profileImage) {
        this.profileImage = profileImage;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(int emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public int getDialCode() {
        return dialCode;
    }

    public void setDialCode(int dialCode) {
        this.dialCode = dialCode;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public int getMobileVerified() {
        return mobileVerified;
    }

    public void setMobileVerified(int mobileVerified) {
        this.mobileVerified = mobileVerified;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getOauthId() {
        return oauthId;
    }

    public void setOauthId(String oauthId) {
        this.oauthId = oauthId;
    }

    public String getOauthProvider() {
        return oauthProvider;
    }

    public void setOauthProvider(String oauthProvider) {
        this.oauthProvider = oauthProvider;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public int getTermsConditions() {
        return termsConditions;
    }

    public void setTermsConditions(int termsConditions) {
        this.termsConditions = termsConditions;
    }

    public int getSocialProfileCompleted() {
        return socialProfileCompleted;
    }

    public void setSocialProfileCompleted(int socialProfileCompleted) {
        this.socialProfileCompleted = socialProfileCompleted;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }

    public FCMModel getFcmData() {
        return fcmData;
    }

    public void setFcmData(FCMModel fcmData) {
        this.fcmData = fcmData;
    }
}

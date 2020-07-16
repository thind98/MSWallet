package vn.itsol.MSWallet.dto;

import javax.persistence.Column;
import java.util.Date;

public class PasswordResetTokenDto
{
    private long tokenId;
    private String token;
    private Date expiryDate;
    private long userId;

    public long getTokenId() {
        return tokenId;
    }

    public void setTokenId(long tokenId) {
        this.tokenId = tokenId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public PasswordResetTokenDto() {
    }

    public PasswordResetTokenDto(long tokenId, String token, Date expiryDate, long userId) {
        this.tokenId = tokenId;
        this.token = token;
        this.expiryDate = expiryDate;
        this.userId = userId;
    }
}

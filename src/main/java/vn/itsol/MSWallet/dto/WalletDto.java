package vn.itsol.MSWallet.dto;

import javax.persistence.Column;

public class WalletDto
{
    private long userWalletId;
    private long userId;
    private long walletId;
    private long role;

    public long getUserWalletId() {
        return userWalletId;
    }

    public void setUserWalletId(long userWalletId) {
        this.userWalletId = userWalletId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getWalletId() {
        return walletId;
    }

    public void setWalletId(long walletId) {
        this.walletId = walletId;
    }

    public long getRole() {
        return role;
    }

    public void setRole(long role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "WalletDto{" +
                "userWalletId=" + userWalletId +
                ", userId=" + userId +
                ", walletId=" + walletId +
                ", role=" + role +
                '}';
    }
}

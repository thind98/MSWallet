package vn.itsol.MSWallet.dto;

import javax.persistence.Column;
import java.util.Date;

public class TransactionsDto
{
    private long transId;
    private long amount;
    private long transType;
    private Date date;
    private String note;
    private long userId;
    private long walletId;
    private long categoryId;

    public long getTransId() {
        return transId;
    }

    public void setTransId(long transId) {
        this.transId = transId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getTransType() {
        return transType;
    }

    public void setTransType(long transType) {
        this.transType = transType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
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

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

    public TransactionsDto(long transId, long amount, long transType, Date date, String note, long userId, long walletId, long categoryId) {
        this.transId = transId;
        this.amount = amount;
        this.transType = transType;
        this.date = date;
        this.note = note;
        this.userId = userId;
        this.walletId = walletId;
        this.categoryId = categoryId;
    }

    public TransactionsDto() {
    }
}

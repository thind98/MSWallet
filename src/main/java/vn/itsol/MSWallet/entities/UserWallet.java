package vn.itsol.MSWallet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class UserWallet
{
    @Id
    @Column(name = "user_wallet_id")
    @GeneratedValue
    private long userWalletId;

    @Column(name = "user_id")
    private long userId;

    @Column(name = "wallet_id")
    private long walletId;

    @Column(name = "role")
    private long role;
}

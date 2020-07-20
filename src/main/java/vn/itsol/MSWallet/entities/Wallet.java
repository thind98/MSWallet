package vn.itsol.MSWallet.entities;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "wallet")
@Data
public class Wallet
{
    @Id
    @Column(name = "wallet_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long walletId;

    @Column(name = "wallert_name")
    private String wallertName;

    @Column(name = "balance")
    private long balance;

    @Column(name = "currency")
    private long currency;

    @Column(name = "create_date")
    private Date createDate;
}

package vn.itsol.MSWallet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "transactions")
@Data
public class Transactions
{
    @Id
    @Column(name = "transId")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long transId;

    @Column(name = "amount")
    private long amount;

    @Column(name = "trans_type")
    private long transType;

    @Column(name = "date")
    private Date date;

    @Column(name = "note")
    private String note;

//    @Column(name = "user_id")
//    private long userId;
//
//    @Column(name = "wallet_id")
//    private long walletId;
//
//    @Column(name = "category_id")
//    private long categoryId;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users users;

    @ManyToOne
    @JoinColumn(name = "wallet_id")
    private Wallet wallet;

    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;
}

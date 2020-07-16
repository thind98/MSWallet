package vn.itsol.MSWallet.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "password_reset_token")
@Data
public class PasswordResetToken
{
    @Id
    @Column(name = "name")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long tokenId;

    @Column(name = "token")
    private String token;

    @Column(name = "expiry_date")
    private Date expiryDate;

    @Column(name = "user_id")
    private long userId;
}

package vn.itsol.MSWallet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "users")
@Data
public class Users
{
    @Id
    @Column(name = "user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private long userId;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String passWord;

    @Column(name = "phone_number")
    private long phoneNumber;

    @Column(name = "gender")
    private String gender;

    @Column(name = "Path_ava")
    private String pathAva;

}

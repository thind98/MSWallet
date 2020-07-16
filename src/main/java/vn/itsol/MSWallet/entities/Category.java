package vn.itsol.MSWallet.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table
@Data
public class Category
{
    @Id
    @Column(name = "category_id")
    @GeneratedValue
    private long category;

    @Column(name = "categoryname")
    private String categoryName;
}

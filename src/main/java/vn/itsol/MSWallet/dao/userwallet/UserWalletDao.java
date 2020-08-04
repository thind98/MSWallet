package vn.itsol.MSWallet.dao.userwallet;

import vn.itsol.MSWallet.entities.UserWallet;

import java.util.List;

public interface UserWalletDao
{
    UserWallet getUserWallet(int userwallet_id);
    void save(UserWallet userWallet);
    void delete(int userwallet_id);
}

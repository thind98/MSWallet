package vn.itsol.MSWallet.dao.wallet;

import vn.itsol.MSWallet.entities.Wallet;

import java.util.List;

public interface WalletDao
{
    Wallet getWallet(int wallet_id);
    void save(Wallet wallet);
    void update(Wallet wallet);
    void delete(int wallet_id);
}

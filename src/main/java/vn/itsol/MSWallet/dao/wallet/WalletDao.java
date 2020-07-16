package vn.itsol.MSWallet.dao.wallet;

import vn.itsol.MSWallet.entities.Wallet;

import java.util.List;

public interface WalletDao
{
    List<Wallet> getWallets();
    Wallet getWallet(int wallet_id);
    void save(Wallet wallet);
    void delete(int wallet_id);
}

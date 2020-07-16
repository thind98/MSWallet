package vn.itsol.MSWallet.dao.wallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.Wallet;

import java.util.List;

@Repository
public class WalletDaoImpl implements WalletDao
{
    private static final Logger log = LoggerFactory.getLogger(WalletDaoImpl.class);

    @Override
    public List<Wallet> getWallets() {
        return null;
    }

    @Override
    public Wallet getWallet(int wallet_id) {
        return null;
    }

    @Override
    public void save(Wallet wallet) {

    }

    @Override
    public void delete(int wallet_id) {

    }
}

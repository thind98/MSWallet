package vn.itsol.MSWallet.dao.userwallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.UserWallet;

import java.util.List;

@Repository
public class UserWalletDaoImpl implements UserWalletDao
{
    private static final Logger log = LoggerFactory.getLogger(UserWalletDaoImpl.class);

    @Override
    public List<UserWallet> getUserWallets() {
        return null;
    }

    @Override
    public UserWallet getUserWallet(int userwallet_id) {
        return null;
    }

    @Override
    public void save(UserWallet userWallet) {

    }

    @Override
    public void update(UserWallet userWallet) {

    }

    @Override
    public void delete(int userwallet_id) {

    }
}

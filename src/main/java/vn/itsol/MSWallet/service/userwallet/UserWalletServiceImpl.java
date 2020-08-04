package vn.itsol.MSWallet.service.userwallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.itsol.MSWallet.dao.userwallet.UserWalletDao;
import vn.itsol.MSWallet.dto.UserWalletDto;
import vn.itsol.MSWallet.entities.UserWallet;
import vn.itsol.MSWallet.entities.Users;
import vn.itsol.MSWallet.entities.Wallet;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserWalletServiceImpl implements UserWalletService
{
    private static final Logger log = LoggerFactory.getLogger(UserWalletServiceImpl.class);

    @Autowired
    private UserWalletDao userWalletDao;

    @Transactional
    @Override
    public UserWalletDto getUserWallet(int wallet_id) {
        UserWallet userWallet = userWalletDao.getUserWallet(wallet_id);
        UserWalletDto userWalletDto = new UserWalletDto();

        userWalletDto.setWalletId(userWallet.getWallet().getWalletId());
        userWalletDto.setUserWalletId(userWallet.getUserWalletId());
        userWalletDto.setUserId(userWallet.getUsers().getUserId());
        userWalletDto.setRole(userWallet.getRole());

        return userWalletDto;
    }

    @Transactional
    @Override
    public void save(UserWalletDto userWalletDto) {
        UserWallet userWallet = new UserWallet();
        Wallet wallet = new Wallet();
        wallet.setWalletId(userWalletDto.getWalletId());
        Users users = new Users();
        users.setUserId(userWalletDto.getUserId());

        userWallet.setRole(userWalletDto.getRole());
        userWallet.setWallet(wallet);
        userWallet.setUserWalletId(userWalletDto.getUserWalletId());
        userWallet.setUsers(users);

        userWalletDao.save(userWallet);
    }

    @Transactional
    @Override
    public void delete(int wallet_id) {
        userWalletDao.delete(wallet_id);
    }
}

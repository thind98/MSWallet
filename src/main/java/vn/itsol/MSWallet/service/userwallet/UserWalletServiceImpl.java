package vn.itsol.MSWallet.service.userwallet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.itsol.MSWallet.dao.userwallet.UserWalletDao;
import vn.itsol.MSWallet.dto.UserWalletDto;
import vn.itsol.MSWallet.entities.UserWallet;

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
    public List<UserWalletDto> getUserWallets() {
        List<UserWallet> userWalletList = userWalletDao.getUserWallets();
        List<UserWalletDto> userWalletDtos = new ArrayList<>();
        for(UserWallet u: userWalletList)
        {
            UserWalletDto userWalletDto = new UserWalletDto();
            userWalletDto.setWalletId(u.getWalletId());
            userWalletDto.setRole(u.getRole());
            userWalletDto.setUserId(u.getUserId());
            userWalletDto.setUserWalletId(u.getUserWalletId());
            userWalletDtos.add(userWalletDto);
        }
        return userWalletDtos;
    }

    @Transactional
    @Override
    public UserWalletDto getUserWallet(int wallet_id) {
        UserWallet userWallet = userWalletDao.getUserWallet(wallet_id);

        UserWalletDto userWalletDto = new UserWalletDto();

        userWalletDto.setWalletId(userWallet.getWalletId());
        userWalletDto.setUserWalletId(userWallet.getUserWalletId());
        userWalletDto.setUserId(userWallet.getUserId());
        userWalletDto.setRole(userWallet.getRole());

        return userWalletDto;
    }

    @Transactional
    @Override
    public void save(UserWalletDto userWalletDto) {
        UserWallet userWallet = new UserWallet();
        userWallet.setRole(userWalletDto.getRole());
        userWallet.setWalletId(userWalletDto.getWalletId());
        //userWallet.setUserWalletId(userWalletDto.getUserWalletId());
        userWallet.setUserId(userWalletDto.getUserId());

        userWalletDao.save(userWallet);
    }

    @Transactional
    @Override
    public void update(UserWalletDto userWalletDto) {
        UserWallet userWallet = new UserWallet();
        userWallet.setRole(userWalletDto.getRole());
        userWallet.setWalletId(userWalletDto.getWalletId());
        userWallet.setUserWalletId(userWalletDto.getUserWalletId());
        userWallet.setUserId(userWalletDto.getUserId());

        userWalletDao.update(userWallet);
    }

    @Transactional
    @Override
    public void delete(int wallet_id) {
        userWalletDao.delete(wallet_id);
    }
}

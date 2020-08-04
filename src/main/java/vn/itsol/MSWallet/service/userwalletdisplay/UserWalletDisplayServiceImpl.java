package vn.itsol.MSWallet.service.userwalletdisplay;

import org.springframework.stereotype.Service;
import vn.itsol.MSWallet.dto.UserWalletDisplay;

import java.util.List;

@Service
public class UserWalletDisplayServiceImpl implements UserWalletDisplayService{

    @Override
    public List<UserWalletDisplay> findByUserId(int user_id) {
        return null;
    }

    @Override
    public List<UserWalletDisplay> findByWalletId(int wallet_id) {
        return null;
    }
}

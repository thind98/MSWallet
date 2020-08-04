package vn.itsol.MSWallet.service.userwalletdisplay;

import vn.itsol.MSWallet.dto.UserWalletDisplay;

import java.util.List;

public interface UserWalletDisplayService {
    List<UserWalletDisplay> findByUserId(int user_id);
    List<UserWalletDisplay> findByWalletId(int wallet_id);
}

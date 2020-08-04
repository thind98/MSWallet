package vn.itsol.MSWallet.service.userwallet;

import vn.itsol.MSWallet.dto.UserWalletDto;
import vn.itsol.MSWallet.dto.WalletDto;

import java.util.List;

public interface UserWalletService {
    UserWalletDto getUserWallet(int wallet_id);
    void save(UserWalletDto userWalletDto);
    void delete(int wallet_id);
}

package vn.itsol.MSWallet.service.userwallet;

import vn.itsol.MSWallet.dto.UserWalletDto;
import vn.itsol.MSWallet.dto.WalletDto;

import java.util.List;

public interface UserWalletService {
    List<UserWalletDto> getUserWallet(int wallet_id);
    List<UserWalletDto> getUserWalletByUseridWalletid(int wallet_id, int user_id);
    UserWalletDto save(UserWalletDto userWalletDto);
    void delete(int wallet_id);
}

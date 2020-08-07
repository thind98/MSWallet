package vn.itsol.MSWallet.service.wallet;

import vn.itsol.MSWallet.dto.UserWalletDisplay;
import vn.itsol.MSWallet.dto.WalletDto;
import vn.itsol.MSWallet.entities.UserWallet;
import vn.itsol.MSWallet.entities.Wallet;

import java.util.List;

public interface WalletService {
    List<UserWalletDisplay> findWalletbyuserid(int user_id);
    List<UserWalletDisplay> findWalletbywalletid(int wallet_id);
    WalletDto getWallet(int wallet_id);
    String save(WalletDto wallet);
    String update(WalletDto wallet);
    String delete(int wallet_id);
}

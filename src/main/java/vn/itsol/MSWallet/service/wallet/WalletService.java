package vn.itsol.MSWallet.service.wallet;

import vn.itsol.MSWallet.dto.WalletDto;
import vn.itsol.MSWallet.entities.Wallet;

import java.util.List;

public interface WalletService {
    WalletDto getWallet(int wallet_id);
    void save(WalletDto wallet);
    void update(WalletDto wallet);
    void delete(int wallet_id);
}

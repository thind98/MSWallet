package vn.itsol.MSWallet.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.itsol.MSWallet.dto.WalletDto;
import vn.itsol.MSWallet.service.wallet.WalletService;

import java.util.List;

@RestController
public class WalletController
{
    private static final Logger log = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private WalletService walletService;

    @GetMapping(path = "/wallets")
    public List<WalletDto> getWallets()
    {
        return walletService.getWallets();
    }

    @GetMapping(path = "/wallet/{wallet_id}")
    public WalletDto getWallet(@PathVariable("wallet_id") int wallet_id)
    {
        return walletService.getWallet(wallet_id);
    }

    @PostMapping(path = "/wallet")
    public void saveWallet(@RequestBody WalletDto walletDto)
    {
        log.info("WalletController.saveWallet.RequestBody: " + walletDto.toString());
        walletService.save(walletDto);
    }

    @PutMapping(path = "/wallet")
    public void updateWallet(@RequestBody WalletDto walletDto)
    {
        walletService.update(walletDto);
    }

    @DeleteMapping(path = "/wallet/{wallet_id}")
    public void deleteWallet(@PathVariable("wallet_id") int wallet_id)
    {
        walletService.delete(wallet_id);
    }
}

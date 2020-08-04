package vn.itsol.MSWallet.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.itsol.MSWallet.dto.WalletDto;
import vn.itsol.MSWallet.service.wallet.WalletService;

import java.util.List;

@RestController
@RequestMapping(path = "/wallet")
public class WalletController
{
    private static final Logger log = LoggerFactory.getLogger(WalletController.class);

    @Autowired
    private WalletService walletService;

    @GetMapping(path = "findbyid/{wallet_id}")
    public WalletDto getWallet(@PathVariable("wallet_id") int wallet_id)
    {
        return walletService.getWallet(wallet_id);
    }

    @PostMapping(path = "save")
    public void saveWallet(@RequestBody WalletDto walletDto)
    {
        walletService.save(walletDto);
    }

    @PutMapping(path = "update")
    public void updateWallet(@RequestBody WalletDto walletDto)
    {
        walletService.update(walletDto);
    }

    @DeleteMapping(path = "delete/{wallet_id}")
    public void deleteWallet(@PathVariable("wallet_id") int wallet_id)
    {
        walletService.delete(wallet_id);
    }
}

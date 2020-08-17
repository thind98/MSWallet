package vn.itsol.MSWallet.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.itsol.MSWallet.dto.UserWalletDto;
import vn.itsol.MSWallet.service.userwallet.UserWalletService;

import java.util.List;

@RestController
@RequestMapping(path = "userwallet")
@CrossOrigin(origins = "http://localhost:4200")
public class UsersWalletController
{
    private static final Logger log = LoggerFactory.getLogger(UsersWalletController.class);

    @Autowired
    private UserWalletService userWalletService;

    @GetMapping(path = "findbyid/{wallet_id}")
    public List<UserWalletDto> getUserWallet(@PathVariable("wallet_id") int wallet_id){
        return userWalletService.getUserWallet(wallet_id);
    }

    @GetMapping(path = "findbyuseridwalletid")
    public List<UserWalletDto> getUserWalletByUseridWalletid(@RequestParam(name = "walletid") int walletid, @RequestParam(name = "userid") int userid){
        return userWalletService.getUserWalletByUseridWalletid(walletid, userid);
    }

    @PostMapping(path = "save")
    public UserWalletDto saveUserWallet(@RequestBody UserWalletDto userWalletDto)
    {
        return userWalletService.save(userWalletDto);
    }

    @DeleteMapping(path = "delete/{user_wallet_id}")
    public void deleteUserWallet(@PathVariable("user_wallet_id") int user_wallet_id){
        userWalletService.delete(user_wallet_id);
    }
}

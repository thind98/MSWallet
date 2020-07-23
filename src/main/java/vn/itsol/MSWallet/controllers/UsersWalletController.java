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
public class UsersWalletController
{
    private static final Logger log = LoggerFactory.getLogger(UsersWalletController.class);

    @Autowired
    private UserWalletService userWalletService;

    @GetMapping(path = "findall")
    public List<UserWalletDto> getUserWallets(){
        return userWalletService.getUserWallets();
    }

    @GetMapping(path = "findbyid/{user_wallet_id}")
    public UserWalletDto getUserWallet(@PathVariable("user_wallet_id") int user_wallet_id){
        return userWalletService.getUserWallet(user_wallet_id);
    }

    @PostMapping(path = "save")
    public void saveUserWallet(@RequestBody UserWalletDto userWalletDto)
    {
        userWalletService.save(userWalletDto);
    }

    @PutMapping(path = "update")
    public void updateUserWallet(@RequestBody UserWalletDto userWalletDto)
    {
        userWalletService.update(userWalletDto);
    }

    @DeleteMapping(path = "delete/{user_wallet_id}")
    public void deleteUserWallet(@PathVariable("user_wallet_id") int user_wallet_id){
        userWalletService.delete(user_wallet_id);
    }
}

package vn.itsol.MSWallet.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import vn.itsol.MSWallet.dto.PasswordResetTokenDto;
import vn.itsol.MSWallet.service.passwordresettoken.PasswordResetTokenService;

import java.util.List;

@RestController
@RequestMapping(path = "/token")
public class PasswordResetTokenController
{
    private static final Logger log = LoggerFactory.getLogger(PasswordResetTokenController.class);

    @Autowired
    private PasswordResetTokenService passwordResetTokenService;

    @GetMapping(path = "findall")
    public List<PasswordResetTokenDto> getAllPass(){
        return passwordResetTokenService.getPasswordResetTokens();
    }

    @GetMapping(path = "findbyid/{id}")
    public PasswordResetTokenDto getPass(@PathVariable("id") int id){
        return passwordResetTokenService.getPasswordResetToken(id);
    }

    @PostMapping(path = "save")
    public void savePass(@RequestBody PasswordResetTokenDto passwordResetTokenDto){
        passwordResetTokenService.save(passwordResetTokenDto);
    }

    @PutMapping(path = "update")
    public void updatePass(@RequestBody PasswordResetTokenDto passwordResetTokenDto){
        passwordResetTokenService.update(passwordResetTokenDto);
    }

    @DeleteMapping(path = "delete/{id}")
    public void deletePass(@PathVariable("id") int id){
        passwordResetTokenService.delete(id);
    }
}

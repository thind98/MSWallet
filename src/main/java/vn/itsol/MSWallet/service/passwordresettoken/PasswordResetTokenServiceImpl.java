package vn.itsol.MSWallet.service.passwordresettoken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.itsol.MSWallet.dao.passwordresettoken.PasswordResetTokenDao;
import vn.itsol.MSWallet.dto.PasswordResetTokenDto;
import vn.itsol.MSWallet.entities.PasswordResetToken;

import java.util.ArrayList;
import java.util.List;

@Service
public class PasswordResetTokenServiceImpl implements PasswordResetTokenService
{
    private static final Logger log = LoggerFactory.getLogger(PasswordResetTokenServiceImpl.class);

    @Autowired
    private PasswordResetTokenDao passwordResetTokenDao;

    @Transactional
    @Override
    public List<PasswordResetTokenDto> getPasswordResetTokens() {
        List<PasswordResetToken> passwordResetTokens = passwordResetTokenDao.getPasswordResetTokens();
        List<PasswordResetTokenDto> passwordResetTokenDtos = new ArrayList<>();
        for(PasswordResetToken p : passwordResetTokens){
            PasswordResetTokenDto passwordResetTokenDto = new PasswordResetTokenDto();
            passwordResetTokenDto.setTokenId(p.getTokenId());
            passwordResetTokenDto.setUserId(p.getUserId());
            passwordResetTokenDto.setToken(p.getToken());
            passwordResetTokenDto.setExpiryDate(p.getExpiryDate());
            passwordResetTokenDtos.add(passwordResetTokenDto);
        }
        return passwordResetTokenDtos;
    }

    @Transactional
    @Override
    public PasswordResetTokenDto getPasswordResetToken(int passRT_id) {
        PasswordResetToken passwordResetToken = passwordResetTokenDao.getPasswordResetToken(passRT_id);
        PasswordResetTokenDto passwordResetTokenDto = new PasswordResetTokenDto();
        passwordResetTokenDto.setTokenId(passwordResetToken.getTokenId());
        passwordResetTokenDto.setToken(passwordResetToken.getToken());
        passwordResetTokenDto.setExpiryDate(passwordResetToken.getExpiryDate());
        passwordResetTokenDto.setUserId(passwordResetToken.getUserId());
        return passwordResetTokenDto;
    }

    @Transactional
    @Override
    public void save(PasswordResetTokenDto passwordResetTokenDto) {
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setExpiryDate(passwordResetTokenDto.getExpiryDate());
        passwordResetToken.setToken(passwordResetTokenDto.getToken());
        //passwordResetToken.setTokenId(passwordResetTokenDto.getTokenId());
        passwordResetToken.setUserId(passwordResetTokenDto.getUserId());
        passwordResetTokenDao.save(passwordResetToken);
    }

    @Transactional
    @Override
    public void update(PasswordResetTokenDto passwordResetTokenDto) {
        PasswordResetToken passwordResetToken = new PasswordResetToken();
        passwordResetToken.setExpiryDate(passwordResetTokenDto.getExpiryDate());
        passwordResetToken.setToken(passwordResetTokenDto.getToken());
        passwordResetToken.setTokenId(passwordResetTokenDto.getTokenId());
        passwordResetToken.setUserId(passwordResetTokenDto.getUserId());
        passwordResetTokenDao.update(passwordResetToken);
    }

    @Transactional
    @Override
    public void delete(int passRT_id) {

    }
}

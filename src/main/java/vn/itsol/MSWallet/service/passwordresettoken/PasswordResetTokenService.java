package vn.itsol.MSWallet.service.passwordresettoken;

import vn.itsol.MSWallet.dto.PasswordResetTokenDto;
import vn.itsol.MSWallet.entities.PasswordResetToken;

import java.util.List;

public interface PasswordResetTokenService {
    List<PasswordResetTokenDto> getPasswordResetTokens();
    PasswordResetTokenDto getPasswordResetToken(int passRT_id);
    void save(PasswordResetTokenDto passwordResetTokenDto);
    void update(PasswordResetTokenDto passwordResetTokenDto);
    void delete(int passRT_id);
}

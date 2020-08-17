package vn.itsol.MSWallet.service.passwordresettoken;

import vn.itsol.MSWallet.dto.PasswordResetTokenDto;
import vn.itsol.MSWallet.entities.PasswordResetToken;

import java.util.List;

public interface PasswordResetTokenService {
    PasswordResetTokenDto getPasswordResetToken(int passRT_id);
    PasswordResetTokenDto save(PasswordResetTokenDto passwordResetTokenDto);
    PasswordResetTokenDto update(PasswordResetTokenDto passwordResetTokenDto);
}

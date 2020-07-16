package vn.itsol.MSWallet.dao.passwordresettoken;

import vn.itsol.MSWallet.entities.PasswordResetToken;

import java.util.List;

public interface PasswordResetTokenDao {
    List<PasswordResetToken> getPasswordResetTokens();
    PasswordResetToken getPasswordResetToken(int passRT_id);
    void save(PasswordResetToken passwordResetToken);
    void delete(int passRT_id);
}

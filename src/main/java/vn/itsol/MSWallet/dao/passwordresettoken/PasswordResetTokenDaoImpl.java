package vn.itsol.MSWallet.dao.passwordresettoken;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.PasswordResetToken;

import java.util.List;

@Repository
public class PasswordResetTokenDaoImpl implements PasswordResetTokenDao
{
    private static final Logger log = LoggerFactory.getLogger(PasswordResetTokenDaoImpl.class);

    @Override
    public List<PasswordResetToken> getPasswordResetTokens() {
        return null;
    }

    @Override
    public PasswordResetToken getPasswordResetToken(int passRT_id) {
        return null;
    }

    @Override
    public void save(PasswordResetToken passwordResetToken) {

    }

    @Override
    public void delete(int passRT_id) {

    }
}

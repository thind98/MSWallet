package vn.itsol.MSWallet.dao.userwallet;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.UserWallet;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class UserWalletDaoImpl implements UserWalletDao
{
    private static final Logger log = LoggerFactory.getLogger(UserWalletDaoImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<UserWallet> getUserWallets() {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select u.userWalletId, u.role, u.users.userId, u.wallet.walletId From UserWallet u";

        Query<UserWallet> query = session.createQuery(hql, UserWallet.class);
        log.info("getUserWallets.query: " + query.toString());

        List<UserWallet> results = query.getResultList();
        log.info("getUserWallets.results: " + results.toString());
        return results;
    }

    @Override
    public UserWallet getUserWallet(int userwallet_id) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "select u.userWalletId, u.role, u.users.userId, u.wallet.walletId From UserWallet u Where u.userWalletId = " + userwallet_id;

        Query<UserWallet> query = session.createQuery(hql, UserWallet.class);
        log.info("getUserWallet.query: " + query.toString());

        UserWallet result = query.getSingleResult();
        log.info("getUserWallet.result: " + result.toString());
        return result;
    }

    @Override
    public void save(UserWallet userWallet) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "Insert Into user_wallet(user_wallet_id, user_id, wallet_id, role) " +
                     "values( ((SELECT max(user_wallet_id) from user_wallet)+1), " + userWallet.getUsers().getUserId() + ", " + userWallet.getWallet().getWalletId() + ", " + userWallet.getRole() + ")";

        Query<UserWallet> query = session.createSQLQuery(sql);
        log.info("save.query: " + query.toString());

        query.executeUpdate();
    }

    @Override
    public void update(UserWallet userWallet) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "UPDATE user_wallet SET user_id = " + userWallet.getUsers().getUserId() + ", wallet_id = " + userWallet.getWallet().getWalletId() + ", role = " + userWallet.getRole() + " WHERE user_wallet_id = "+ userWallet.getUserWalletId() +"";

        Query<UserWallet> query = session.createSQLQuery(sql);
        log.info("update.query: " + query.toString());

        query.executeUpdate();
    }

    @Override
    public void delete(int userwallet_id) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "Delete From user_wallet Where user_wallet_id = " + userwallet_id;

        Query<UserWallet> query = session.createSQLQuery(sql);
        log.info("delete.query: " + query.toString());

        query.executeUpdate();
    }
}

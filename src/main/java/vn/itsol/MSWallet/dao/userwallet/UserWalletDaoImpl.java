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
        String hql = "From UserWallet u";
        Query<UserWallet> query = session.createQuery(hql, UserWallet.class);
        List<UserWallet> result = query.getResultList();
        return result;
    }

    @Override
    public UserWallet getUserWallet(int userwallet_id) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "From UserWallet u Where u.userWalletId = " + userwallet_id;
        Query<UserWallet> query = session.createQuery(hql, UserWallet.class);
        UserWallet result = query.getSingleResult();
        return result;
    }

    @Override
    public void save(UserWallet userWallet) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "Insert Into user_wallet(user_wallet_id, user_id, wallet_id, role) " +
                     "values( ((SELECT max(user_wallet_id) from user_wallet)+1), " + userWallet.getUserId() + ", " + userWallet.getWalletId() + ", " + userWallet.getRole() + ")";
        Query<UserWallet> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void update(UserWallet userWallet) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "UPDATE user_wallet SET ";
        if (userWallet.getUserId() != 0){
            sql = sql + "user_id = " + userWallet.getUserId() + ", ";
        }
        if (userWallet.getWalletId() != 0){
            sql = sql + "wallet_id = " + userWallet.getWalletId() + ", ";
        }
        sql = sql + "role = " + userWallet.getRole();
        sql = sql + "WHERE user_wallet_id = " + userWallet.getUserWalletId();
        Query<UserWallet> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void delete(int userwallet_id) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "Delete From user_wallet  Where user_wallet_id = " + userwallet_id;
        Query<UserWallet> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }
}

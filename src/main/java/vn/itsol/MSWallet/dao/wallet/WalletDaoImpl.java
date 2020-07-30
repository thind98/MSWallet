package vn.itsol.MSWallet.dao.wallet;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.Wallet;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class WalletDaoImpl implements WalletDao
{
    private static final Logger log = LoggerFactory.getLogger(WalletDaoImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Wallet> getWallets() {
        Session session = entityManager.unwrap(Session.class);
        String hql = "Select w.walletId, w.wallertName, w.currency, w.balance, w.createDate From Wallet w";

        Query<Wallet> query = session.createQuery(hql, Wallet.class);
        log.info("getWallets.hql: " + hql);

        List<Wallet> listResult = query.getResultList();
        log.info("getWallets.listResult: " + listResult.toString());
        return listResult;
    }

    @Override
    public Wallet getWallet(int wallet_id) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "Select w.walletId, w.wallertName, w.currency, w.balance, w.createDate From Wallet w Where w.walletId = :walletId";

        Query<Wallet> query = session.createQuery(hql, Wallet.class);
        query.setParameter("walletId", wallet_id);
        log.info("getWallet.query: " + query.toString());

        Wallet result = query.getSingleResult();
        log.info("getWallet.result: " + result);
        return result;
    }

    @Override
    public void save(Wallet wallet) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "INSERT INTO Wallet(wallet_id, wallert_name, balance, currency, create_date) " +
                "VALUES(((select max(wallet_id) from Wallet)+1), \'" + wallet.getWallertName() + "\'," + wallet.getBalance()
                + ","+ wallet.getCurrency() +", TO_DATE(\'"+ wallet.getCreateDate() +"\', \'dd/mm/yyyy\'))";

        Query<Wallet> query = session.createSQLQuery(sql);
        log.info("save.query: " + query.toString());

        query.executeUpdate();
    }

    @Override
    public void update(Wallet wallet) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "UPDATE Wallet SET wallert_name = " + wallet.getWallertName() + ", balance = " + wallet.getBalance() + ", currency = " + wallet.getCurrency() + ", create_date = TO_DATE(\'"+ wallet.getCreateDate() +"\', \'dd/mm/yyyy\')"
                + "WHERE wallet_id = :wallet_id";

        Query<Wallet> query = session.createSQLQuery(sql);
        log.info("update.query: " + query.toString());

        query.executeUpdate();
    }

    @Override
    public void delete(int wallet_id) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "DELETE FROM Wallet w Where w.walletId = :wallet_id";

        Query<Wallet> query = session.createQuery(sql, Wallet.class);
        query.setParameter("wallet_id", wallet_id);
        log.info("delete.query: " + query.toString());

        query.executeUpdate();
    }
}

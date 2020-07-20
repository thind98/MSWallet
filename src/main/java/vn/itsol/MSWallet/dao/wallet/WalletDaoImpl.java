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
        String hql = "From Wallet w";
        Query<Wallet> query = session.createQuery(hql, Wallet.class);
        log.info("WalletDaoImpl.getWallets.hql: " + hql);
        List<Wallet> listResult = query.getResultList();
        log.info("WalletDaoImpl.getWallets.listResult: " + listResult.toString());
        return listResult;
    }

    @Override
    public Wallet getWallet(int wallet_id) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "From Wallet w Where w.walletId = " + wallet_id;
        Query<Wallet> query = session.createQuery(hql, Wallet.class);
        log.info("WalletDaoImpl.getWallet.hql: " + hql);
        Wallet result = query.getSingleResult();
        log.info("WalletDaoImpl.getWallet.result: " + result);
        return result;
    }

    @Override
    public void save(Wallet wallet) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "INSERT INTO Wallet(wallert_name, balance, currency, create_date) " +
                "VALUES(\'" + wallet.getWallertName() + "\',\'" + wallet.getBalance() + "\',"+ wallet.getCurrency() +",\'"+ wallet.getCreateDate() +"\')";
        log.info("WalletDaoImpl.save.sql: " + sql);
        Query<Wallet> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void update(Wallet wallet) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "UPDATE Wallet SET ";
        if(wallet.getWallertName() != null || wallet.getWallertName() != ""){
            sql = sql + "wallert_name = \'" + wallet.getWallertName() + "\'";
        }

        if (wallet.getBalance() != 0){
           sql = sql + "balance = " + wallet.getBalance();
        }

        if (wallet.getCurrency() != 0){
            sql = sql + "currency = " + wallet.getCurrency();
        }

        if (wallet.getCreateDate() != null){
            sql = sql + "create_date = " + wallet.getCreateDate();
        }

        Query<Wallet> query = session.createSQLQuery(sql);
        log.info("WalletDaoImpl.update.sql: " + sql);
        query.executeUpdate();
    }

    @Override
    public void delete(int wallet_id) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "DELETE FROM Wallet w Where w.wallet_id = " + wallet_id;
        Query<Wallet> query = session.createSQLQuery(sql);
        log.info("WalletDaoImpl.delete.sql: " + sql);
        query.executeUpdate();
    }
}

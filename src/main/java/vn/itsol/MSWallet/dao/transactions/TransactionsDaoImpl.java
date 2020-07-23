package vn.itsol.MSWallet.dao.transactions;

import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.Transactions;

import javax.persistence.EntityManager;
import java.util.List;

@Repository
public class TransactionsDaoImpl implements TransactionsDao
{
    private static final Logger log = LoggerFactory.getLogger(TransactionsDaoImpl.class);

    @Autowired
    private EntityManager entityManager;

    @Override
    public List<Transactions> getTransactions() {
        Session session = entityManager.unwrap(Session.class);
        String hql = "From Transactions t";
        Query<Transactions> query = session.createQuery(hql, Transactions.class);
        List<Transactions> list = query.getResultList();
        return list;
    }

    @Override
    public Transactions getTransaction(int tran_id) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "From Transactions t Where t.transId = " + tran_id;
        Query<Transactions> query = session.createQuery(hql, Transactions.class);
        Transactions result = query.getSingleResult();
        return result;
    }

    @Override
    public void save(Transactions transactions) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "Insert Into transactions(trans_id, amount, trans_type, datetime, note, user_id, wallet_id, category_id)\n" +
                     "values(((SELECT MAX(trans_id) FROM transactions)+1), " + transactions.getAmount() + ", " + transactions.getTransType()
                     + ", TO_DATE(\'" + transactions.getDate() + "\', 'dd/mm/yyyy'), '" + transactions.getNote() + "', " + transactions.getUserId()
                     + ", " + transactions.getWalletId() + ", " + transactions.getCategoryId() + ")";
        Query<Transactions> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void update(Transactions transactions) {
        Session session = entityManager.unwrap(Session.class);
        String sql = "update transactions SET amount = " + transactions.getAmount() + ", trans_type = " + transactions.getTransType() + ", datetime = " + transactions.getDate() + ", note = " + transactions.getNote() + ", user_id = " + transactions.getUserId() + ", wallet_id = " + transactions.getWalletId() + ", category_id = "+ transactions.getCategoryId() +" WHERE trans_id = " + transactions.getTransId();
        Query<Transactions> query = session.createSQLQuery(sql);
        query.executeUpdate();
    }

    @Override
    public void delete(int tran_id) {
        Session session = entityManager.unwrap(Session.class);
        String hql = "delete From Transactions t Where t.transId = " + tran_id;
        Query<Transactions> query = session.createQuery(hql, Transactions.class);
        query.executeUpdate();
    }
}

package vn.itsol.MSWallet.dao.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import vn.itsol.MSWallet.entities.Transactions;

import java.util.List;

@Repository
public class TransactionsDaoImpl implements TransactionsDao
{
    private static final Logger log = LoggerFactory.getLogger(TransactionsDaoImpl.class);

    @Override
    public List<Transactions> GetTransactions() {
        return null;
    }

    @Override
    public Transactions getTransaction(int tran_id) {
        return null;
    }

    @Override
    public void save(Transactions transactions) {

    }

    @Override
    public void delete(int tran_id) {

    }
}

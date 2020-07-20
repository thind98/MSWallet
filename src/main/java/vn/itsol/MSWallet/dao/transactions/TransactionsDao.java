package vn.itsol.MSWallet.dao.transactions;

import vn.itsol.MSWallet.entities.Transactions;

import java.util.List;

public interface TransactionsDao {
    List<Transactions> GetTransactions();
    Transactions getTransaction(int tran_id);
    void save(Transactions transactions);
    void delete(int tran_id);
}

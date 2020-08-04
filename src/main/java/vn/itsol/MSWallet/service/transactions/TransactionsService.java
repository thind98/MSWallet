package vn.itsol.MSWallet.service.transactions;

import vn.itsol.MSWallet.dto.TransactionsDto;
import vn.itsol.MSWallet.dto.WalletDto;
import vn.itsol.MSWallet.entities.Transactions;

import java.util.List;

public interface TransactionsService
{
    List<TransactionsDto> getTransactionsUser(int user_id);
    List<TransactionsDto> getTransactionsCategory(int category_id);
    List<TransactionsDto> getTransactionsWallet(int wallet_id);
    TransactionsDto gettran(int tran_id);
    void save(TransactionsDto tran);
    void update(TransactionsDto tran);
    void delete(int tran_id);
}

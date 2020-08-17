package vn.itsol.MSWallet.service.transactions;

import vn.itsol.MSWallet.dto.TransactionsDisplay;
import vn.itsol.MSWallet.dto.TransactionsDto;

import java.util.List;

public interface TransactionsService
{
    List<TransactionsDisplay> getTransactionsUser(int user_id);
    List<TransactionsDto> getTransactionsCategory(int category_id);
    List<TransactionsDto> getTransactionsWallet(int wallet_id);
    TransactionsDto gettran(int tran_id);
    TransactionsDto save(TransactionsDto tran);
    TransactionsDto update(TransactionsDto tran);
    void delete(int tran_id);
}

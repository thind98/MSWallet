package vn.itsol.MSWallet.service.transactions;

import vn.itsol.MSWallet.dto.TransactionsDto;
import vn.itsol.MSWallet.dto.WalletDto;
import vn.itsol.MSWallet.entities.Transactions;

import java.util.List;

public interface TransactionsService
{
    List<TransactionsDto> gettrans();
    TransactionsDto gettran(int tran_id);
    void save(TransactionsDto tran);
    void update(TransactionsDto tran);
    void delete(int tran_id);
}

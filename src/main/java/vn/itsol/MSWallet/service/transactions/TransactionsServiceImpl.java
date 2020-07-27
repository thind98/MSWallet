package vn.itsol.MSWallet.service.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.itsol.MSWallet.dao.transactions.TransactionsDao;
import vn.itsol.MSWallet.dto.TransactionsDto;
import vn.itsol.MSWallet.entities.Transactions;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransactionsServiceImpl implements TransactionsService
{
    private static final Logger log = LoggerFactory.getLogger(TransactionsServiceImpl.class);

    @Autowired
    private TransactionsDao transactionsDao;

    @Transactional
    @Override
    public List<TransactionsDto> gettrans() {
        List<Transactions> transactionsList = transactionsDao.getTransactions();
        List<TransactionsDto> transactionsDtos = new ArrayList<>();
        for(Transactions tran : transactionsList){
            TransactionsDto transactionsDto = new TransactionsDto();

            transactionsDto.setAmount(tran.getAmount());
            transactionsDto.setCategoryId(tran.getCategoryId());
            transactionsDto.setDate(tran.getDate());
            transactionsDto.setNote(tran.getNote());
            transactionsDto.setTransId(tran.getTransId());
            transactionsDto.setTransType(tran.getTransType());
            transactionsDto.setUserId(tran.getTransType());
            transactionsDto.setCategoryId(tran.getCategoryId());

            transactionsDtos.add(transactionsDto);
        }
        return transactionsDtos;
    }

    @Transactional
    @Override
    public TransactionsDto gettran(int tran_id) {
        Transactions tran = transactionsDao.getTransaction(tran_id);

        TransactionsDto transactionsDto = new TransactionsDto();

        transactionsDto.setAmount(tran.getAmount());
        transactionsDto.setCategoryId(tran.getCategoryId());
        transactionsDto.setDate(tran.getDate());
        transactionsDto.setNote(tran.getNote());
        transactionsDto.setTransId(tran.getTransId());
        transactionsDto.setTransType(tran.getTransType());
        transactionsDto.setUserId(tran.getTransType());
        transactionsDto.setCategoryId(tran.getCategoryId());

        return transactionsDto;
    }

    @Transactional
    @Override
    public void save(TransactionsDto tran) {
        Transactions transactions = new Transactions();
        transactions.setAmount(tran.getAmount());
        transactions.setCategoryId(tran.getCategoryId());
        transactions.setDate(tran.getDate());
        transactions.setNote(tran.getNote());
        transactions.setTransId(tran.getTransId());
        transactions.setTransType(tran.getTransType());
        transactions.setUserId(tran.getTransType());
        transactions.setCategoryId(tran.getCategoryId());

        transactionsDao.save(transactions);
    }

    @Transactional
    @Override
    public void update(TransactionsDto tran) {
        Transactions transactions = new Transactions();
        transactions.setAmount(tran.getAmount());
        transactions.setCategoryId(tran.getCategoryId());
        transactions.setDate(tran.getDate());
        transactions.setNote(tran.getNote());
        transactions.setTransId(tran.getTransId());
        transactions.setTransType(tran.getTransType());
        transactions.setUserId(tran.getTransType());
        transactions.setCategoryId(tran.getCategoryId());

        transactionsDao.update(transactions);
    }

    @Transactional
    @Override
    public void delete(int tran_id) {
        transactionsDao.delete(tran_id);
    }
}

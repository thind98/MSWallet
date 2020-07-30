package vn.itsol.MSWallet.service.transactions;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import vn.itsol.MSWallet.dao.transactions.TransactionsDao;
import vn.itsol.MSWallet.dto.TransactionsDto;
import vn.itsol.MSWallet.entities.Category;
import vn.itsol.MSWallet.entities.Transactions;
import vn.itsol.MSWallet.entities.Users;
import vn.itsol.MSWallet.entities.Wallet;

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
            transactionsDto.setCategoryId(tran.getCategory().getCategoryid());
            transactionsDto.setDate(tran.getDate());
            transactionsDto.setNote(tran.getNote());
            transactionsDto.setTransId(tran.getTransId());
            transactionsDto.setTransType(tran.getTransType());
            transactionsDto.setUserId(tran.getUsers().getUserId());
            transactionsDto.setWalletId(tran.getWallet().getWalletId());

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
        transactionsDto.setCategoryId(tran.getCategory().getCategoryid());
        transactionsDto.setDate(tran.getDate());
        transactionsDto.setNote(tran.getNote());
        transactionsDto.setTransId(tran.getTransId());
        transactionsDto.setTransType(tran.getTransType());
        transactionsDto.setUserId(tran.getUsers().getUserId());
        transactionsDto.setWalletId(tran.getWallet().getWalletId());

        return transactionsDto;
    }

    @Transactional
    @Override
    public void save(TransactionsDto tran) {
        Transactions transactions = new Transactions();

        Category category = new Category();
        category.setCategoryid(tran.getCategoryId());

        Users users = new Users();
        users.setUserId(tran.getUserId());

        Wallet wallet = new Wallet();
        wallet.setWalletId(tran.getWalletId());

        transactions.setAmount(tran.getAmount());
        transactions.setCategory(category);
        transactions.setDate(tran.getDate());
        transactions.setNote(tran.getNote());
        transactions.setTransId(tran.getTransId());
        transactions.setTransType(tran.getTransType());
        transactions.setUsers(users);
        transactions.setWallet(wallet);

        transactionsDao.save(transactions);
    }

    @Transactional
    @Override
    public void update(TransactionsDto tran) {
        Transactions transactions = new Transactions();

        Category category = new Category();
        category.setCategoryid(tran.getCategoryId());

        Users users = new Users();
        users.setUserId(tran.getUserId());

        Wallet wallet = new Wallet();
        wallet.setWalletId(tran.getWalletId());

        transactions.setAmount(tran.getAmount());
        transactions.setCategory(category);
        transactions.setDate(tran.getDate());
        transactions.setNote(tran.getNote());
        transactions.setTransId(tran.getTransId());
        transactions.setTransType(tran.getTransType());
        transactions.setUsers(users);
        transactions.setWallet(wallet);

        transactionsDao.update(transactions);
    }

    @Transactional
    @Override
    public void delete(int tran_id) {
        transactionsDao.delete(tran_id);
    }
}

package vn.itsol.MSWallet.service.transactions;

import org.modelmapper.ModelMapper;
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
    public List<TransactionsDto> getTransactionsUser(int user_id) {
        List<Transactions> transactionsList = transactionsDao.getTransactionsUser(user_id);
        List<TransactionsDto> transactionsDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        for(Transactions transactions : transactionsList){
            TransactionsDto  transactionsDto = modelMapper.map(transactions, TransactionsDto.class);
            transactionsDto.setUserId(transactions.getUsers().getUserId());
            transactionsDtoList.add(transactionsDto);
        }
        return transactionsDtoList;
    }

    @Transactional
    @Override
    public List<TransactionsDto> getTransactionsCategory(int category_id) {
        List<Transactions> transactionsList = transactionsDao.getTransactionsCategory(category_id);
        List<TransactionsDto> transactionsDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        for(Transactions transactions : transactionsList){
            TransactionsDto transactionsDto = modelMapper.map(transactions, TransactionsDto.class);
            transactionsDto.setUserId(transactions.getUsers().getUserId());
            transactionsDtoList.add(transactionsDto);
        }
        return transactionsDtoList;
    }

    @Transactional
    @Override
    public List<TransactionsDto> getTransactionsWallet(int wallet_id) {
        List<Transactions> transactionsList = transactionsDao.getTransactionsWallet(wallet_id);
        List<TransactionsDto> transactionsDtoList = new ArrayList<>();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        for (Transactions transactions : transactionsList)
        {
            TransactionsDto transactionsDto = modelMapper.map(transactions, TransactionsDto.class);
            transactionsDto.setUserId(transactions.getUsers().getUserId());
            transactionsDtoList.add(transactionsDto);
        }
        return transactionsDtoList;
    }

    @Transactional
    @Override
    public TransactionsDto gettran(int tran_id) {
        Transactions transactions = transactionsDao.getTransaction(tran_id);
        TransactionsDto transactionsDto = new TransactionsDto();
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setAmbiguityIgnored(true);
        transactionsDto = modelMapper.map(transactions, TransactionsDto.class);
        transactionsDto.setUserId(transactions.getUsers().getUserId());
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

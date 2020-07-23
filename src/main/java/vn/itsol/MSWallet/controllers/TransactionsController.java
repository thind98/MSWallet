package vn.itsol.MSWallet.controllers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import vn.itsol.MSWallet.dto.TransactionsDto;
import vn.itsol.MSWallet.entities.Transactions;
import vn.itsol.MSWallet.service.transactions.TransactionsService;

import java.util.List;

@RestController
@RequestMapping(path = "/trans")
public class TransactionsController
{
    private static final Logger log = LoggerFactory.getLogger(TransactionsController.class);

    @Autowired
    private TransactionsService transactionsService;

//    @GetMapping(path = "findall")
//    public List<TransactionsDto> getTransactions(){
//        List<TransactionsDto> results = transactionsService.
//    }
}

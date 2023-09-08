package jpa.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.stereotype.Service;
import jpa.repository.AccountRepository;

@Service
public class AccountService {
    @Autowired
    AccountRepository accountRepository;
    private JpaTransactionManager transactionManager;

    // Dependency injection via constructor
    public AccountService(JpaTransactionManager transactionManager){
        this.transactionManager = transactionManager;
    }
    public AccountService(){
    }
}

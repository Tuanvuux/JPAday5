package jpa.serviceImp;

import jpa.entity.AccountEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import jpa.repository.AccountRepository;
import jpa.service.IAccountService;

import java.util.List;

@Service
public class AccountServiceImp implements IAccountService {
    @Autowired
    AccountRepository accountRepository;

    @Override
    public List<AccountEntity> listAccout() {
        return (List<AccountEntity>) accountRepository.findAll();
    }
}

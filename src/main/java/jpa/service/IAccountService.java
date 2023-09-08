package jpa.service;

import jpa.entity.AccountEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;



public interface IAccountService {
    List<AccountEntity> listAccout();
}

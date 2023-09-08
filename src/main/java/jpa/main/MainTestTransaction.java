package jpa.main;

import jpa.configuration.JPAConfig;
import jpa.service.IAccountService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import jpa.repository.AccountRepository;
import jpa.service.AccountService;
import jpa.serviceImp.AccountServiceImp;

public class MainTestTransaction {
    static AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(JPAConfig.class);
    static AccountRepository accountRepository = applicationContext.getBean("accountRepository", AccountRepository.class);
    static AccountService accountService = applicationContext.getBean("accountService", AccountService.class);
    static AccountServiceImp iAccountService = applicationContext.getBean("accountServiceImp", AccountServiceImp.class);
    public static void main(String[] args) throws Exception {

        System.out.println("list size");
        System.out.println(iAccountService.listAccout().size());
    }
}

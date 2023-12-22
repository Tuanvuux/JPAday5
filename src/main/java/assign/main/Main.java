package assign.main;

import assign.config.Config;
import assign.entity.Customer;
import assign.repository.CustomerRepository;
import assign.entity.Customer;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);
    static CustomerRepository customerRepository = (CustomerRepository) context.getBean("customerRepository");

    public static void main(String[] args) {
        createNewAccount();
        List<Customer> CustomerList = customerRepository.findAll();
        Optional<Customer> Cust1 = customerRepository.findById(1);
        List<Customer> Cus = customerRepository.findByName("Vu");
        List<Customer> Cuss = customerRepository.findByNameOrEmail("Vu","Vu@gmail.com");
        List<Customer> Cus20to30 = customerRepository.findMaleCustomersBetween20And30();


    }

    private static void createNewAccount(){
        Customer customer = new Customer();
        customer.setName("NguyenHuyTuanVu");
        customer.setBirthdate(LocalDate.of(2003, 10, 14));
        customer.setSex("Nam");
        customer.setEmail("vu@gmail.com");
        customer.setPhone("0377720320");
        customer.setAddress("Hue");

        Customer result = customerRepository.save(customer);
        if(result!=null){
            System.out.println("da them thanh cong, id ="+ customer.getId());
        }

    }
}

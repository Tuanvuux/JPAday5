package assign.repository;

import assign.entity.Customer;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import javax.naming.Name;
import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends CrudRepository<Customer, Integer> {
    List<Customer> findAll();
    Optional<Customer> findById(Integer Id);

    List<Customer> findByName(String name);

    List<Customer> findByNameOrEmail(String name, String email);

    @Query("SELECT c FROM Customer c WHERE c.sex = 'Nam' AND YEAR(CURRENT_DATE) - YEAR(c.birthdate) BETWEEN 20 AND 30")
    List<Customer> findMaleCustomersBetween20And30();




}

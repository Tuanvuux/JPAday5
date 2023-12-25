package assignment2.repository;

import assignment2.entity.Orderdetails;
import assignment2.entity.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderDetailsRepository extends CrudRepository<Orderdetails, Integer> {

    @Query("SELECT od FROM Orderdetails od")
    List<Orderdetails> findAllOrderDetails();
    @Query("Select o from Orderdetails o where o.quantity* o.unitPrice>10000")
    List<Orderdetails> higher1000();

    @Query("select o from Orderdetails o where o.productName = :name")
    List<Orderdetails> findByProductName(@Param("name") String name);


}

package assignment2.repository;

import assignment2.entity.Orders;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface OrderRepository extends CrudRepository<Orders,Integer> {

    @Query("Select b from Orders b ")
    List<Orders> findAll();

    @Query("SELECT o FROM Orders o WHERE o.id = :id")
    List<Orders> findById(@Param("id") int id);

    @Query("SELECT o FROM Orders o WHERE MONTH(o.orderDate) = :month")
    List<Orders> findByMonth(@Param("month") int month);






}

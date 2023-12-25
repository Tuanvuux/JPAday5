package assignment2.main;

import assignment2.config.Config;
import assignment2.entity.Orderdetails;
import assignment2.entity.Orders;
import assignment2.repository.OrderDetailsRepository;
import assignment2.repository.OrderRepository;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import javax.persistence.Id;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    static ApplicationContext context = new AnnotationConfigApplicationContext(Config.class);


    static OrderRepository order =(OrderRepository) context.getBean(OrderRepository.class);
    static OrderDetailsRepository orderDetails = (OrderDetailsRepository) context.getBean(OrderDetailsRepository.class);
    public static void main(String[] args) {

        createNewOrder();
        ordersAndorderdetails();
        byID(1);
        LocalDate currentDate = LocalDate.now();
        int currentMonth = currentDate.getMonthValue();
        findByMonth(currentMonth);

        higher1000();

        findByName("Java");



    }

    static Orders createNewOrder() {
        Orderdetails newOrderdetails = new Orderdetails();
        newOrderdetails.setProductName("ORDER111");
        newOrderdetails.setQuantity(10);
        newOrderdetails.setUnitPrice(100);


        Orders newOrder = new Orders();
        newOrder.setOrderDate(LocalDate.parse("2003-10-13"));
        newOrder.setCustomerName("vu");
        newOrder.setCustomerAddress("hue");


        List<Orderdetails> orderDetailsList = new ArrayList<>();
        orderDetailsList.add(newOrderdetails);

        newOrder.setOrderDetails(orderDetailsList);

        order.save(newOrder);
        return newOrder;
    }

    public static void ordersAndorderdetails(){
        List<Orders> orders= order.findAll();
        for(Orders c:orders){
            System.out.println(c.getId());
            System.out.println(c.getCustomerName()+c.getOrderDate());

        }

        List<Orderdetails> orderdetails=orderDetails.findAllOrderDetails();
        for(Orderdetails c: orderdetails){
            System.out.println(c.getId()+c.getProductName());
        }


    }

    public static void byID(int id) {
        List<Orders> orders = order.findById(id);
        for (Orders c : orders) {
            System.out.println(c.getId());
            System.out.println(c.getCustomerName() + c.getOrderDate());


        }
    }

    public static void findByMonth(int month) {
        List<Orders> orders = order.findByMonth(month);
        for (Orders c : orders) {
            System.out.println("BY MONTH" + c.getId());
            System.out.println(c.getCustomerName() + c.getOrderDate());


        }
    }

    public static void higher1000(){
    List<Orderdetails> orders = orderDetails.higher1000();
     for (Orderdetails c : orders) {
         System.out.println(">1000" + c.getId());


     }}

    public static void findByName(String name) {
        List<Orderdetails> orders = orderDetails.findByProductName(name);
        for (Orderdetails c : orders) {
            System.out.println("Name" + c.getId());
        }
    }


    }

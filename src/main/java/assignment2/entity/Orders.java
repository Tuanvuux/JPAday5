package assignment2.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Orders")
public class Orders {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "orderDate")
    @DateTimeFormat(pattern = "yyyy-MM-dd") // Định nghĩa định dạng ngày nếu cần thiết
    private LocalDate orderDate;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerAddress")
    private String customerAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Orderdetails> orderDetails;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public List<Orderdetails> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<Orderdetails> orderDetails) {
        this.orderDetails = orderDetails;
    }

}

package assignment2.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
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
    private Date orderDate;

    @Column(name = "customerName")
    private String customerName;

    @Column(name = "customerAddress")
    private String customerAddress;

    @OneToMany(mappedBy = "order", cascade = CascadeType.ALL)
    private List<Orderdetails> orderDetails;

    // Các hàm khởi tạo, getter, setter, v.v.
}

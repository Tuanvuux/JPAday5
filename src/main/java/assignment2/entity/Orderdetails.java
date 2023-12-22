package assignment2.entity;

import javax.persistence.*;

@Entity
@Table(name = "Orderdetails")
public class Orderdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId")
    private Orders order;

    @Column(name = "productName")
    private String productName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitPrice")
    private double unitPrice;

    // Các hàm khởi tạo, getter, setter, v.v.
}

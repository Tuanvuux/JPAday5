package assignment2.entity;

import javax.persistence.*;

@Entity
@Table(name = "Orderdetails")
public class Orderdetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "orderId")
    private Orders order;

    @Column(name = "productName")
    private String productName;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "unitPrice")
    private double unitPrice;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Orders getOrder() {
        return order;
    }

    public void setOrder(Orders order) {
        this.order = order;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }
// Các hàm khởi tạo, getter, setter, v.v.
}

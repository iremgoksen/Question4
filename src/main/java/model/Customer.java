package model;

import javax.persistence.*;

@Entity
@Table(name="customer")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "customer_name")
    private String customer_name;

    @Column(name = "customer_surname")
    private String customer_surname;

    @Column(name= "customer_telno")
    private int customer_telno;

    @Column(name= "customer_room_no")
    private int customer_room_no;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getCustomer_name() {
        return customer_name;
    }
    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public String getCustomer_surname() {
        return customer_surname;
    }
    public void setCustomer_surname(String customer_surname) {
        this.customer_surname = customer_surname;
    }

    public int getCustomer_telno() {
        return customer_telno;
    }
    public void setCustomer_telno(int customer_telno) {
        this.customer_telno = customer_telno;
    }

    public int getCustomer_room_no() {
        return customer_room_no;
    }
    public void setCustomer_room_no(int customer_room_no) {
        this.customer_room_no = customer_room_no;
    }
}

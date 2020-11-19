package com.assessment.packagemanager.model;



import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="product")
public class Product {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="pid")
    private Integer pid;

    @Column(name="id")
    private String id;

    @Column(name="name")
    private String name;

    @Column(name="usd_price")
    private Double usdPrice;

//    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.REFRESH},
//            fetch = FetchType.LAZY)
//    private List<Package> packages = new ArrayList<Package>();

    public Product(String id, String name, Double usdPrice) {
        this.id = id;
        this.name = name;
        this.usdPrice = usdPrice;

    }

    public Product() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUsdPrice() {
        return usdPrice;
    }

    public void setUsdPrice(Double usdPrice) {
        this.usdPrice = usdPrice;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

//    public void setPackages(List<Package> packages) {
//        this.packages = packages;
//    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", usdPrice=" + usdPrice +
                '}';
    }
}

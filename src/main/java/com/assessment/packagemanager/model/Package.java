package com.assessment.packagemanager.model;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="package")
public class Package {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @Column(name="name")
    private String name;

    @Column(name="description")
    private String description;

    @ManyToMany(fetch = FetchType.LAZY,
            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH}
            )
    @JoinTable(name="package_product",
            joinColumns = @JoinColumn(name="package_id"),
            inverseJoinColumns = @JoinColumn(name="product_id")
    )
    private List<Product> products = new ArrayList<Product>();

    @Column(name="price")
    private Double price;

    public Package() {

    }

    public Package(String name, String description, ArrayList<Product> products) {

        this.name = name;
        this.description = description;
        this.products = products;
        this.price=getTotalPrice(products);
    }

    public void setPrice(Double price){
        this.price=price;
    }

    public Double getTotalPrice(List<Product> products){
        Double totalPrice=0.0;
        if(products!=null)
            for(Product p:products){
                totalPrice=p.getUsdPrice()+totalPrice;
            }
        return totalPrice;
    }



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(ArrayList<Product> products) {
        this.products = products;
    }

    public void setProductsandFixPrices(ArrayList<Product> products){
        this.products = products;
        this.price=getTotalPrice(products);
    }

    public Double getPrice() {
        return price;
    }

    public void addProduct(Product product){
        if(products==null){
            products=new ArrayList<Product>();
        }
        this.products.add(product);
    }



    @Override
    public String toString() {
        return "Package{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", products=" + products +
                ", price=" + price +
                '}';
    }
}


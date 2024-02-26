package com.adminPanel.app.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_details")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ProductDetails {
    @Id
    @Column(name="id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name="expiration_date")
    private Date expirationDate;

    @Column(name = "manufacturer")
    private String manufacturer;

    @Column(name = "price")
    private double price ;

    @Column(name = "available")
    private  boolean available ;



    @OneToOne(mappedBy = "productDetails",cascade = CascadeType.ALL)
    private Product product ;

}

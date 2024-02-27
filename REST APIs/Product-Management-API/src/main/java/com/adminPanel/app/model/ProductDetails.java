package com.adminPanel.app.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "product_details")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ApiModel("Details of product ")
public class ProductDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty("id of description")
    private int id;

    @Column(name = "name")
    @ApiModelProperty("name of product")
    private String name;

    @Column(name = "expiration_date")
    @ApiModelProperty("expiration date of prroduct")
    private Date expirationDate;

    @Column(name = "manufacturer")
    @ApiModelProperty("the factory of product")
    private String manufacturer;

    @Column(name = "price")
    @ApiModelProperty("price")
    private double price;

    @Column(name = "available")
    @ApiModelProperty("exist or not ")
    private boolean available;
    @JsonIgnore
    @OneToOne(mappedBy = "productDetails", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Product product;
}

package com.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "clinics")
public class Clinic {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = true,name="google_maps_link")
    private String googleMapsLink;

    @Column(nullable = false)
    private String address;

    @Column(name="owner_name")
    private String ownerName;

    private String specialization;


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "user_id")
    @OneToOne( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;


}

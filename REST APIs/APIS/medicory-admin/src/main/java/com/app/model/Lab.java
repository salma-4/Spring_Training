package com.app.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

import javax.persistence.*;

@Entity
@Table(name = "labs")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Lab {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "name",nullable = false)
    private String name;

    @Column(name="google_maps_link")
    private String googleMapsLink;

    @Column(name="address",nullable = false)
    private String address;

    @Column(name="owner_name")
    private String ownerName;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @JoinColumn(name = "user_id")
    @OneToOne( cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    private User user;

}

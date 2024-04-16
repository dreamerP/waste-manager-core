package com.example.wastemanagercore.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name ="Waste_Manager")
@NoArgsConstructor
@AllArgsConstructor
public class WasteManagerEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Getter
    @Setter
    private Long id;

    @Getter
    @Setter
    private String nombre;

    @Getter
    @Setter
    private String nif;

    @Getter
    @Setter
    private Long wasteManagerAddressID;

    @OneToMany(mappedBy = "wasteManager", cascade = CascadeType.ALL)
    @Getter
    @Setter
    private List<WasteCenterAuthorizationEntity> listOfWasteCenterAuthorization = new ArrayList<>();

    @Getter
    @Setter
    private Boolean isEnabled = Boolean.TRUE;

    @Getter
    @Setter
    private Long version = 0L;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(updatable = false)
    @Getter
    @Setter
    private Date createdDate;

    @Temporal(TemporalType.TIMESTAMP)
    @Getter
    @Setter
    private Date lastModifiedDate;

    @PrePersist
    protected void onCreate() {
        this.createdDate = (this.createdDate == null) ? new Date() : this.createdDate;
        this.lastModifiedDate = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        this.lastModifiedDate = new Date();
    }
}

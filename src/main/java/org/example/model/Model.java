package org.example.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "model")
public class Model implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @Column
    private String name;
    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brandId;

    @OneToMany(mappedBy = "modelId", fetch = FetchType.EAGER)
    private List<Vehicle> modelYears;

    public Model() {
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

    public Brand getBrandId() {
        return brandId;
    }

    public void setBrandId(Brand brandId) {
        this.brandId = brandId;
    }

    public List<Vehicle> getModelYears() {
        return modelYears;
    }

    public void setModelYears(List<Vehicle> modelYears) {
        this.modelYears = modelYears;
    }
}

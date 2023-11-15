package com.store.demo.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Data
@Entity
@Table(name = "Product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Double price;
    private String image;
    private String brand;
	@JsonIgnore
    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetails;
	@JsonIgnore
    @OneToOne(mappedBy = "product")
    private CPU cpu;

	@ManyToOne
	@JoinColumn(name = "categoryid")
	Category category;
}

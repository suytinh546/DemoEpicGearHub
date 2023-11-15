package com.store.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "CPU")
public class CPU implements Serializable{
@Id
private String id;
private String productid;
private String socket;
private String cpu_series;
private String toltal_cores;
private String toltal_threads;
private String performance_core_base_frequency;
private String max_turbo_frequency;
private String power;
@ManyToOne
@JoinColumn(name = "productid", insertable = false, updatable = false)
private Product product;
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nnpcgroup.onboarding.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 18359
 */
@Entity
@Table(name = "medical")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Medical.findAll", query = "SELECT m FROM Medical m"),
    @NamedQuery(name = "Medical.findById", query = "SELECT m FROM Medical m WHERE m.id = :id"),
    @NamedQuery(name = "Medical.findByHeight", query = "SELECT m FROM Medical m WHERE m.height = :height"),
    @NamedQuery(name = "Medical.findByBloodGroup", query = "SELECT m FROM Medical m WHERE m.bloodGroup = :bloodGroup")})
public class Medical implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "HEIGHT")
    private Float height;
    @Size(max = 2)
    @Column(name = "BLOOD_GROUP")
    private String bloodGroup;
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private Employee employee;

    public Medical() {
    }

    public Medical(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Float getHeight() {
        return height;
    }

    public void setHeight(Float height) {
        this.height = height;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Medical)) {
            return false;
        }
        Medical other = (Medical) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnpcgroup.hr.entity.Medical[ id=" + id + " ]";
    }
    
}

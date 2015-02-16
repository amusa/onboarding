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
@Table(name = "next_of_kin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "NextOfKin.findAll", query = "SELECT n FROM NextOfKin n"),
    @NamedQuery(name = "NextOfKin.findById", query = "SELECT n FROM NextOfKin n WHERE n.id = :id"),
    @NamedQuery(name = "NextOfKin.findByName", query = "SELECT n FROM NextOfKin n WHERE n.name = :name"),
    @NamedQuery(name = "NextOfKin.findByRelationship", query = "SELECT n FROM NextOfKin n WHERE n.relationship = :relationship"),
    @NamedQuery(name = "NextOfKin.findByPhoneNumber", query = "SELECT n FROM NextOfKin n WHERE n.phoneNumber = :phoneNumber"),
    @NamedQuery(name = "NextOfKin.findByAddress", query = "SELECT n FROM NextOfKin n WHERE n.address = :address")})
public class NextOfKin implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "NAME")
    private String name;
    @Size(max = 20)
    @Column(name = "RELATIONSHIP")
    private String relationship;
    @Size(max = 15)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Size(max = 100)
    @Column(name = "ADDRESS")
    private String address;
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "ID")
    @ManyToOne
    private Employee employee;
    @JoinColumn(name = "NOK_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne
    private NokType nokType;

    public NextOfKin() {
    }

    public NextOfKin(Integer id) {
        this.id = id;
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

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public NokType getNokType() {
        return nokType;
    }

    public void setNokType(NokType nokType) {
        this.nokType = nokType;
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
        if (!(object instanceof NextOfKin)) {
            return false;
        }
        NextOfKin other = (NextOfKin) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnpcgroup.hr.entity.NextOfKin[ id=" + id + " ]";
    }
    
}

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
@Table(name = "address")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Address.findAll", query = "SELECT a FROM Address a"),
    @NamedQuery(name = "Address.findById", query = "SELECT a FROM Address a WHERE a.id = :id"),
    @NamedQuery(name = "Address.findByAddressLine1", query = "SELECT a FROM Address a WHERE a.addressLine1 = :addressLine1"),
    @NamedQuery(name = "Address.findByAddressLine2", query = "SELECT a FROM Address a WHERE a.addressLine2 = :addressLine2"),
    @NamedQuery(name = "Address.findByPhoneNumber", query = "SELECT a FROM Address a WHERE a.phoneNumber = :phoneNumber")})
public class Address implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "ADDRESS_LINE1")
    private String addressLine1;
    @Size(max = 45)
    @Column(name = "ADDRESS_LINE2")
    private String addressLine2;
    @Size(max = 15)
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @JoinColumn(name = "ADDR_TYPE_ID", referencedColumnName = "ID")
    @ManyToOne(optional = false)
    private AddressType addrType;
    @JoinColumn(name = "CITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private City city;
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "ID")
    @ManyToOne
    private Employee employee;
    @JoinColumn(name = "STATE_ID", referencedColumnName = "ID")
    @ManyToOne
    private State state;

    public Address() {
    }

    public Address(Integer id) {
        this.id = id;
    }

    public Address(Integer id, String addressLine1) {
        this.id = id;
        this.addressLine1 = addressLine1;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public AddressType getAddrType() {
        return addrType;
    }

    public void setAddrType(AddressType addrType) {
        this.addrType = addrType;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmplId(Employee employee) {
        this.employee = employee;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
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
        if (!(object instanceof Address)) {
            return false;
        }
        Address other = (Address) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnpcgroup.hr.entity.Address[ id=" + id + " ]";
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nnpcgroup.onboarding.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 18359
 */
@Entity
@Table(name = "dependant")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dependant.findAll", query = "SELECT d FROM Dependant d"),
    @NamedQuery(name = "Dependant.findById", query = "SELECT d FROM Dependant d WHERE d.id = :id"),
    @NamedQuery(name = "Dependant.findBySurname", query = "SELECT d FROM Dependant d WHERE d.surname = :surname"),
    @NamedQuery(name = "Dependant.findByOtherName", query = "SELECT d FROM Dependant d WHERE d.otherName = :otherName"),
    @NamedQuery(name = "Dependant.findByRelationship", query = "SELECT d FROM Dependant d WHERE d.relationship = :relationship"),
    @NamedQuery(name = "Dependant.findByBirthDate", query = "SELECT d FROM Dependant d WHERE d.birthDate = :birthDate")})
public class Dependant implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 45)
    @Column(name = "OTHER_NAME")
    private String otherName;
    @Size(max = 45)
    @Column(name = "RELATIONSHIP")
    private String relationship;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @JoinColumn(name = "COUNTRY_OF_BIRTH_ID", referencedColumnName = "ID")
    @ManyToOne
    private Country countryOfBirth;
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "ID")
    @ManyToOne
    private Employee employee;
    @JoinColumn(name = "NATIONALITY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Country nationality;

    public Dependant() {
    }

    public Dependant(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getOtherName() {
        return otherName;
    }

    public void setOtherName(String otherName) {
        this.otherName = otherName;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Country getCountryOfBirth() {
        return countryOfBirth;
    }

    public void setCountryOfBirth(Country countryOfBirth) {
        this.countryOfBirth = countryOfBirth;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmplId(Employee employee) {
        this.employee = employee;
    }

    public Country getNationality() {
        return nationality;
    }

    public void setNationality(Country nationality) {
        this.nationality = nationality;
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
        if (!(object instanceof Dependant)) {
            return false;
        }
        Dependant other = (Dependant) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnpcgroup.hr.entity.Dependant[ id=" + id + " ]";
    }
    
}

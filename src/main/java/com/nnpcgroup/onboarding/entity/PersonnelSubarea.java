/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nnpcgroup.onboarding.entity;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author 18359
 */
@Entity
@Table(name = "personnel_subarea")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonnelSubarea.findAll", query = "SELECT p FROM PersonnelSubarea p"),
    @NamedQuery(name = "PersonnelSubarea.findById", query = "SELECT p FROM PersonnelSubarea p WHERE p.id = :id"),
    @NamedQuery(name = "PersonnelSubarea.findByDescription", query = "SELECT p FROM PersonnelSubarea p WHERE p.description = :description")})
public class PersonnelSubarea implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 3)
    @Column(name = "ID")
    private String id;
    @Size(max = 45)
    @Column(name = "DESCRIPTION")
    private String description;
    @JoinColumn(name = "PERS_AREA_ID", referencedColumnName = "ID")
    @ManyToOne
    private PersonnelArea persArea;
    @OneToMany(mappedBy = "persSubarea")
    private List<Employee> employeeList;

    public PersonnelSubarea() {
    }

    public PersonnelSubarea(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public PersonnelArea getPersArea() {
        return persArea;
    }

    public void setPersAreaId(PersonnelArea persArea) {
        this.persArea = persArea;
    }

    @XmlTransient
    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
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
        if (!(object instanceof PersonnelSubarea)) {
            return false;
        }
        PersonnelSubarea other = (PersonnelSubarea) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return getDescription();
    }
    
}

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
@Table(name = "personnel_area")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PersonnelArea.findAll", query = "SELECT p FROM PersonnelArea p"),
    @NamedQuery(name = "PersonnelArea.findById", query = "SELECT p FROM PersonnelArea p WHERE p.id = :id"),
    @NamedQuery(name = "PersonnelArea.findByDescription", query = "SELECT p FROM PersonnelArea p WHERE p.description = :description")})
public class PersonnelArea implements Serializable {
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
    @OneToMany(mappedBy = "persArea")
    private List<PersonnelSubarea> personnelSubareaList;

    public PersonnelArea() {
    }

    public PersonnelArea(String id) {
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

    @XmlTransient
    public List<PersonnelSubarea> getPersonnelSubareaList() {
        return personnelSubareaList;
    }

    public void setPersonnelSubareaList(List<PersonnelSubarea> personnelSubareaList) {
        this.personnelSubareaList = personnelSubareaList;
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
        if (!(object instanceof PersonnelArea)) {
            return false;
        }
        PersonnelArea other = (PersonnelArea) object;
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

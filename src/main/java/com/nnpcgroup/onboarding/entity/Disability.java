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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 18359
 */
@Entity
@Table(name = "disability")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disability.findAll", query = "SELECT d FROM Disability d"),
    @NamedQuery(name = "Disability.findById", query = "SELECT d FROM Disability d WHERE d.id = :id"),
    @NamedQuery(name = "Disability.findByDisability", query = "SELECT d FROM Disability d WHERE d.disability = :disability"),
    @NamedQuery(name = "Disability.findByFormOfDisability", query = "SELECT d FROM Disability d WHERE d.formOfDisability = :formOfDisability")})
public class Disability implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ID")
    private Integer id;
    @Size(max = 3)
    @Column(name = "DISABILITY")
    private String disability;
    @Size(max = 70)
    @Column(name = "FORM_OF_DISABILITY")
    private String formOfDisability;    
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "ID")
    @ManyToOne
    private Employee employee;

    public Disability() {
    }

    public Disability(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDisability() {
        return disability;
    }

    public void setDisability(String disability) {
        this.disability = disability;
    }

    public String getFormOfDisability() {
        return formOfDisability;
    }

    public void setFormOfDisability(String formOfDisability) {
        this.formOfDisability = formOfDisability;
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
        if (!(object instanceof Disability)) {
            return false;
        }
        Disability other = (Disability) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnpcgroup.hr.entity.Disability[ id=" + id + " ]";
    }
    
}

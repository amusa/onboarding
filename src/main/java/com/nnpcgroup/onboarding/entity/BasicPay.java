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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author 18359
 */
@Entity
@Table(name = "basic_pay")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BasicPay.findAll", query = "SELECT b FROM BasicPay b"),
    @NamedQuery(name = "BasicPay.findById", query = "SELECT b FROM BasicPay b WHERE b.id = :id"),
    @NamedQuery(name = "BasicPay.findByGradeLevel", query = "SELECT b FROM BasicPay b WHERE b.gradeLevel = :gradeLevel"),
    @NamedQuery(name = "BasicPay.findByAnnualSalary", query = "SELECT b FROM BasicPay b WHERE b.annualSalary = :annualSalary")})
public class BasicPay implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id    
    @Column(name = "ID")
    private Integer id;
    @Size(max = 5)
    @Column(name = "GRADE_LEVEL")
    private String gradeLevel;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "ANNUAL_SALARY")
    private Double annualSalary;
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "ID")
    @OneToOne(optional = false)
    private Employee employee;

    public BasicPay() {
    }

    public BasicPay(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public Double getAnnualSalary() {
        return annualSalary;
    }

    public void setAnnualSalary(Double annualSalary) {
        this.annualSalary = annualSalary;
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
        if (!(object instanceof BasicPay)) {
            return false;
        }
        BasicPay other = (BasicPay) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnpcgroup.hr.entity.BasicPay[ id=" + id + " ]";
    }
    
}

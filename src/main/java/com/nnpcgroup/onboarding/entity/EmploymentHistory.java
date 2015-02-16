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
@Table(name = "employment_history")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EmploymentHistory.findAll", query = "SELECT e FROM EmploymentHistory e"),
    @NamedQuery(name = "EmploymentHistory.findById", query = "SELECT e FROM EmploymentHistory e WHERE e.id = :id"),
    @NamedQuery(name = "EmploymentHistory.findByPrevEmpl", query = "SELECT e FROM EmploymentHistory e WHERE e.prevEmpl = :prevEmpl")})
public class EmploymentHistory implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 3)
    @Column(name = "PREV_EMPL")
    private String prevEmpl;
    @OneToMany(mappedBy = "emplHistory")
    private List<Employment> employmentList;
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "ID")
    @ManyToOne
    private Employee employee;

    public EmploymentHistory() {
    }

    public EmploymentHistory(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPrevEmpl() {
        return prevEmpl;
    }

    public void setPrevEmpl(String prevEmpl) {
        this.prevEmpl = prevEmpl;
    }

    @XmlTransient
    public List<Employment> getEmploymentList() {
        return employmentList;
    }

    public void setEmploymentList(List<Employment> employmentList) {
        this.employmentList = employmentList;
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
        if (!(object instanceof EmploymentHistory)) {
            return false;
        }
        EmploymentHistory other = (EmploymentHistory) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnpcgroup.hr.entity.EmploymentHistory[ id=" + id + " ]";
    }
    
}

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
@Table(name = "employment")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employment.findAll", query = "SELECT e FROM Employment e"),
    @NamedQuery(name = "Employment.findById", query = "SELECT e FROM Employment e WHERE e.id = :id"),
    @NamedQuery(name = "Employment.findByEmployer", query = "SELECT e FROM Employment e WHERE e.employer = :employer"),
    @NamedQuery(name = "Employment.findByPositionHeld", query = "SELECT e FROM Employment e WHERE e.positionHeld = :positionHeld"),
    @NamedQuery(name = "Employment.findByStartDate", query = "SELECT e FROM Employment e WHERE e.startDate = :startDate"),
    @NamedQuery(name = "Employment.findByEndDate", query = "SELECT e FROM Employment e WHERE e.endDate = :endDate")})
public class Employment implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID")
    private Integer id;
    @Size(max = 60)
    @Column(name = "EMPLOYER")
    private String employer;
    @Size(max = 60)
    @Column(name = "POSITION_HELD")
    private String positionHeld;
    @Column(name = "START_DATE")
    @Temporal(TemporalType.DATE)
    private Date startDate;
    @Column(name = "END_DATE")
    @Temporal(TemporalType.DATE)
    private Date endDate;
    @JoinColumn(name = "EMPL_HIST_ID", referencedColumnName = "ID")
    @ManyToOne
    private EmploymentHistory emplHistory;

    public Employment() {
    }

    public Employment(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmployer() {
        return employer;
    }

    public void setEmployer(String employer) {
        this.employer = employer;
    }

    public String getPositionHeld() {
        return positionHeld;
    }

    public void setPositionHeld(String positionHeld) {
        this.positionHeld = positionHeld;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public EmploymentHistory getEmplHistory() {
        return emplHistory;
    }

    public void setEmplHistory(EmploymentHistory emplHistory) {
        this.emplHistory = emplHistory;
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
        if (!(object instanceof Employment)) {
            return false;
        }
        Employment other = (Employment) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnpcgroup.hr.entity.Employment[ id=" + id + " ]";
    }
    
}

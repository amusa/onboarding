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
@Table(name = "bank_detail")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BankDetail.findAll", query = "SELECT b FROM BankDetail b"),
    @NamedQuery(name = "BankDetail.findById", query = "SELECT b FROM BankDetail b WHERE b.id = :id"),
    @NamedQuery(name = "BankDetail.findByBankName", query = "SELECT b FROM BankDetail b WHERE b.bankName = :bankName"),
    @NamedQuery(name = "BankDetail.findByBankBranch", query = "SELECT b FROM BankDetail b WHERE b.bankBranch = :bankBranch"),
    @NamedQuery(name = "BankDetail.findByAccountNo", query = "SELECT b FROM BankDetail b WHERE b.accountNo = :accountNo"),
    @NamedQuery(name = "BankDetail.findByBankSortCode", query = "SELECT b FROM BankDetail b WHERE b.bankSortCode = :bankSortCode")})
public class BankDetail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "ID")
    private Integer id;
    @Size(max = 45)
    @Column(name = "BANK_NAME")
    private String bankName;
    @Size(max = 45)
    @Column(name = "BANK_BRANCH")
    private String bankBranch;
    @Size(max = 45)
    @Column(name = "ACCOUNT_NO")
    private String accountNo;
    @Size(max = 45)
    @Column(name = "BANK_SORT_CODE")
    private String bankSortCode;
    @JoinColumn(name = "EMPL_ID", referencedColumnName = "ID")
    @ManyToOne
    private Employee employee;

    public BankDetail() {
    }

    public BankDetail(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(String bankBranch) {
        this.bankBranch = bankBranch;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getBankSortCode() {
        return bankSortCode;
    }

    public void setBankSortCode(String bankSortCode) {
        this.bankSortCode = bankSortCode;
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
        if (!(object instanceof BankDetail)) {
            return false;
        }
        BankDetail other = (BankDetail) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.nnpcgroup.hr.entity.BankDetail[ id=" + id + " ]";
    }

}

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
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
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
@Table(name = "employee")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e"),
    @NamedQuery(name = "Employee.findById", query = "SELECT e FROM Employee e WHERE e.id = :id"),
    @NamedQuery(name = "Employee.findByEmplNo", query = "SELECT e FROM Employee e WHERE e.emplNo = :emplNo"),
    @NamedQuery(name = "Employee.findByFoa", query = "SELECT e FROM Employee e WHERE e.foa = :foa"),
    @NamedQuery(name = "Employee.findByHireDate", query = "SELECT e FROM Employee e WHERE e.hireDate = :hireDate"),
    @NamedQuery(name = "Employee.findBySurname", query = "SELECT e FROM Employee e WHERE e.surname = :surname"),
    @NamedQuery(name = "Employee.findByFirstName", query = "SELECT e FROM Employee e WHERE e.firstName = :firstName"),
    @NamedQuery(name = "Employee.findByMiddleName", query = "SELECT e FROM Employee e WHERE e.middleName = :middleName"),
    @NamedQuery(name = "Employee.findByMaidenName", query = "SELECT e FROM Employee e WHERE e.maidenName = :maidenName"),
    @NamedQuery(name = "Employee.findByEmplType", query = "SELECT e FROM Employee e WHERE e.emplType = :emplType"),
    @NamedQuery(name = "Employee.findByPostion", query = "SELECT e FROM Employee e WHERE e.postion = :postion"),
    @NamedQuery(name = "Employee.findByInitial", query = "SELECT e FROM Employee e WHERE e.initial = :initial"),
    @NamedQuery(name = "Employee.findByGradeLevel", query = "SELECT e FROM Employee e WHERE e.gradeLevel = :gradeLevel"),
    @NamedQuery(name = "Employee.findBySubgroup", query = "SELECT e FROM Employee e WHERE e.subgroup = :subgroup"),
    @NamedQuery(name = "Employee.findByBirthDate", query = "SELECT e FROM Employee e WHERE e.birthDate = :birthDate"),
    @NamedQuery(name = "Employee.findByLanguages", query = "SELECT e FROM Employee e WHERE e.languages = :languages"),
    @NamedQuery(name = "Employee.findBySex", query = "SELECT e FROM Employee e WHERE e.sex = :sex"),
    @NamedQuery(name = "Employee.findByMaritalStatus", query = "SELECT e FROM Employee e WHERE e.maritalStatus = :maritalStatus"),
    @NamedQuery(name = "Employee.findByNoOfChildren", query = "SELECT e FROM Employee e WHERE e.noOfChildren = :noOfChildren"),
    @NamedQuery(name = "Employee.findByReligion", query = "SELECT e FROM Employee e WHERE e.religion = :religion")})
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic
    //@NotNull
    @Column(name = "ID")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 5)
    @Column(name = "EMPL_NO")
    private String emplNo;
    @Size(max = 10)
    @Column(name = "FOA")
    private String foa;
    @Column(name = "HIRE_DATE")
    @Temporal(TemporalType.DATE)
    private Date hireDate;
    @Size(max = 40)
    @Column(name = "SURNAME")
    private String surname;
    @Size(max = 40)
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Size(max = 40)
    @Column(name = "MIDDLE_NAME")
    private String middleName;
    @Size(max = 45)
    @Column(name = "MAIDEN_NAME")
    private String maidenName;
    @Size(max = 10)
    @Column(name = "EMPL_TYPE")
    private String emplType;
    @Size(max = 45)
    @Column(name = "POSTION")
    private String postion;
    @Size(max = 4)
    @Column(name = "INITIAL")
    private String initial;
    @Size(max = 3)
    @Column(name = "GRADE_LEVEL")
    private String gradeLevel;
    @Size(max = 10)
    @Column(name = "SUBGROUP")
    private String subgroup;
    @Column(name = "BIRTH_DATE")
    @Temporal(TemporalType.DATE)
    private Date birthDate;
    @Size(max = 50)
    @Column(name = "LANGUAGES")
    private String languages;
    @Size(max = 6)
    @Column(name = "SEX")
    private String sex;
    @Size(max = 10)
    @Column(name = "MARITAL_STATUS")
    private String maritalStatus;
    @Column(name = "NO_OF_CHILDREN")
    private Integer noOfChildren;
    @Size(max = 15)
    @Column(name = "RELIGION")
    private String religion;
    @JoinColumn(name = "COUNTRY_ID", referencedColumnName = "ID")
    @ManyToOne
    private Country country;
    @JoinColumn(name = "LGA_ID", referencedColumnName = "ID")
    @ManyToOne
    private Lga lga;
    @JoinColumn(name = "PERS_SUBAREA_ID", referencedColumnName = "ID")
    @ManyToOne
    private PersonnelSubarea persSubarea;
    @JoinColumn(name = "STATE_ID", referencedColumnName = "ID")
    @ManyToOne
    private State state;

    public Employee() {
    }

    public Employee(Integer id) {
        this.id = id;
    }

    public Employee(Integer id, String emplNo) {
        this.id = id;
        this.emplNo = emplNo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmplNo() {
        return emplNo;
    }

    public void setEmplNo(String emplNo) {
        this.emplNo = emplNo;
    }

    public String getFoa() {
        return foa;
    }

    public void setFoa(String foa) {
        this.foa = foa;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFullName() {
        return surname + " " + firstName;
    }

    public String getMaidenName() {
        return maidenName;
    }

    public void setMaidenName(String maidenName) {
        this.maidenName = maidenName;
    }

    public String getEmplType() {
        return emplType;
    }

    public void setEmplType(String emplType) {
        this.emplType = emplType;
    }

    public String getPostion() {
        return postion;
    }

    public void setPostion(String postion) {
        this.postion = postion;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel;
    }

    public String getSubgroup() {
        return subgroup;
    }

    public void setSubgroup(String subgroup) {
        this.subgroup = subgroup;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public Integer getNoOfChildren() {
        return noOfChildren;
    }

    public void setNoOfChildren(Integer noOfChildren) {
        this.noOfChildren = noOfChildren;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public Country getCountry() {
        return country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    public Lga getLga() {
        return lga;
    }

    public void setLga(Lga lga) {
        this.lga = lga;
    }

    public PersonnelSubarea getPersSubarea() {
        return persSubarea;
    }

    public void setPersSubarea(PersonnelSubarea persSubarea) {
        this.persSubarea = persSubarea;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("\nId:").append(getId()).
                append("\nID no: ").append(getEmplNo()).
                append("\nFn ").append(getFirstName()).
                append("\nSn ").append(getSurname()).
                append("\nBD ").append(getBirthDate()).
                append("\nGLevel: ").append(getGradeLevel()).
                append("\nMaiden name: ").append(getMaidenName()).
                append("\nLGA: ").append(getLga()).
                append("\nState: ").append(getState()).
                append("\nCountry: ").append(getCountry()).
                append("\nFOA: ").append(getFoa()).
                append("\nSubgroup: ").append(getSubgroup()).
                append("\nLanguage: ").append(getLanguages()).
                append("\nPosition: ").append(getPostion()).
                append("\nMarital Status").append(getMaritalStatus()).
                append("\nHiredate: ").append(getHireDate());

        return sb.toString();
    }

}

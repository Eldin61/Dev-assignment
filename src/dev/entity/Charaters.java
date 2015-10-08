/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.entity;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Orlando
 */
@Entity
@Table(name = "charaters")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Charaters.findAll", query = "SELECT c FROM Charaters c"),
    @NamedQuery(name = "Charaters.findByName", query = "SELECT c FROM Charaters c WHERE c.name = :name"),
    @NamedQuery(name = "Charaters.findByClass1", query = "SELECT c FROM Charaters c WHERE c.class1 = :class1"),
    @NamedQuery(name = "Charaters.findByRace", query = "SELECT c FROM Charaters c WHERE c.race = :race"),
    @NamedQuery(name = "Charaters.findByLevel", query = "SELECT c FROM Charaters c WHERE c.level = :level")})
public class Charaters implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @Column(name = "class")
    private String class1;
    @Basic(optional = false)
    @Column(name = "race")
    private String race;
    @Basic(optional = false)
    @Column(name = "level")
    private int level;
    @JoinTable(name = "owns", joinColumns = {
        @JoinColumn(name = "name", referencedColumnName = "name")}, inverseJoinColumns = {
        @JoinColumn(name = "user_name", referencedColumnName = "user_name")})
    @ManyToMany
    private Collection<Users> usersCollection;

    public Charaters() {
    }

    public Charaters(String name) {
        this.name = name;
    }

    public Charaters(String name, String class1, String race, int level) {
        this.name = name;
        this.class1 = class1;
        this.race = race;
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getClass1() {
        return class1;
    }

    public void setClass1(String class1) {
        this.class1 = class1;
    }

    public String getRace() {
        return race;
    }

    public void setRace(String race) {
        this.race = race;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    @XmlTransient
    public Collection<Users> getUsersCollection() {
        return usersCollection;
    }

    public void setUsersCollection(Collection<Users> usersCollection) {
        this.usersCollection = usersCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (name != null ? name.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Charaters)) {
            return false;
        }
        Charaters other = (Charaters) object;
        if ((this.name == null && other.name != null) || (this.name != null && !this.name.equals(other.name))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "dev.entity.Charaters[ name=" + name + " ]";
    }
    
}

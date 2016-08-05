/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Basic;
import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author delfi
 */
@Entity
@Table(name="tbl_usuario")
public class User implements  Serializable
{
	private static final long serialVersionUID = -2894036291351849049L;
	@Id
        @Column(name = "usuario",nullable = false)
        private String username;
        @JsonIgnore
	@OneToMany(mappedBy = "delegator")
	private Set<Task>given;
        @JsonIgnore
	@OneToMany(mappedBy = "delegated")
	private Set<Task>recepted;
        @Column(name="nome",nullable = false)
        private String name;
        @OneToMany(mappedBy = "team")
        @JsonIgnore
	private Set<Project>projects;
	@OneToMany(mappedBy = "inCharge")
        @JsonIgnore
	private Set<Project>inChargeOf;
        @JsonIgnore
        @Column(name = "senha",nullable = false)
        @Basic(fetch = FetchType.LAZY)
        private String password;
	

    public User() 
    {
    }

    public User(String username, String name) {
        this.username = username;
        this.name = name;
    }
    
    

    public User(String username) {
        this.username = username;
    }
        
        
        
	
	public String getUsername() 
	{
		return username;
	}

	public void setUsername(String username) 
	{
		this.username = username;
	}

    public Set<Task> getGiven() {
        return given;
    }

    public void setGiven(Set<Task> given) {
        this.given = given;
    }

    public Set<Task> getRecepted() {
        return recepted;
    }

    public void setRecepted(Set<Task> recepted) {
        this.recepted = recepted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Project> getProjects() {
        return projects;
    }

    public void setProjects(Set<Project> projects) {
        this.projects = projects;
    }

    public Set<Project> getInChargeOf() {
        return inChargeOf;
    }

    public void setInChargeOf(Set<Project> inChargeOf) {
        this.inChargeOf = inChargeOf;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 89 * hash + Objects.hashCode(this.username);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final User other = (User) obj;
        if (!Objects.equals(this.username, other.username)) {
            return false;
        }
        return true;
    }
    
    
}

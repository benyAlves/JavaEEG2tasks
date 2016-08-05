/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import moz.dev.group.tasks.converters.LocalDateTimeAttributeConverter;
import util.LocalDateTimeJsonDeserializer;
import util.LocalDateTimeJsonSerializer;

/**
 *
 * @author delfi
 */
@Entity
@Table(name="tbl_projecto")
public class Project implements Serializable
{
       @Id
       private long id;
       @Column(name = "nome",nullable = false)
       private String name;
       @Convert(converter=LocalDateTimeAttributeConverter.class)
       @JsonDeserialize(using=LocalDateTimeJsonDeserializer.class)
       @JsonSerialize(using = LocalDateTimeJsonSerializer.class)
       @Column(name="inicio",nullable = false)
       private LocalDateTime start;
       @Convert(converter=LocalDateTimeAttributeConverter.class)
       @JsonDeserialize(using=LocalDateTimeJsonDeserializer.class)
       @JsonSerialize(using = LocalDateTimeJsonSerializer.class)
       @Column(name="fim",nullable = false)
       private LocalDateTime end;
       @OneToMany(mappedBy = "project")
       private Set<ProjectTask>tasks;
       @OneToMany
       private Set<User>team;
       @ManyToOne()
       @JoinColumn(name = "responsavel",nullable = false)
       private User inCharge;
       @Column(nullable = true,updatable = true,name = "descricao")
       private String description;
       
       
       
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public Set<ProjectTask> getTasks() {
        return tasks;
    }

    public void setTasks(Set<ProjectTask> tasks) {
        this.tasks = tasks;
    }

    public Set<User> getTeam() {
        return team;
    }

    public void setTeam(Set<User> team) {
        this.team = team;
    }

    public User getInCharge() {
        return inCharge;
    }

    public void setInCharge(User inCharge) {
        this.inCharge = inCharge;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
       
       
       
}

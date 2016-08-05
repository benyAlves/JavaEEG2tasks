/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 *
 * @author delfi
 */
@Entity
@Table(name="tbl_tarefa_de_projecto")
@PrimaryKeyJoinColumn(name="codigo")
public class ProjectTask extends  Task
{
    @JoinColumn(name = "projecto",nullable = false,updatable = false)
    @ManyToOne
    private Project project;

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
    
    
    
}

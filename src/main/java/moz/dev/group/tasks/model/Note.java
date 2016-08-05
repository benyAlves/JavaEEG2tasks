package moz.dev.group.tasks.model;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;

import javax.persistence.Convert;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import moz.dev.group.tasks.converters.LocalDateTimeAttributeConverter;

@Entity
@Table(name="tbl_notas")
public class Note implements Serializable
{
	private static final long serialVersionUID = 2593281406659022282L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "codigo",nullable = false,updatable = false)
	private long id;
        @Column(name = "nome",nullable = false)
	private String name;
        @Column(name = "descricao",nullable = false)
	private String description;
	@Convert(converter=LocalDateTimeAttributeConverter.class)
        @Column(name="criado_em",nullable = false)
	private LocalDateTime instant;
        @ManyToOne
        @JoinColumn(name="tarefa")
        private Task task;
        
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getInstant() {
		return instant;
	}
	public void setInstant(LocalDateTime instant) {
		this.instant = instant;
	}

    public Task getTask() {
        return task;
    }

    public void setTask(Task task) {
        this.task = task;
    }
	
	
}

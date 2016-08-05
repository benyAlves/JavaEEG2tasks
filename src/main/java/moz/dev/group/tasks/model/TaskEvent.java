package moz.dev.group.tasks.model;


import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;

import javax.persistence.ManyToOne;
import javax.persistence.Table;
import moz.dev.group.tasks.converters.LocalDateTimeAttributeConverter;

@Entity
@Table(name="tbl_evento")
public class TaskEvent implements Serializable 
{
	private static final long serialVersionUID = 2942335827196560876L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name="codigo")
	private long id;
	@ManyToOne
        @JoinColumn(name="tarefa",nullable = false)
	private Task AbstractTask;
	@Enumerated
        @Column(name="estado",nullable = false)
	private TaskState state;
	@Convert(converter=LocalDateTimeAttributeConverter.class)
        @Column(name="instate",nullable = false)
	private LocalDateTime instant;
        @Column(name="descricao",nullable = true)
	private String description;
	
	
	public Task getAbstractTask() {
		return AbstractTask;
	}
	public void setAbstractTask(Task AbstractTask) {
		this.AbstractTask = AbstractTask;
	}
	public TaskState getState() {
		return state;
	}
	public void setState(TaskState state) {
		this.state = state;
	}
	public LocalDateTime getInstant() {
		return instant;
	}
	public void setInstant(LocalDateTime instant) {
		this.instant = instant;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	
}

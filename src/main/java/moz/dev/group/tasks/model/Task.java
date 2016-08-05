package moz.dev.group.tasks.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;

import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import javax.persistence.OneToMany;
import javax.persistence.Table;
import moz.dev.group.tasks.converters.LocalDateTimeAttributeConverter;
import moz.dev.group.tasks.converters.TaskStateConverter;
import util.LocalDateTimeJsonDeserializer;
import util.LocalDateTimeJsonSerializer;

@Entity
@Table(name="tbl_tarefa")
@Inheritance(strategy = InheritanceType.JOINED)
public class Task implements Serializable 
{
	private static final long serialVersionUID = 241558579729706849L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
        @Column(name = "codigo",nullable = false)
	private Long id;
        @Column(name="nome",nullable = false)
	private String name;
        @Column(name="descricao")
	private String description;
	@ManyToOne
        @JoinColumn(name="alvo",nullable = false,updatable = true)
	private User delegated;
	@ManyToOne
        @JoinColumn(name="delegador",nullable = false,updatable = false)
	private User delegator;
	@Convert(converter=LocalDateTimeAttributeConverter.class)
        @Column(name = "criado_em",nullable = false)
         @JsonDeserialize(using=LocalDateTimeJsonDeserializer.class)
        @JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	private LocalDateTime instant;
        @JsonIgnore
	@OneToMany(mappedBy = "AbstractTask",cascade = CascadeType.ALL)
	private Set<TaskEvent>events;
        @JsonIgnore
	@OneToMany(cascade = CascadeType.ALL)
	private Set<Note>notes;
        @JsonProperty
        @Convert(converter=LocalDateTimeAttributeConverter.class)
        @Column(name = "inicio_esperado",nullable = false,updatable = true)
        @JsonDeserialize(using=LocalDateTimeJsonDeserializer.class)
        @JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	private LocalDateTime possibleStart;
        @Column(name = "fim_esperado",nullable = false,updatable = true)
	@Convert(converter=LocalDateTimeAttributeConverter.class)
        @JsonDeserialize(using=LocalDateTimeJsonDeserializer.class)
        @JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	private LocalDateTime possibleEnd;
        @Column(name = "inicio_real",nullable = true,updatable = false)
        @Convert(converter=LocalDateTimeAttributeConverter.class)
        @JsonDeserialize(using=LocalDateTimeJsonDeserializer.class)
        @JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	private LocalDateTime start;
        @Column(name = "fim_real",nullable = true,updatable = false)
        @Convert(converter=LocalDateTimeAttributeConverter.class)
        @JsonDeserialize(using=LocalDateTimeJsonDeserializer.class)
        @JsonSerialize(using = LocalDateTimeJsonSerializer.class)
	private LocalDateTime end;
        
        @Column(name="estado",nullable = false)
        @Convert(converter=TaskStateConverter.class)
	private TaskState state;

    public Task() 
    {
    }

    public Task(Long id, String name, String description, User delegated, User delegator, LocalDateTime instant, TaskState state, Set<TaskEvent> events, Set<Note> notes, LocalDateTime possibleStart, LocalDateTime possibleEnd, LocalDateTime start, LocalDateTime end) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.delegated = delegated;
        this.delegator = delegator;
        this.instant = instant;
        this.state = state;
        this.events = events;
        this.notes = notes;
        this.possibleStart = possibleStart;
        this.possibleEnd = possibleEnd;
        this.start = start;
        this.end = end;
    }

    public Task(Long id, String name, User delegated, User delegator, TaskState state) 
    {
        this.id = id;
        this.name = name;
        this.delegated = delegated;
        this.delegator = delegator;
        this.state = state;
    }
    
    

    public Task(TaskState state) {
        this.state = state;
    }
         
         
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
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
	public User getDelegated() {
		return delegated;
	}
	public void setDelegated(User delegated) {
		this.delegated = delegated;
	}
	public User getDelegator() {
		return delegator;
	}
	public void setDelegator(User delegator) {
		this.delegator = delegator;
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
	public Set<TaskEvent> getEvents() {
		return events;
	}
	public void setEvents(Set<TaskEvent> events) {
		this.events = events;
	}
	public Set<Note> getNotes() {
		return notes;
	}
	public void setNotes(Set<Note> notes) {
		this.notes = notes;
	}

    public LocalDateTime getPossibleStart() {
        return possibleStart;
    }

    public void setPossibleStart(LocalDateTime possibleStart) {
        this.possibleStart = possibleStart;
    }

    public LocalDateTime getPossibleEnd() {
        return possibleEnd;
    }

    public void setPossibleEnd(LocalDateTime possibleEnd) {
        this.possibleEnd = possibleEnd;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() 
    {
        return end;
    }

    public void setEnd(LocalDateTime end) 
    {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Task{" + "id=" + id + ", name=" + name + ", description=" + description + ", delegated=" + delegated + ", possibleStart=" + possibleStart + ", possibleEnd=" + possibleEnd + '}';
    }
	

	
}

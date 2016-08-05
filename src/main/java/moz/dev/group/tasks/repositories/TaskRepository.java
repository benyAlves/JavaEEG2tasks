/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.repositories;

import java.time.LocalDateTime;
import java.util.Set;
import moz.dev.group.tasks.model.Task;
import moz.dev.group.tasks.model.TaskState;
import moz.dev.group.tasks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import util.TransactionalRepository;

/**
 *
 * @author delfi
 */
public interface TaskRepository extends  JpaRepository<Task, Long>,TransactionalRepository
{
    @Query("select t from Task t where t.delegator=:user or t.delegated=:user order by t.instant")
    Set<Task>findByDelegatorOrDelegatedOrderByInstant(@Param("user")User user);
    Set<Task>findByState(TaskState state);
    Set<Task>findByDelegator(User delegator);
    Set<Task>findByDelegated(User delegator);
    Set<Task> findByStateAndDelegator(TaskState state,User delegator);
    Set<Task> findByStateAndDelegated(TaskState state,User delegator);
    @Query("select t.state in (:states) from Task t where t.id=:id")
    public boolean check(@Param("id")long id,@Param("states")TaskState... states);
    @Query("select t.state from Task t where t.id=:id")
    public TaskState getState(@Param("id")long task);
    
    @Modifying(clearAutomatically = true)
    @Query("update Task t set t.state=:state where t.id=:id")
    public void update(@Param("id")long id,@Param("state")TaskState state);
    
    @Modifying(clearAutomatically = true)
    @Query("update Task t set t.state=:state, t.end=:instant where t.id=:id")
    public void finish(@Param("id")long id,@Param("state")TaskState state,@Param("instant")LocalDateTime instant);
    
    @Modifying(clearAutomatically = true)
    @Query("update Task t set t.state=:state, t.start=:instant where t.id=:id")
    public void start(@Param("id")long id,@Param("state")TaskState state,@Param("instant")LocalDateTime instant);
    
    
    @Query("select new moz.dev.group.tasks.model.Task(t.id,t.name,t.delegated,t.delegator,t.state) from Task t where t.id=:id")
    public Task getSimplified(@Param("id")long task);
}

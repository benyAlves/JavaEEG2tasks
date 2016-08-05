/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.services.impl;

import java.time.LocalDateTime;
import java.util.Set;
import javax.ejb.Stateful;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.inject.Named;
import moz.dev.group.tasks.model.Task;
import moz.dev.group.tasks.model.TaskState;
import moz.dev.group.tasks.model.User;
import moz.dev.group.tasks.repositories.TaskRepository;
import moz.dev.group.tasks.services.exceptions.BussinessLogicException;
import moz.dev.group.tasks.services.exceptions.InvalidTaskStateChangeException;
import moz.dev.group.tasks.services.interfaces.TaskManagementService;

/**
 *
 * @author delfi
 */
@Stateful
public class TaskManagmentImpl implements TaskManagementService
{
    @Inject
    @Default
    private TaskRepository repository;
    
    @Override
    public Task findOne(long id, User user) throws SecurityException
    {
        Task task=repository.findOne(id);
        if(task.getDelegated().equals(user) || task.getDelegator().equals(user))
            return task;
        else
            throw new SecurityException();
    }

    @Override
    public Set<Task> findAll(User user) 
    {
     
        return this.repository.findByDelegatorOrDelegatedOrderByInstant(user);
    }

    @Override
    public Task save(Task task) throws BussinessLogicException
    {
       return  this.repository.save(task);
    }

    @Override
    public TaskState changeState(long id, TaskState taskState, User user) throws BussinessLogicException 
    {
        Task simplified=repository.getSimplified(id);
        
        if(simplified.getDelegated().equals(user) || simplified.getDelegator().equals(user))
        {
            TaskState actual=simplified.getState();
            if(TaskState.CANCELED.equals(taskState) )
            {
                if(simplified.getDelegated().equals(user))
                {
                    //TODO SEND MAIL TO DELEGATOR
                    return TaskState.CANCELED;
                }
                else
                {
                    LocalDateTime instant=LocalDateTime.now();
                    this.repository.finish(id, taskState, instant);
                    return TaskState.CANCELED;
                }
            }
            else
            {
                if(simplified.getDelegated().equals(user))
                {
                    if(TaskState.canChange(actual, taskState))
                    {
                        if(taskState.equals(TaskState.SUCESSFUL))
                        {
                            LocalDateTime instant=LocalDateTime.now();
                            this.repository.finish(id, taskState, instant);
                            return taskState;
                        }
                        else if(taskState.equals(TaskState.EXECUTING) && actual.equals(TaskState.NOT_STARTED))
                        {
                            LocalDateTime instant=LocalDateTime.now();
                            this.repository.start(id, taskState, instant);
                            return taskState;
                        }
                        else
                        {
                            this.repository.update(id, taskState);
                            return taskState;
                        }
                    }
                }
                throw new InvalidTaskStateChangeException();
            }
        }
        else
            throw new SecurityException();
      
      
    }
    
}

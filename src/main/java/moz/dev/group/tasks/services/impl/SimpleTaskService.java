/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.services.impl;

import java.util.Set;
import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import moz.dev.group.tasks.model.Task;
import moz.dev.group.tasks.model.TaskState;
import moz.dev.group.tasks.model.User;
import moz.dev.group.tasks.repositories.TaskRepository;
import moz.dev.group.tasks.services.interfaces.TaskJpaService;

/**
 *
 * @author delfi
 */
@Dependent
@Default
public class SimpleTaskService implements TaskJpaService
{
    @Inject
    @Default
    private TaskRepository repository;

    @Override
    public TaskRepository getRepository() 
    {
        return this.repository;
    }

    @Override
    public Set<Task> findByState(TaskState state) 
    {
        return this.getRepository().findByState(state);
    }

    @Override
    public Set<Task> findByDelegator(User delegator) 
    {
         return this.getRepository().findByDelegator(delegator);
    }

    @Override
    public Set<Task> findByDelegated(User delegator) 
    {
         return this.getRepository().findByDelegated(delegator);
    }

    @Override
    public Set<Task> findByStateAndDelegator(TaskState state, User delegator) 
    {
        return this.getRepository().findByStateAndDelegator(state, delegator);
    }

    @Override
    public Set<Task> findByStateAndDelegated(TaskState state, User delegator) 
    {
        return this.getRepository().findByStateAndDelegated(state, delegator);
    }

    @Override
    public boolean isValid(Task task) 
    {
       return this.getRepository().check(task.getId(), TaskState.EXECUTING,TaskState.WAIT);
    }
    
}

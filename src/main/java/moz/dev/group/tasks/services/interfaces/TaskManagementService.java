/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.services.interfaces;

import java.util.Set;
import moz.dev.group.tasks.model.Task;
import moz.dev.group.tasks.model.TaskState;
import moz.dev.group.tasks.model.User;
import moz.dev.group.tasks.services.exceptions.BussinessLogicException;

/**
 *
 * @author delfi
 */
public interface TaskManagementService 
{
    public Task findOne(long id,User user) throws SecurityException;
    public Set<Task>findAll(User user);
    public Task save(Task task) throws BussinessLogicException;
    public TaskState changeState(long id,TaskState state,User user)throws BussinessLogicException,SecurityException;
}

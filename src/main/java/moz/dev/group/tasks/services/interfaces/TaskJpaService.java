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


/**
 *
 * @author delfi
 */
public interface TaskJpaService extends JpaService<Task, Long>
{
    Set<Task>findByState(TaskState state);
    Set<Task>findByDelegator(User delegator);
    Set<Task>findByDelegated(User delegator);
    Set<Task> findByStateAndDelegator(TaskState state,User delegator);
    Set<Task> findByStateAndDelegated(TaskState state,User delegator);
    boolean isValid(Task task);
}

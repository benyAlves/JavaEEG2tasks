/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.services.impl;

import java.util.List;
import javax.ejb.Singleton;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import moz.dev.group.tasks.model.TaskEvent;
import moz.dev.group.tasks.repositories.TaskEventRepository;
import moz.dev.group.tasks.services.exceptions.BussinessLogicException;
import moz.dev.group.tasks.services.exceptions.MissingTaskException;
import moz.dev.group.tasks.services.interfaces.TaskEventJpaService;
import moz.dev.group.tasks.services.interfaces.TaskJpaService;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delfi
 */
@Dependent
@Default
public class SimpleTaskEventService implements TaskEventJpaService
{
    @Inject
    @Default
    private TaskEventRepository repository;
    @Inject
    private TaskJpaService taskService;
    
        
    @Override
    public <S extends TaskEvent> S save(S entity)throws BussinessLogicException
    {
          if(taskService.isValid(entity.getAbstractTask()))
            return this.getRepository().save(entity);
        else
            throw new MissingTaskException();
    }
    
    public <S extends TaskEvent> List<S> save(Iterable<S> entities) throws Exception
    {
        throw new UnsupportedOperationException();
    }

    @Override
    public JpaRepository<TaskEvent, Long> getRepository()
    {
        return this.repository;
    }
    
}

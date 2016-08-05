/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.config;

import javax.ejb.Stateful;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import moz.dev.group.tasks.repositories.NoteRepository;
import moz.dev.group.tasks.repositories.TaskEventRepository;
import moz.dev.group.tasks.repositories.TaskRepository;
import moz.dev.group.tasks.repositories.UserRepository;
import org.springframework.data.jpa.repository.support.JpaRepositoryFactory;

/**
 *
 * @author delfi
 */
@ApplicationScoped
@Stateful
public class RepositoriesProducer
{
  @PersistenceContext
  private final EntityManager em;

  
  public RepositoriesProducer() 
  {
    this.em = null;
  }

  @Produces
  public EntityManager em() 
  {
    return em;
  }

  public void dispose(@Disposes EntityManager em) 
  {
    em.close();
  }
    
   @Produces
   @Default
   public JpaRepositoryFactory factory(EntityManager manager)
   {
        return new JpaRepositoryFactory(manager);
   }
    
    
   @Produces
   @Default 
    public NoteRepository noteRepo(JpaRepositoryFactory factory)
    {
        return factory.getRepository(NoteRepository.class);
    }
    
   @Produces
   @Default
    public TaskRepository taskRepo(JpaRepositoryFactory factory)
    {
        return factory.getRepository(TaskRepository.class);
    }
    
    @Produces
    @Default
    public TaskEventRepository eventRepo(JpaRepositoryFactory factory)
    {
        return factory.getRepository(TaskEventRepository.class);
    }
    
   @Produces
   @Default
    public UserRepository userRepo(JpaRepositoryFactory factory)
    {
        return factory.getRepository(UserRepository.class);
    }
 
}

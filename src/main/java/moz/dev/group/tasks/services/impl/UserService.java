/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.services.impl;

import java.util.Set;
import javax.enterprise.context.Dependent;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import moz.dev.group.tasks.model.User;
import moz.dev.group.tasks.repositories.UserRepository;
import moz.dev.group.tasks.services.interfaces.UserJpaService;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delfi
 */

@Dependent
@Default
public class UserService implements UserJpaService
{
    @Inject
    @Default
    private UserRepository repository;


    public UserService() 
    {
    }
    

    @Override
    public UserRepository getRepository() 
    {
        return this.repository;
    }
    
    @Override
    public Set<User>findByUsernameLike(String username)
    {
        return this.getRepository().findByUsernameLikeLower(username.toLowerCase());
    }
    
}

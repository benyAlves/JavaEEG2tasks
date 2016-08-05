/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.services.interfaces;

import java.util.Set;
import moz.dev.group.tasks.model.User;



/**
 *
 * @author delfi
 */
public interface UserJpaService extends JpaService<User,String>
{
    Set<User>findByUsernameLike(String name);
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.repositories;

import java.util.Set;
import moz.dev.group.tasks.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 *
 * @author delfi
 */
public interface UserRepository extends JpaRepository<User, String>
{
    @Query("select u from User u where lower(u.username) like %:name% or lower(u.name) like %:name%")
    public Set<User> findByUsernameLikeLower(@Param("name")String username);
}

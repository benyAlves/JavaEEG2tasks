/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.repositories;

import moz.dev.group.tasks.model.TaskEvent;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delfi
 */
public interface TaskEventRepository extends JpaRepository<TaskEvent, Long>
{
}

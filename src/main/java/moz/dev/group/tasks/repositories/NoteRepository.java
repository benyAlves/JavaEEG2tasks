/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.repositories;

import moz.dev.group.tasks.model.Note;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delfi
 */
public interface NoteRepository extends  JpaRepository<Note,Long>
{
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package moz.dev.group.tasks.services.interfaces;

import java.io.Serializable;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author delfi
 * @param <T>
 * @param <ID>
 */
@Transactional(Transactional.TxType.REQUIRED)
public interface JpaService<T,ID extends Serializable>
{
    default List<T> findAll()
    {
        return this.getRepository().findAll();
    }
    default List<T> findAll(Sort sort)
    {
        return this.getRepository().findAll(sort);
    }
    default List<T> findAll(Iterable<ID> ids)
    {
        return this.getRepository().findAll(ids);
    }
    default <S extends T> List<S> save(Iterable<S> entities) throws Exception
    {
        return this.getRepository().save(entities);
    }

    default void deleteInBatch(Iterable<T> entities) throws Exception
    {
        this.getRepository().deleteInBatch(entities);
    }
    
    default void deleteAllInBatch() throws Exception
    {
        this.getRepository().deleteAllInBatch();
    }
    default T getOne(ID id) 
    {
        return this.getRepository().getOne(id);
    }
    
    default <S extends T> List<S> findAll(Example<S> example) 
    {
        return this.getRepository().findAll(example);
    }
    
    default <S extends T> List<S> findAll(Example<S> example, Sort sort) 
    {
        return this.getRepository().findAll(example, sort);
    }
    
    default Page<T> findAll(Pageable pageable)
    {
        return this.getRepository().findAll(pageable);
    }
    
    default <S extends T> S findOne(Example<S> example)
    {
        return this.getRepository().findOne(example);
    }
    
    default <S extends T> Page<S> findAll(Example<S> example, Pageable pageable)
    {
        return this.getRepository().findAll(example, pageable);
    }
    default <S extends T> long count(Example<S> example)
    {
        return this.getRepository().count(example);
    }
    default <S extends T> boolean exists(Example<S> example)
    {
        return this.getRepository().exists(example);
    }
    default long count()
    {
        return this.getRepository().count();
    }
    
    @Transactional
    default<S extends T> S save(S entity)throws Exception
    {
        return this.getRepository().save(entity);
    }
    default T findOne(ID id)
    {
        return this.getRepository().findOne(id);
    }
    default boolean exists(ID id)
    {
        return this.getRepository().exists(id);
    }
    default void delete(ID id) throws Exception
    {
        this.getRepository().delete(id);
    }
    default void delete(T entity) throws Exception
    {
        this.getRepository().delete(entity);
    }
    default void delete(Iterable<? extends T> entities)throws Exception
    {
        this.getRepository().delete(entities);
    }
    default void deleteAll() throws Exception
    {
        this.getRepository().deleteAll();
    }
    JpaRepository<T, ID>getRepository();
}

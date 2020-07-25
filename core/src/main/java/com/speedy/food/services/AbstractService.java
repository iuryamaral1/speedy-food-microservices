package com.speedy.food.services;

import com.speedy.food.model.Entity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.PagingAndSortingRepository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Transactional(rollbackOn = Throwable.class)
public abstract class AbstractService<T extends Entity, RE extends PagingAndSortingRepository<T, Long>> {

    @Autowired
    private RE repository;

    public List<T> findAll() {
        Iterable<T> all = this.repository.findAll();
        return StreamSupport.stream(all.spliterator(), false)
                .collect(Collectors.toList());
    }

    public T findBydId(Long id) {
        return this.repository.findById(id).orElse(null);
    }

    public T create(T entity) {
        return this.repository.save(entity);
    }

    public T update(T entity) {
        return this.repository.save(entity);
    }

    public void updateAllInList(Iterable<T> iterable) {
        this.repository.saveAll(iterable);
    }

    public void deleteById(Long id) {
        this.repository.deleteById(id);
    }

    public void deleteAllInList(Iterable<T> iterable) {
        this.repository.deleteAll(iterable);
    }
}

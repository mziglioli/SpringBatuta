package com.batuta.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.batuta.model.JpaRepositoryClass;

import lombok.Getter;

public abstract class ServiceDefault<T extends JpaRepositoryClass, R extends JpaRepository<T, Long>> {

    @Autowired
    @Getter
    protected R repository;

    public T save(T entity) {
        beforeInsert();
        repository.save(entity);
        afterInsert();
        return entity;
    }

    public T update(T entity) {
        beforeUpdate();
        repository.save(entity);
        afterUpdate();
        return entity;
    }

    public void delete(T entity) {
        beforeDelete();
        repository.delete(entity);
        afterDelete();
    }

    public Collection<T> findAll() {
        return repository.findAll();
    }

    protected void afterInsert() {

    }

    protected void afterUpdate() {

    }

    protected void afterDelete() {

    }

    protected void beforeInsert() {

    }

    protected void beforeUpdate() {

    }

    protected void beforeDelete() {

    }

}

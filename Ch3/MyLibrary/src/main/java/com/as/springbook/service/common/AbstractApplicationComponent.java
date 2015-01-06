package com.as.springbook.service.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.as.springbook.domain.common.CommonActions;

@Transactional
public abstract class AbstractApplicationComponent<T extends Serializable> implements CommonActions<T> {

    @Override
    public T findOne(final long id) {
        return getCommonDao().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getCommonDao().findAll();
    }

    @Override
    public void create(final T entity) {
        getCommonDao().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getCommonDao().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getCommonDao().delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        getCommonDao().deleteById(entityId);
    }

    protected abstract CommonActions<T> getCommonDao();

}

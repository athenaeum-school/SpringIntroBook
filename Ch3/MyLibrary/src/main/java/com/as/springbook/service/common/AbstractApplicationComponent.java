/**
 * All Rigths Reserved by Athenaeum Society
 * 2015-
 * Written by Masaki Komatsu
 */

package com.as.springbook.service.common;

import java.io.Serializable;
import java.util.List;

import org.springframework.transaction.annotation.Transactional;

import com.as.springbook.domain.common.CommonActions;

@Transactional
public abstract class AbstractApplicationComponent<T extends Serializable> implements CommonActions<T> {

    @Override
    public T findOne(final long id) {
        return getCommonRepository().findOne(id);
    }

    @Override
    public List<T> findAll() {
        return getCommonRepository().findAll();
    }

    @Override
    public void create(final T entity) {
        getCommonRepository().create(entity);
    }

    @Override
    public T update(final T entity) {
        return getCommonRepository().update(entity);
    }

    @Override
    public void delete(final T entity) {
        getCommonRepository().delete(entity);
    }

    @Override
    public void deleteById(final long entityId) {
        getCommonRepository().deleteById(entityId);
    }

    protected abstract CommonActions<T> getCommonRepository();

}

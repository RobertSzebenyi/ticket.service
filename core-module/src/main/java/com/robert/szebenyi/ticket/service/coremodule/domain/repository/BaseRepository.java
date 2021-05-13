package com.robert.szebenyi.ticket.service.coremodule.domain.repository;

import com.querydsl.core.types.dsl.EntityPathBase;
import com.querydsl.jpa.impl.JPADeleteClause;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAUpdateClause;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;

@NoRepositoryBean
public class BaseRepository<Domain> {

    @Autowired
    private EntityManager entityManager;

    protected JPAQuery<Domain> jpaQuery() {
        return new JPAQuery<Domain>(entityManager);
    }

    protected JPADeleteClause jpaDeleteClause(EntityPathBase path) {
        return new JPADeleteClause(entityManager, path);
    }

    protected JPAUpdateClause jpaUpdateClause(EntityPathBase path) {
        return new JPAUpdateClause(entityManager, path);
    }
}

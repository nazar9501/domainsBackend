package com.domains.springapp.dao;

import javax.transaction.Transactional;

import org.springframework.data.repository.CrudRepository;

import com.domains.springapp.model.Domain;

@Transactional
public interface DomainDao extends CrudRepository<Domain, Long> {

}
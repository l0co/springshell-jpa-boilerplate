package com.lifeinide.boilerplate.springshell.repository;

import com.lifeinide.boilerplate.springshell.domain.AbstractEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

/**
 * @author Lukasz Frankowski
 */
@NoRepositoryBean
@Transactional
public interface AbstractRepository<T extends AbstractEntity> extends CrudRepository<T, UUID> {
}

package ch.migrosonline.momentum.repository;

import ch.migrosonline.momentum.repository.model.BlogEntity;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends CrudRepository<BlogEntity, Long> {

}

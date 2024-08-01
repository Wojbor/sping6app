package amaciag.springframework.spring6webapp.repositories;

import amaciag.springframework.spring6webapp.domain.Author;
import org.springframework.data.repository.CrudRepository;


public interface AuthorRepository extends CrudRepository<Author, Long> {
}

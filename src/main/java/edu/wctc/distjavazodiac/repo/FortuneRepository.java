package edu.wctc.distjavazodiac.repo;

import edu.wctc.distjavazodiac.entity.Fortune;
import org.springframework.data.repository.CrudRepository;

// gives access to the built in crud functionality of the spring framework
public interface FortuneRepository extends CrudRepository<Fortune, Integer> {
}

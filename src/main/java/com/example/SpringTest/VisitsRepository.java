package com.example.SpringTest;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by PStroganov on 20.02.2018.
 */

@Repository
public interface VisitsRepository extends CrudRepository<Visit, Long> {

}

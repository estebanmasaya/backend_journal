package com.kth.estmm.backend_journal.Persistence;

import com.kth.estmm.backend_journal.BO.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Long> {

}

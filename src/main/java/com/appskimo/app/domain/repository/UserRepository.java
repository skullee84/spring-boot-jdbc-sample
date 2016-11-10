package com.appskimo.app.domain.repository;

import com.appskimo.app.domain.model.User;
import org.springframework.stereotype.Repository;

/**
 * Created by dominic on 2016. 9. 23..
 */
@Repository
public interface UserRepository {

    void insert(User user);

}

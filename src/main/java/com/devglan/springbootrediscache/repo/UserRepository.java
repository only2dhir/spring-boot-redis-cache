package com.devglan.springbootrediscache.repo;

import com.devglan.springbootrediscache.model.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<String, User> {
}

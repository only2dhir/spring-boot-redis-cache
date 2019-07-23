package com.devglan.springbootrediscache.repo;

import com.devglan.springbootrediscache.model.User;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RedisUserRepository {

    private HashOperations hashOperations;

    private RedisTemplate redisTemplate;

    public RedisUserRepository(RedisTemplate redisTemplate){
        this.redisTemplate = redisTemplate;
        this.hashOperations = this.redisTemplate.opsForHash();
    }

    public void save(User user){
        hashOperations.put("USER", user.getId(), user);
    }
    public List<User> findAll(){
        return hashOperations.values("USER");
    }

    public User findById(String id){
        return (User) hashOperations.get("USER", id);
    }

    public void update(User user){
        save(user);
    }

    public void delete(String id){
        hashOperations.delete("USER", id);
    }

    public void multiGetUsers(List<String> userIds){
        hashOperations.multiGet("USER", userIds);
    }

}

package com.example.onlineeduplatformuser.repository;

import com.example.onlineeduplatformuser.dto.UserLoginResponse;
import com.example.onlineeduplatformuser.model.User;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Component;

import reactor.core.publisher.Mono;

@Component
public interface UserRepository extends ReactiveCrudRepository<User, Long> {
    @Query("SELECT userId, userType FROM USER WHERE userId=?1 and  password=?2")
    Mono<UserLoginResponse> findByUserIdAndPassWord(int id, String password);
}

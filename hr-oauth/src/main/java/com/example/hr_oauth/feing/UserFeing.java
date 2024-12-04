package com.example.hr_oauth.feing;

import com.example.hr_oauth.entities.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "hr-user", path = "/users")
public interface UserFeing {

    @GetMapping(value = "/search")
    ResponseEntity<User> findByEmail(@RequestParam String email);

}

package com.example.onlineeduplatformuser;

import com.example.onlineeduplatformuser.model.User;
import com.example.onlineeduplatformuser.repository.UserRepository;
import org.h2.util.json.JSONObject;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.net.http.HttpHeaders;

@SpringBootTest
class OnlineEduPlatformUserApplicationTests {

    @Test
    void contextLoads() {

    }


}

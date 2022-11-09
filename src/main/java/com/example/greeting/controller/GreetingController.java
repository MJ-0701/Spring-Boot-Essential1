package com.example.greeting.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.atomic.AtomicLong;

@RestController
public class GreetingController {

    private static AtomicLong counter = new AtomicLong(); // api 가 호출될때 마다 카운터를 증가시키기 위한 메서드

    @GetMapping("/greeting")
    public Greeting greeting() {
        return new Greeting(counter.incrementAndGet(), "Hello World");
    }

    @Getter
    @Setter
    public static class Greeting{
        private final Long id;
        private final String content;

        public Greeting(Long id, String content) {
            this.id = id;
            this.content = content;
        }




    }
}

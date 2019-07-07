package com.example.demo;

import com.sun.org.apache.xpath.internal.operations.Bool;
import com.sun.tools.internal.ws.processor.model.Response;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@SpringBootApplication
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}

@RestController
@RequestMapping("/api")
class Controller {

    private Boolean isAlive = true;

    @GetMapping
    public Mono<String> get() {
        return Mono.just("hello v5");
    }

    @GetMapping("/healthCheck")
    public Mono<ResponseEntity> healthCheck() {
        if (isAlive)
            return Mono.just(ResponseEntity.ok().build());
        return Mono.just(ResponseEntity.status(500).build());
    }

    @GetMapping("/kill")
    public Mono<ResponseEntity> kill() {
        isAlive = false;
        return Mono.just(ResponseEntity.ok().build());
    }
}

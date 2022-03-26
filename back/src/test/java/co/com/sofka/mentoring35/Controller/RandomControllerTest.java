package co.com.sofka.mentoring35.Controller;

import co.com.sofka.mentoring35.Dto.RequestDTO;
import co.com.sofka.mentoring35.Model.Random;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RandomControllerTest {

    @Autowired
    RandomController controller;

    @Test
    void testRandomTime() {

        Mono<Random> list = controller.post(new RequestDTO("5"));

        StepVerifier.create(list)
                .expectNextMatches(
                        element -> {
                            if(element.getOrginalList().equals("5") &&
                                    element.getDate().toString().equals((new Date().toString()))){
                                return true;
                            }
                            return false;
                        }
                ).verifyComplete();
    }

}
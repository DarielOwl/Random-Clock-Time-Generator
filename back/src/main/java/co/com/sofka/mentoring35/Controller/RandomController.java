package co.com.sofka.mentoring35.Controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import co.com.sofka.mentoring35.Model.Random;
import co.com.sofka.mentoring35.Repository.RandomRepository;
import co.com.sofka.mentoring35.Dto.RequestDTO;
import co.com.sofka.mentoring35.Services.RandomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/r")
public class RandomController {

    private RandomRepository randomRepository;
    private RandomService randomService = new RandomService();

    @Autowired
    public RandomController(RandomRepository randomRepository) {
        this.randomRepository = randomRepository;
    }

    @PostMapping("")
    public Mono<Random> post(@RequestBody RequestDTO request) {
        return Mono.just(new Random()).map(entity -> {
            entity.setDate(new Date());
            entity.setOrginalList(request.getList());
            return entity;
        }).map(entity -> {

            var randomList = (IntStream.range(1,Integer.parseInt(request.getList())+1)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(",")));

            var randomTime = Arrays.stream(randomList.split(","))
                    .map(t -> {
                       var randomTimeEntity = randomService.getRandomTime();
                       return t = randomTimeEntity;
                    }).collect(Collectors.joining(" - "));

            entity.setRandomList(randomTime);
            return entity;
        }).flatMap(randomRepository::save);
    }

     /*entity.setOrginalList(IntStream.range(1,Integer.parseInt(request.getList()))
                       .mapToObj(String::valueOf)
                        .collect(Collectors.joining(",")));
        */



   /* @PostMapping("")
    public Mono<Random> post(@RequestBody RequestDTO request) {
        return Mono.just(new Random()).map(entity -> {
            entity.setDate(new Date());
            entity.setOrginalList(request.getList());
            return entity;
        }).map(entity -> {
            var list = Stream.of(request.getList().split(","))
                .map(p -> p.trim())
                .collect(Collectors.toList());
            Collections.shuffle(list);
            var randomList = list.stream().collect(Collectors.joining(","));
            entity.setRandomList(randomList);
            return entity;
        }).flatMap(randomRepository::save);
    }*/

    @GetMapping("")
    public Flux<Random> get() {
        return randomRepository.findAll();
    }
}

package com.example.week1;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.junit.Test;
import org.junit.jupiter.api.DisplayName;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.core.scheduler.Scheduler;
import reactor.core.scheduler.Schedulers;
import reactor.test.StepVerifier;
import reactor.util.function.Tuple2;

import java.time.Duration;
import java.util.*;

public class HwTest {

    @DisplayName("1. [Blenders, Old, Johnnie] 와 [Pride, Monk,b Walker]를 순서대로 하나의 스트림으로 처리하는")
    @Test
    public void testMakeOneStream(){
        // 순서보장하기 위해 delayElements
        Flux<String> flux1 = Flux.just("Blenders", "Old", "Johnnie")
                .delayElements(Duration.ofSeconds(1));
        Flux<String> flux2 = Flux.just("Pride", "Monk", "Walker")
                .delayElements(Duration.ofSeconds(1));

        // [flux1, flux2] 로 합침
        Flux<String> result = Flux.concat(flux1,flux2).log();

        StepVerifier.create(result)
                // onSubscribe 찍히는지 검증
                .expectSubscription()
                .expectNext("Blenders","Old", "Johnnie", "Pride", "Monk", "Walker")
                .verifyComplete();


    }

    @DisplayName("2. 1~100 까지의 자연수 중 짝수만 출력하는 로직 검증")
    @Test
    public void testEvenNumber(){
        // Integer List 1~100까지 생성
        List<Integer> intList = new ArrayList<>();
        for (int i=1; i<=100; i++) {
            intList.add(i);
        }

        // list를 만들고, filter 짝수만 걸리도록 적용
        Flux<Integer> result = Flux.fromIterable(intList)
                                .filter(x -> x%2==0)
                                .log();

        StepVerifier.create(result)
                .expectSubscription()
                // 100 / 2 = 50 개
                .expectNextCount(50)
                // filter를 못미더워서 한번더 안전장치 만든 것
                .thenConsumeWhile(i->i%2==0)
                .verifyComplete();

    }

    @DisplayName("3. hello, there 를 순차적으로 publish하여 순서대로 나오는지 검증")
    @Test
    public void testOrderWord(){
        Mono<String> head = Mono.just("hello").log();
        Mono<String> tail = Mono.just("there").log();

        Flux<String> result = Flux.concat(head,tail).log();

        StepVerifier.create(result)
                .expectSubscription()
                .expectNext("hello")
                .expectNext("there")
                .verifyComplete();
    }

    @DisplayName("4. 아래와 같은 객체가 전달될때 JOHN, JACK 등 이름이 대문자로 변환되어 출력되는 로직 검증" +
            "\nPerson(John, john@gmail, 1234567" +
            "\nPerson(Jack, john@gmail, 1234567")
    @Test
    public void testObjecttoUpperCase(){

        @AllArgsConstructor
        class Person{
            String name;
            String email;
            String phone;

            public String getUpperCaseName() {
                return name.toUpperCase();
            }
        }

        Mono<Person> john = Mono.just(new Person("john", "john@gmail.com", "12345678")).log();
        Mono<Person> jack = Mono.just(new Person("jackson", "jackson@gmail.com", "12345678")).log();

        Flux<String> result = Flux.concat(john,jack)
                .map(person -> person.getUpperCaseName())
                .log();

        StepVerifier.create(result)
                .expectNext("JOHN")
                .expectNext("JACKSON")
                .verifyComplete();
    }

    @DisplayName("5. [Blenders, Old, Johnnie] 와 [Pride, Monk,b Walker]를 압축하여 스트림으로 처리 검증" +
            "\n 예상되는 결과값 [Blenders Pride, Old Monk, Johnnie walker]")
    @Test
    public void testZipStream(){
        Flux<String> flux1 = Flux.just("Blenders", "Old", "Johnnie");
        Flux<String> flux2 = Flux.just("Pride", "Monk", "Walker");

        Flux<String> result = Flux.zip(flux1,flux2,(x,y) -> x + " " + y).log();

        StepVerifier.create(result)
                .expectNext("Blenders Pride")
                .expectNext("Old Monk")
                .expectNext("Johnnie Walker")
                .verifyComplete();

    }

    @DisplayName("7. [google, abc, fb, stackoverflow]의 문자열중 5자 이상 되는 문자열만 대문자로 비동기로 치환하여 2번 쓰도록" +
            "\n [GOOGLE, STACKOVERFLOW, GOOGLE, STACKOVERFLOW]" )
    @Test
    public void test5CharacterTobeUpperCase(){

        // 처음에 비동기 모르고 짰었던 코드
        Flux<String> result = Flux.just("google", "abc", "fb", "stackoverflow")
                .filter(x-> x.length() >= 5)
                .map(x-> x.toUpperCase())
                .subscribeOn(Schedulers.boundedElastic())
                .repeat(1)
                .log();

        // 비동기 인식하고 나서 짜게 된 코드
        Flux<String> result2 = Flux.just("google", "abc", "fb", "stackoverflow")
                .filter(x-> x.length() >= 5)
                // 스레드
                .flatMap(x-> Flux.just(x.toUpperCase()))
                .subscribeOn(Schedulers.boundedElastic())
                .repeat(1)
                .log();


        StepVerifier.create(result)
                .expectNext("GOOGLE")
                .expectNext("STACKOVERFLOW")
                .expectNext("GOOGLE")
                .expectNext("STACKOVERFLOW")
                .verifyComplete();
    }

}

package com.appskimo.app;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Created by dominic on 2017-02-13.
 */
public class DummyTest {

    private static final int RANDOM_POOL = 10000000;
    private final Random random = new Random();

    private boolean gacha(double probability) {
        double pivot = probability * RANDOM_POOL;
        return random.nextInt(RANDOM_POOL) < pivot;
    }

    @Before
    public void before() {
        Assert.assertNotNull(random);
    }

    @Test
    public void test() {
        double probability = 0.1;

        IntStream.range(0, 10).forEach(idx -> {
            Map<Boolean, Long> collect = IntStream.range(0, 100000)
                .boxed()
                .map(it -> gacha(probability))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

            System.out.println(collect);
        });
    }

    @Test
    public void test1() {
        IntStream.range(0, 1000).forEach(it -> {
            if(gacha(0.01)) {
                System.out.println(it);
            }
        });
    }

    @Test
    public void test2() {
        List<String> list = new LinkedList<>();
        IntStream.range(0, 1000).forEach(idx -> {
            double d = Math.random();
            int temp =  (int) (d * 100);
            System.out.println(temp);
        });

        Map<String, Long> collect = list.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collect);
    }

}

package com.tw.homework;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.ImmutableList;

import java.util.List;

import static com.google.common.collect.FluentIterable.from;
import static com.google.common.collect.Iterables.tryFind;

/**
 * Created with IntelliJ IDEA.
 * User: 1989jpj
 * Date: 13-12-10
 * Time: 下午8:05
 * To change this template use File | Settings | File Templates.
 */
public class MyGuava {

    ImmutableList<Integer> list = ImmutableList.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

    public List<Integer> getOdds() {
        return from(list)
                .filter(getOdd())
                .toList();
    }

    private Predicate<Integer> getOdd() {
        return new Predicate<Integer>() {
            @Override
            public boolean apply(Integer integer) {
                return integer % 2 == 1;
            }
        };
    }

    public boolean isOdd(int input) {
        return input % 2 != 0;
    }

    public List<Integer> doubleOfEvents() {
        return from(list).transform(doubleEvens()).toList();
    }

    private Function<Integer, Integer> doubleEvens() {
        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer integer) {
                return integer % 2 == 0 ? integer * 2 : integer;
            }
        };
    }

    public String contains(final int number) {
        return tryFind(list, equalsSpesificNumber(number))
                .transform(toHelloResult())
                .or("Not found");
    }

    private Function<Integer, String> toHelloResult() {
        return new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) {
                return "Hello," + integer;
            }
        };
    }

    private Predicate<Integer> equalsSpesificNumber(final int number) {
        return new Predicate<Integer>() {
            @Override
            public boolean apply(Integer integer) {
                return integer == number;
            }
        };
    }

    public void printList(ImmutableList list) {
        if (list != null) {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i));
            }
        }
    }
}

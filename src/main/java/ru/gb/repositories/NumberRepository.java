package ru.gb.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberRepository implements IRepository{
    private List<Number> numbers = new ArrayList<>();
    private Random random = new Random();
    private final int SIZE_LIST = 5;

    public NumberRepository() {
    }

    @Override
    public List<Number> getNumbers() {
        List<Number> list_numbers = new ArrayList<>();
        for (int i = 0; i < SIZE_LIST; i++) {
            list_numbers.add(random.nextInt(1,10));
        }
        this.numbers = list_numbers;
        return numbers;
    }
}

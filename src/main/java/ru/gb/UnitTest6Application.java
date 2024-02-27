package ru.gb;

import ru.gb.model.App;
import ru.gb.model.Calculation;
import ru.gb.repositories.NumberRepository;
import ru.gb.services.NumberService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UnitTest6Application {
    public static void main(String[] args) {
        System.out.println("Подсчет среднего значения списка чисел");
        NumberRepository numberRepository = new NumberRepository();
        NumberService numberService = new NumberService(numberRepository);
        List<Number> numbers1 = numberService.getNumbers();
        List<Number> numbers2 = numberService.getNumbers();
        Calculation calculation = new Calculation();
        double result1 = calculation.getAverage(numbers1);
        double result2 = calculation.getAverage(numbers2);
        String message = calculation.compareDouble(result1, result2);
        System.out.println(message);
    }
}

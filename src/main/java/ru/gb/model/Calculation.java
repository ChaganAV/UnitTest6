package ru.gb.model;

import java.util.ArrayList;
import java.util.List;

public class Calculation {
    private final String MESSAGE1 = "Первый список имеет большее среднее значение, если среднее значение первого списка больше";
    private final String MESSAGE2 = "Второй список имеет большее среднее значение, если среднее значение второго списка больше";
    private final String MESSAGE_EQUALLY = "Средние значения равны, если средние значения списков равны";

    public Calculation() {
    }
    public double getAverage(List<Number> numbers){
        int sum = 0;
        int count = 0;
        for (Number num: numbers) {
            sum+= (int)num;
            count++;
        }
        return (double) sum/count;
    }

    public String compareDouble(double num1, double num2){
        Double number1 = num1;
        int res = number1.compareTo(num2);
        if(res>0){
            return MESSAGE1;
        }else if(res<0){
            return MESSAGE2;
        }else{
            return MESSAGE_EQUALLY;
        }
    }
}

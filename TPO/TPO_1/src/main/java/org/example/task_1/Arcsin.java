package org.example.task_1;


import lombok.SneakyThrows;

public class Arcsin {
    public Arcsin() {
    }

    @SneakyThrows
    public double toPowerSeries(double x){

        if(!(Math.abs(x) < 1))
            return Double.NaN;

        int n = 10;

        double result = 0;
        for (int i = 0; i < n; i++) {
            result += ((factorial(2 * i)) / (Math.pow(2, 2 * i) * Math.pow(factorial(i), 2)))
                    * ((Math.pow(x, 2 * i + 1)) / (2 * i + 1));
        }

        return result;
    }


    public int factorial(int number){
        int result = 1;
        for(int i = number; i > 0; i--){
            result *= i;
        }
        return result;
    }

}

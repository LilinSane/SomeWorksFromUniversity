package org.example.trigonometric;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.interfaces.Function;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;

@NoArgsConstructor
public class Sin implements Function {

    @Override
    public double calc(double x, double eps) {
        // Нормализация угла x
        x %= Math.PI * 2;
        if (Double.isInfinite(x) || Double.isNaN(x)) {
            return Double.NaN;
        }
        while (x < -Math.PI) x += 2 * Math.PI;
        while (x > Math.PI) x -= 2 * Math.PI;

        double sum = x;
        double term = x;

        for (int n = 1; Math.abs(term) > eps; n++) {
            term = Math.pow(-1, n) * Math.pow(x, 2 * n + 1) / factorial(2 * n + 1);
            sum += term;
        }
        return sum;
    }

    private int factorial(int number){
        int result = 1;
        for(int i = number; i > 0; i--){
            result *= i;
        }
        return result;
    }

    @SneakyThrows
    public void writeResultToCSV(double eps, String fileName, double from, double to, double step) {
        File file = new File(fileName);
        final PrintWriter printer = new PrintWriter(file);
        for (BigDecimal i = BigDecimal.valueOf(from); i.compareTo(BigDecimal.valueOf(to)) <= 0; i = i.add(BigDecimal.valueOf(step))){
            printer.println(i + "," + calc(i.doubleValue(), eps));
        }
        printer.close();
    }
}

package org.example.logarithmic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.interfaces.Function;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;

@NoArgsConstructor
public class Ln implements Function {

    @Override
    public double calc(double x, double eps) {
        if (Double.isInfinite(x) || Double.isNaN(x) || x <= 0) {
            return Double.NaN;
        }
        if(x == 1){return 0;}

        double constant = ((x - 1) * (x - 1)) / ((x + 1) * (x + 1));

        double term = (x - 1) / (x + 1);
        double sum = 0;

        for(int i = 1; Math.abs(term) > eps / 4; i++){
            sum += term;
            term = (2 * i - 1) * term * constant / (2 * i + 1);
        }
        return 2 * sum;
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

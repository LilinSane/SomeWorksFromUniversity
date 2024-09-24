package org.example.logarithmic;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
public class Log {

    Ln ln = new Ln();

    public double calc(double a, double x, double eps) {
        return ln.calc(x, eps) / ln.calc(a, eps);
    }

    @SneakyThrows
    public void writeResultToCSV(double a, double eps, String fileName, double from, double to, double step) {
        File file = new File(fileName);
        final PrintWriter printer = new PrintWriter(file);
        for (BigDecimal i = BigDecimal.valueOf(from); i.compareTo(BigDecimal.valueOf(to)) <= 0; i = i.add(BigDecimal.valueOf(step))){
            printer.println(i + "," + calc(a, i.doubleValue(), eps));
        }
        printer.close();
    }
}

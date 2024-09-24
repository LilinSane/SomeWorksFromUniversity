package org.example.trigonometric;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.interfaces.Function;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
public class Cos implements Function {

    Sin sin = new Sin();
    @Override
    public double calc(double x, double eps) {
        if (x > Math.PI / 2 || x < -Math.PI / 2) {
            return -1 * Math.sqrt(1 - sin.calc(x, eps) * sin.calc(x, eps));
        }
        return Math.sqrt(1 - sin.calc(x, eps) * sin.calc(x, eps));
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

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
public class Tan implements Function {

    Cos cos = new Cos();
    Sin sin = new Sin();

    @Override
    public double calc(double x, double eps) {
        return sin.calc(x, eps)/cos.calc(x, eps);
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

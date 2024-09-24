package org.example;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.SneakyThrows;
import org.example.interfaces.Function;
import org.example.logarithmic.Ln;
import org.example.logarithmic.Log;
import org.example.trigonometric.*;

import java.io.File;
import java.io.PrintWriter;
import java.math.BigDecimal;

@NoArgsConstructor
@AllArgsConstructor
public class SystemSolver implements Function {

    Cos cos = new Cos();
    Tan tan = new Tan();
    Sin sin = new Sin();
    Cot cot = new Cot();
    Sec sec = new Sec();
    Csc csc = new Csc();
    Log log = new Log();
    Ln ln = new Ln();
    @Override
    public double calc(double x, double eps) {
        if(x <= 0)  return (((((tan.calc(x, eps) / cos.calc(x, eps)) * tan.calc(x, eps)) / csc.calc(x, eps)) + Math.pow((cot.calc(x, eps) - sec.calc(x, eps)), 3) + sec.calc(x, eps))) * ((sin.calc(x, eps) + cot.calc(x, eps)) - sec.calc(x, eps));

        return (((((log.calc(3, x, eps) - log.calc(10, x, eps)) / ln.calc(x, eps)) + log.calc(3, x, eps)) + log.calc(5, x, eps)) + log.calc(5, x, eps));
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

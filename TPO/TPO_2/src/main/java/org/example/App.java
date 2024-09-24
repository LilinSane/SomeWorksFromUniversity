package org.example;

import org.example.logarithmic.Ln;
import org.example.logarithmic.Log;
import org.example.trigonometric.*;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        double eps = 0.001;
        Cos cos = new Cos();
        Tan tan = new Tan();
        Sin sin = new Sin();
        Cot cot = new Cot();
        Sec sec = new Sec();
        Csc csc = new Csc();
        Log log = new Log();
        Ln ln = new Ln();
        SystemSolver systemSolver = new SystemSolver();

        cos.writeResultToCSV(eps, "src/main/resources/input/cos.csv", -2, 2, 0.01);
        tan.writeResultToCSV(eps, "src/main/resources/input/tan.csv", -2, 2, 0.01);
        sin.writeResultToCSV(eps, "src/main/resources/input/sin.csv", -2, 2, 0.01);
        cot.writeResultToCSV(eps, "src/main/resources/input/cot.csv", -2, 2, 0.01);
        sec.writeResultToCSV(eps, "src/main/resources/input/sec.csv", -2, 2, 0.01);
        csc.writeResultToCSV(eps, "src/main/resources/input/csc.csv", -2, 2, 0.01);
        log.writeResultToCSV(10, eps, "src/main/resources/input/log10.csv", -2, 2, 0.01);
        log.writeResultToCSV(3, eps, "src/main/resources/input/log3.csv", -2, 2, 0.01);
        log.writeResultToCSV(5, eps, "src/main/resources/input/log5.csv", -2, 2, 0.01);
        ln.writeResultToCSV(eps, "src/main/resources/input/ln.csv", -2, 2, 0.01);
        systemSolver.writeResultToCSV(eps, "src/main/resources/input/sys.csv", -2, 2, 0.01);
        //sec.writeResultToCSV(x, eps, "sec.csv");
        //csc.writeResultToCSV(x, eps, "csc.csv");
        //log.writeResultToCSV(x, eps, "log.csv");
        //ln.writeResultToCSV(x, eps, "ln.csv");
    }
}

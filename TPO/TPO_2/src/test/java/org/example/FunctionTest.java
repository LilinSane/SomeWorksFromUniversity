package org.example;

import lombok.SneakyThrows;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVRecord;
import org.example.logarithmic.Ln;
import org.example.logarithmic.Log;
import org.example.trigonometric.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.mockito.Mockito;

import java.io.FileReader;
import java.io.Reader;


public class FunctionTest {
    static double eps = 0.001;

    static Cos cosMock;
    static Tan tanMock;
    static Sin sinMock;
    static Cot cotMock;
    static Sec secMock;
    static Csc cscMock;
    static Log logMock;
    static Ln lnMock;

    static Reader secIn;
    static Reader cosIn;
    static Reader sinIn;
    static Reader cscIn;
    static Reader tanIn;
    static Reader cotIn;
    static Reader log10In;
    static Reader log3In;
    static Reader log5In;
    static Reader lnIn;

    @BeforeAll
    @SneakyThrows
    static void init(){
        sinMock = Mockito.mock(Sin.class);
        cosMock = Mockito.mock(Cos.class);
        secMock = Mockito.mock(Sec.class);
        tanMock = Mockito.mock(Tan.class);
        cotMock = Mockito.mock(Cot.class);
        cscMock = Mockito.mock(Csc.class);
        logMock = Mockito.mock(Log.class);
        lnMock = Mockito.mock(Ln.class);

        sinIn = new FileReader("src/main/resources/input/sin.csv");
        cosIn = new FileReader("src/main/resources/input/cos.csv");
        secIn = new FileReader("src/main/resources/input/sec.csv");
        tanIn = new FileReader("src/main/resources/input/tan.csv");
        cotIn = new FileReader("src/main/resources/input/cot.csv");
        cscIn = new FileReader("src/main/resources/input/csc.csv");
        log10In = new FileReader("src/main/resources/input/log10.csv");
        log3In = new FileReader("src/main/resources/input/log3.csv");
        log5In = new FileReader("src/main/resources/input/log5.csv");
        lnIn = new FileReader("src/main/resources/input/ln.csv");

        Iterable<CSVRecord> records = CSVFormat.DEFAULT.parse(sinIn);
        for (CSVRecord record : records) {
            Mockito.when(sinMock.calc(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(cosIn);
        for (CSVRecord record : records) {
            Mockito.when(cosMock.calc(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(secIn);
        for (CSVRecord record : records) {
            Mockito.when(secMock.calc(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(tanIn);
        for (CSVRecord record : records) {
            Mockito.when(tanMock.calc(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(cotIn);
        for (CSVRecord record : records) {
            Mockito.when(cotMock.calc(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(cscIn);
        for (CSVRecord record : records) {
            Mockito.when(cscMock.calc(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(lnIn);
        for (CSVRecord record : records) {
            Mockito.when(lnMock.calc(Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(log10In);
        for (CSVRecord record : records) {
            Mockito.when(logMock.calc(10, Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(log3In);
        for (CSVRecord record : records) {
            Mockito.when(logMock.calc(3, Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }

        records = CSVFormat.DEFAULT.parse(log5In);
        for (CSVRecord record : records) {
            Mockito.when(logMock.calc(5, Double.parseDouble(record.get(0)), eps)).thenReturn(Double.valueOf(record.get(1)));
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/sys.csv")
    void testWithLnMock(double value, double expected) {
        SystemSolver function = new SystemSolver(cosMock, tanMock, sinMock, cotMock, secMock, cscMock, logMock, lnMock);
        Assertions.assertEquals(expected, function.calc(value, eps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/sys.csv")
    void testWithLogMock(double value, double expected) {
        SystemSolver function = new SystemSolver(cosMock, tanMock, sinMock, cotMock, secMock, cscMock, logMock, new Ln());
        Assertions.assertEquals(expected, function.calc(value, eps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/sys.csv")
    void testWithCscMock(double value, double expected) {
        SystemSolver function = new SystemSolver(cosMock, tanMock, sinMock, cotMock, secMock, cscMock, new Log(), new Ln());
        Assertions.assertEquals(expected, function.calc(value, eps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/sys.csv")
    void testWithSecMock(double value, double expected) {
        SystemSolver function = new SystemSolver(cosMock, tanMock, sinMock, cotMock, secMock, new Csc(sinMock), new Log(), new Ln());
        Assertions.assertEquals(expected, function.calc(value, eps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/sys.csv")
    void testWithTanMock(double value, double expected) {
        SystemSolver function = new SystemSolver(cosMock, tanMock, sinMock, cotMock, new Sec(), new Csc(sinMock), new Log(), new Ln());
        Assertions.assertEquals(expected, function.calc(value, eps), eps);
    }


    @ParameterizedTest
    @CsvFileSource(resources = "/input/sys.csv")
    void testWithCotMock(double value, double expected) {
        SystemSolver function = new SystemSolver(cosMock, new Tan(cosMock, sinMock), sinMock, cotMock, new Sec(), new Csc(sinMock), new Log(), new Ln());
        Assertions.assertEquals(expected, function.calc(value, eps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/sys.csv")
    void testWithCosMock(double value, double expected) {
        SystemSolver function = new SystemSolver(cosMock, new Tan(cosMock, sinMock), sinMock, new Cot(cosMock, sinMock), new Sec(), new Csc(sinMock), new Log(), new Ln());
        Assertions.assertEquals(expected, function.calc(value, eps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/sys.csv")
    void testWithSinMock(double value, double expected) {
        SystemSolver function = new SystemSolver(new Cos(sinMock), new Tan(new Cos(sinMock), sinMock), sinMock, new Cot(new Cos(sinMock), sinMock), new Sec(), new Csc(sinMock), new Log(), new Ln());
        Assertions.assertEquals(expected, function.calc(value, eps), eps);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/input/sys.csv")
    void test(double value, double expected) {
        SystemSolver function = new SystemSolver();
        Assertions.assertEquals(expected, function.calc(value, eps), eps);
    }
}

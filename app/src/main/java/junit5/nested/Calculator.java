package junit5.nested;

public class Calculator {
    public double sum(int num1, int num2) {
        return num1 + num2;
    }

    public double sub(double num1, double num2) {
        return num1 - num2;
    }

    public double mul(int num1, int num2) {
        long r = (long) num1 * (long) num2;
        if ((int) r != r) {
            throw new RuntimeException("int의 범위를 벗어남");
        }
        return (int) r;
    }

    public double div(int num1, int num2) {
        if (num2 == 0) {
            throw new RuntimeException("0으로 나눌수 없음");
        }
        return num1 / num2;
    }
}

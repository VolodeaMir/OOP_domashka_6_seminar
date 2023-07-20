public class Main {
    public static void main(String[] args) {
        System.out.println();
        Calculator<Integer> intCalculator = new Calculator<>(); // Работа с целыми числами типа данных Integer
        System.out.println("Addition: " + intCalculator.sum(10, 5)); // Сложение
        System.out.println("Multiplication: " + intCalculator.multiply(10, 5)); // Умножение
        System.out.println("Division: " + intCalculator.divide(10, 5)); // Деление
        System.out.println("Binary conversion: " + intCalculator.toBinary(10)); // Бинарный перевод

        System.out.println();

        Calculator<Double> doubleCalculator = new Calculator<>(); // Работа с числами с плаваюшей точкой (запятой) типа даных Double
        System.out.println("Addition: " + doubleCalculator.sum(10.5, 5.3)); // Сложение
        System.out.println("Multiplication: " + doubleCalculator.multiply(10.5, 5.3)); // Умножение
        System.out.println("Division: " + doubleCalculator.divide(10.5, 5.3)); // Деление
        System.out.println("Binary conversion: " + doubleCalculator.toBinary(10.5)); // Бинарный перевод
    }
}

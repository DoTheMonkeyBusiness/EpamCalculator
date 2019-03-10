package com.example.epamcalculator;

class Math {
    private Math() {
    }

    static String sum(double firstValue, double secondValue) {
        return String.valueOf(firstValue + secondValue);
    }

    static String subtraction(double firstValue, double secondValue) {
        return String.valueOf(firstValue - secondValue);
    }

    static String multiplication(double firstValue, double secondValue) {
        return String.valueOf(firstValue * secondValue);
    }

    static String division(double firstValue, double secondValue) {
        return String.valueOf(firstValue / secondValue);
    }

    static String percentage(double firstValue, double secondValue) {
        return String.valueOf(secondValue / 100 * firstValue);
    }
}

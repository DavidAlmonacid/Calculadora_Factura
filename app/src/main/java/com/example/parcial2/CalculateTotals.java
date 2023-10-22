package com.example.parcial2;

public class CalculateTotals {
    public int calculateNetTotal(int quantity, int unitPrice) {
        return quantity * unitPrice;
    }

    public double calculateTotalWithIVA(int netTotal, int IVA) {
        return netTotal + calculateIVA(netTotal, IVA);
    }

    private static double calculateIVA(int price, int IVA) {
        return recursiveMultiplication(price, IVA) / 100.0;
    }

    private static int recursiveMultiplication(int numA, int numB) {
        if (numA == 0 || numB == 0) {
            return 0;
        }

        return numA + recursiveMultiplication(numA, numB - 1);
    }
}

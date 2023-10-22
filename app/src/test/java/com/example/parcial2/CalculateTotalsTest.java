package com.example.parcial2;

import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateTotalsTest {
    private final CalculateTotals totals = new CalculateTotals();

    @Test
    public void calculateNetTotal() {
        assertEquals(1000, totals.calculateNetTotal(10, 100));
        assertEquals(0, totals.calculateNetTotal(0, 100));
        assertEquals(0, totals.calculateNetTotal(10, 0));
    }

    @Test
    public void calculateTotalWithIVA() {
        assertEquals(1190, totals.calculateTotalWithIVA(1000, 19), 0.01);
        assertEquals(0, totals.calculateTotalWithIVA(0, 19), 0.01);
        assertEquals(1000, totals.calculateTotalWithIVA(1000, 0), 0.01);
    }
}

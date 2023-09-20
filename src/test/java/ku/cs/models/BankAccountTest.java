package ku.cs.models;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BankAccountTest {
    @Test
    public void testDeposit() {
        BankAccount b = new BankAccount("1", "X", 150.25);
        b.deposit(100.25);
        double actual = b.getBalance();
        double expected = 150.25 + 100.25;
        assertEquals(expected, actual);
    }

    @Test
    public void testWithdraw() {
        BankAccount b = new BankAccount("1", "X", 150.25);
        b.withdraw(100.25);
        double actual = b.getBalance();
        double expected = 150.25 - 100.25;
        assertEquals(expected, actual);
    }
}
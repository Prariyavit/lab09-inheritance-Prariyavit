package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class CreditAccountTest {
    @Test
    @DisplayName("test cashback when deposit")
    public void testDeposit() {
        CreditAccount c = new CreditAccount("1", "X", 0);
        c.deposit(60000);
        double actual = c.getCashBack();
        double expected = 60000.0 * 2 / 100;
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("test cashback when withdraw")
    public void testWithdraw() {
        CreditAccount c = new CreditAccount("1", "X", 60000);
        c.withdraw(30000);
        double actual = c.getCashBack();
        double expected = 30000.0 / 100;
        assertEquals(expected, actual);
    }

    @Test void testTransferCashback() {
        CreditAccount c = new CreditAccount("1", "X", 0);
        c.deposit(60000);
        // declare expected (balance + cashback)
        double expected = c.getBalance() + c.getCashBack();
        // transfer all cashback to balance
        boolean canTransfer = c.transferCashback(c.getCashBack());
        assertTrue(canTransfer);
        // get balance
        double actual = c.getBalance();

        assertEquals(expected, actual);
    }
}
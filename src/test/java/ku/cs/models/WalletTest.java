package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WalletTest {
    @Test
    @DisplayName("transfer from BankAccount to Wallet")
    void testAddMoneyToWallet() {
        BankAccount b = new BankAccount("1", "X", 5000);
        Wallet w = new Wallet();

        boolean canAdd = w.addMoneyToWallet(b, 1000);
        assertTrue(canAdd);

        double actualWallet = w.getBalance();
        double expectedWallet = 1000;

        double actualBank = b.getBalance();
        double expectedBank = 4000; // 5000 - 1000

        assertEquals(expectedWallet, actualWallet);
        assertEquals(expectedBank, actualBank);
    }

    @Test
    @DisplayName("test take money out of wallet")
    void testTakeMoneyOutOfWallet() {
        BankAccount b = new BankAccount("1", "X", 5000);
        Wallet w = new Wallet();
        w.addMoneyToWallet(b, 3000);
        boolean canTakeOut = w.takeMoneyOutOfWallet(2000);
        assertTrue(canTakeOut);

        double actual = w.getBalance();
        double expected = 3000 - 2000;
        assertEquals(expected, actual);
    }
}
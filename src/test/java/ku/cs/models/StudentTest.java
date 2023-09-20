package ku.cs.models;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StudentTest {

    @Test
    void testAddScore() {
        Student s = new Student("6510450593", "Prariyavit");
        s.addScore(60.23);
        assertEquals(60.23, s.getScore());
    }

    @Test
    void testCalculateGrade() {
        Student s = new Student("6510450593", "Prariyavit");
        s.addScore(80);
        assertEquals("A", s.grade());
    }

    @Test
    void testChangeName() {
        Student s = new Student("6510450593", "Prariyavit");
        s.changeName("X");
        String expected = "X";
        String actual = s.getName();
        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("Test student's wallet")
    void testStudentWallet() {
        Student s = new Student("6510450593", "Prariyavit");
        BankAccount b = new BankAccount("1", "X", 10000);
        // transfer from BankAccount to Wallet
        // then test balance of both bank and wallet if wallet balance increase and bank balance decrease or not
        s.getWallet().addMoneyToWallet(b, 5000);

        double actualWalletBalance = s.getWallet().getBalance();
        double expectedWalletBalance = 5000;

        assertEquals(expectedWalletBalance, actualWalletBalance);

        double actualBankBalance = b.getBalance();
        double expectedBankBalance = 10000 - 5000;

        assertEquals(expectedBankBalance, actualBankBalance);
    }
}
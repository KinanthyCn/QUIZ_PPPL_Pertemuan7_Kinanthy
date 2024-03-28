import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;
import org.example.Wallet;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class WalletTest {
    private Wallet sender;
    private Wallet recipient;


    @BeforeEach
    void setUp() {
        // Initialize resources before each test
        sender = new Wallet(100, "USD");
        recipient = new Wallet(0, "USD");
    }

    @AfterEach
    void tearDown() {
        // Clean up resources after each test
        sender = null;
        recipient = null;
    }

    @Test
        // Test case 1: Deposit dengan nilai negatif
    void testDepositAmount_NegativeAmount_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> sender.depositAmount(-150));
    }

    @Test
        // Test case 2: Withdraw dengan nilai negatif
    void testWithdrawAmount_NegativeAmount_ThrowsIllegalArgumentException() {
        assertThrows(IllegalArgumentException.class, () -> sender.withdrawAmount(-50));
    }

    @Test
        // Test case 3: Withdraw dengan saldo tidak mencukupi
    void testWithdrawAmount_InsufficientFunds_ReturnsFalseTest() {
        assertFalse(sender.withdrawAmount(150));
    }

    @Test
        // Test case 4: Transfer dengan saldo tidak mencukupi
    void testTransferFunds_InsufficientBalance_ThrowsIllegalArgumentExceptionTest() {
        assertThrows(IllegalArgumentException.class, () -> sender.transferFunds(recipient, 150));
    }

    @Test
        // Test case 5: Transfer dengan mata uang berbeda
    void testTransferFunds_DifferentCurrencies_ThrowsIllegalArgumentExceptionTest() {
        recipient = new Wallet(0, "EUR");
        assertThrows(IllegalArgumentException.class, () -> sender.transferFunds(recipient, 50));
    }

    @Test
        // Test case 6: Mengecek saldo
    void testGetBalance() {
        assertEquals(100, sender.getBalance());
    }
}



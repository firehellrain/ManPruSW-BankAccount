import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void cuentaBancariaRecibeElDineroInicial() {
        int expectedValue = 1000;
        BankAccount banco = new BankAccount(expectedValue);
        int actualValue = banco.getBalance();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sePuedeSacarDineroDeLaCuenta() {
        BankAccount banco = new BankAccount(1000);
        Assertions.assertTrue(banco.withdraw(200));
        int expectedValue = 800;
        int actualValue = banco.getBalance();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void noSePuedeSacarCantidadInvalidaDeLaCuenta() {
        BankAccount banco = new BankAccount(1000);
        Assertions.assertFalse(banco.withdraw(-100));
        Assertions.assertFalse(banco.withdraw(1200));
    }

    @Test
    public void sePuedeIngresarDineroEnLaCuenta() {
        BankAccount banco = new BankAccount(1000);
        banco.deposit(200);
        int expectedValue = 1200;
        int actualValue = banco.getBalance();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void noSePuedenIngresarCantidadesInvalidasEnLaCuenta() {
        BankAccount banco = new BankAccount(1000);
        Assertions.assertThrows(IllegalArgumentException.class, () -> banco.deposit(-200));
    }

}
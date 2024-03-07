import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BankTest {

    @Test
    public void bancoRecibeElDineroInicial() {
        int expectedValue = 1000;
        BankAccount banco = new BankAccount(expectedValue);
        int actualValue = banco.getBalance();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void sePuedeSacarDineroDelBanco() {
        BankAccount banco = new BankAccount(1000);
        banco.withdraw(200);
        int expectedValue = 800;
        int actualValue = banco.getBalance();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void noSePuedeSacarCantidadInvalida() {
        BankAccount banco = new BankAccount(1000);
        banco.withdraw(-100);
        int expectedValue = 1000;
        int actualValue = banco.getBalance();
        Assertions.assertEquals(expectedValue, actualValue); // Permite sacar dinero negativo
        banco.withdraw(1200);
        actualValue = banco.getBalance();
        Assertions.assertEquals(expectedValue, actualValue); // Permite sacar más dinero del que hay
    }

    @Test
    public void sePuedeIngresarDinero() {
        BankAccount banco = new BankAccount(1000);
        banco.deposit(200);
        int expectedValue = 1200;
        int actualValue = banco.getBalance();
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void noSePuedenIngresarCantidadesInvalidas() {
        BankAccount banco = new BankAccount(1000);
        Assertions.assertThrows(IllegalArgumentException.class, () -> banco.deposit(-200));
    }

}
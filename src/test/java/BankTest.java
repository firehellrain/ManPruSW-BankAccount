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
        // Permite sacar dinero negativo
        // Assertions.assertFalse(banco.withdraw(-100));
        // Permite sacar más dinero del que tiene la cuenta
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

    @Test
    public void seCalculaElCosteMensualDelPrestamo() {
        double totalAmount = 10000;
        double interes = 0.001;
        int months = 12;
        BankAccount banco = new BankAccount(1000);
        double expectedValue = 838.7599255697181;
        double actualValue = banco.payment(totalAmount, interes, months);
        Assertions.assertEquals(expectedValue, actualValue);
    }

    @Test
    public void seCalculaElPagoPendienteDelPrestamo() {
        double totalAmount = 10000;
        double interes = 0.001;
        int months = 12;
        int actualMonth = 2;
        BankAccount banco = new BankAccount(1000);
        double expectedValue =  8341.651388934994;
        double actualValue = banco.pending(totalAmount, interes, months, actualMonth);
        Assertions.assertEquals(expectedValue, actualValue);
    }


}
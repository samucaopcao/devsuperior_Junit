package tests.entities;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import entities.Account;
import tests.factory.AccountFactory;

public class AccountTests {
	// Devemos usar boas pr�ticas

	@Test
	// Nomenclatura = <A��O> should <EFEITO> [when <CEN�RIO>]
	public void depositShoudIncreaseBalanceAndDiscountFeeWhenPositiveAmount() {

		// Usar Padr�o AAA

		// 1� A = Arrange (instanciar obj necess�rios)
		double amount = 200.0;
		double expectedValue = 196.0;
		Account acc = AccountFactory.createEmptyAccount();

		// 2� A = Act (execute as a��es necess�rias)
		acc.deposit(amount);

		// 3� A = Assert (declare o que deveria acontecer ou
		// seja resultado esperado)

		// Nesse caso vemos se meu valor esperado � igual ao saldo
		Assertions.assertEquals(expectedValue, acc.getBalance());
	}

	@Test
	public void depositShouldDoNothingWhenNegativeAmount() {

		double expectedValue = 100.0;

		// Criamos uma conta com saldo de 100
		Account acc = AccountFactory.createAccount(expectedValue);
		double amount = -200.0;

		// Tentamos depositar -200
		acc.deposit(amount);

		// Confirmamos que n�o foi poss�vel o dep�sito, ent�o
		// meu saldo deve continuar 100 e meu valor esperado tamb�m
		Assertions.assertEquals(expectedValue, acc.getBalance());

	}

	@Test
	public void fullWithDrawShouldClearBalanceAndReturnFullBalance() {

		double expectedValue = 0.0;
		double initialBalance = 800.0;
		Account acc = AccountFactory.createAccount(initialBalance);

		double result = acc.fullWithDraw();

		Assertions.assertTrue(expectedValue == acc.getBalance());
		Assertions.assertTrue(result == initialBalance);

	}

	@Test
	// M�todo para sacar quando o saldo for suficiente
	public void withDrawShouldDecreaseBalanceWhenSufficientBalance() {

		// Crio uma conta com saldo de 800
		Account acc = AccountFactory.createAccount(800.0);

		// Saco 500
		acc.withdraw(500);

		// Testo se depois do saque sobrou os 300 reais
		// comparando 300 com o valor do saldo (acc.getBalance())
		Assertions.assertEquals(300.0, acc.getBalance());
	}

	@Test
	// M�todo para sacar quando o saldo N�O for suficiente
	public void withDrawShouldThrowExceptionWhenInsufficientBalance() {

		// Como o resultado deve retornar uma Excess�o
		// usamos o AssertThrow como primeiro atributo devemos~
		// passar qual o tipo de excess�o nesse caso IllegalArgumentException
		// e o que ser� execultado para causar esse erro

		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			// Crio uma conta com saldo de 800
			Account acc = AccountFactory.createAccount(800.0);

			// Saco 801
			acc.withdraw(801.0);
		});
	}
}

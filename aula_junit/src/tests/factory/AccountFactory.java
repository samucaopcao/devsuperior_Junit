package tests.factory;

import entities.Account;

public class AccountFactory {

	//Criamos uma classe de Fabrica(Factory)
	//que é uma classe auxiliar para instanciar obj pra nós
	//pois dará muito trabalho instanciar a classe 
	//quando essa tiver muitos atributos
	//nos nossos teste a classe Account tem somente
	//dois atributos o que não nos preocupa, mas e se tivesse 30?
	
	//Este método cria um Account com saldo 0
	public static Account createEmptyAccount() {
		return new Account(1L, 0.0);
	}
	
	//Este método cria um Account com saldo que desejarmos
	public static Account createAccount(double initialBalance) {
		return new Account(1L, initialBalance);
	}
}

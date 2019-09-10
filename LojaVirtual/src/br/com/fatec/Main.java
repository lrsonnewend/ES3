package br.com.fatec;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		int tipo;
		java.util.Scanner reader = new Scanner(System.in);

		Produto p1 = new Produto("TV Samsung 4K", 1500);
		
		System.out.println("Modo de desconto:\n1 - Porcentagem\n2 - Valor bruto");
		tipo = reader.nextInt();
		
		if(tipo == 1) {
			Porcentagem valorDesconto = new Porcentagem(20);
		
			if(valorDesconto.getDesconto() <= 100) {
			System.out.println("Produto: " + p1.getNome() + "\n" + "Preco: R$" + p1.getValorProd() + "\nDesconto: "
					+ valorDesconto.getDesconto() + "%\n" + "Total: R$"
					+ valorDesconto.precoFinal(p1.getValorProd(), valorDesconto.getDesconto()));
			}
			else
				System.out.println("Valor de desconto maior que o valor do produto.");
		}
		
		else if(tipo == 2) {
			Dinheiro money = new Dinheiro(100);
			if(money.getValorMoney() <= p1.getValorProd()) {
				System.out.println("Produto: " + p1.getNome()+ "\nPreco: R$" + p1.getValorProd() +
						"\nDesconto: R$" + money.getValorMoney()+"\nTotal: R$"
						+ money.precoFinal(p1.getValorProd(), money.getValorMoney()));
			}
			else
				System.out.println("Valor de desconto maior que o valor do produto.");
		}
		System.exit(0);
	}
}
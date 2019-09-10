package br.com.fatec;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;

public class Principal {

	public static void main(String[] args) throws ParseException {
		Veiculo v = new Veiculo();
		int categoria;
		long periodo;
		java.util.Scanner reader = new java.util.Scanner(System.in);
		ContaEstacionamento ce = new ContaEstacionamento();
		
		System.out.println("Insira a categoria do Ve�culo: \n"
				+ "1 - Ve�culo de passeio\n"
				+ "2 - Ve�culo de carga");
		
		v.categoria = reader.nextInt();
		
		System.out.println("Quanto tempo o ve�culo ficar� (em horas)?");
		periodo = reader.nextLong();
				
				
		if (v.categoria == 1) {
			int pessoas;
			System.out.println("Quantidade de pessoas: ");
			pessoas = reader.nextInt();
			
			v = new Passeio(pessoas);
			v.taxa = v.calcTaxa(pessoas);
			System.out.println("Ve�culo: " + v.verificaVeiculo(pessoas));
			System.out.println("Taxa Aplicada: " + v.taxa);
		}

		
		else if (v.categoria == 2) {
			int eixos;
			double valorCarga;
			System.out.println("quantidade de eixos: ");
			eixos = reader.nextInt();
			
			System.out.println("Valor da carga. R$: ");
			valorCarga = reader.nextFloat();
			
			v = new Carga(eixos, valorCarga);
			v.taxa = v.taxaCaminhao(eixos, valorCarga);
			
			System.out.println("Ve�culo com " +eixos+ " eixos");
			System.out.println("Taxa Aplicada: " + v.taxa);
			
		}
		
		ce.veiculo = v;
		ce.valorConta(periodo);
		
	}
}

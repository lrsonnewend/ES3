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
		
		System.out.println("Insira a categoria do Veículo: \n"
				+ "1 - Veículo de passeio\n"
				+ "2 - Veículo de carga");
		
		v.categoria = reader.nextInt();
		
		System.out.println("Quanto tempo o veículo ficará (em horas)?");
		periodo = reader.nextLong();
				
				
		if (v.categoria == 1) {
			int pessoas;
			System.out.println("Quantidade de pessoas: ");
			pessoas = reader.nextInt();
			
			v = new Passeio(pessoas);
			v.taxa = v.calcTaxa(pessoas);
			System.out.println("Veículo: " + v.verificaVeiculo(pessoas));
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
			
			System.out.println("Veículo com " +eixos+ " eixos");
			System.out.println("Taxa Aplicada: " + v.taxa);
			
		}
		
		ce.veiculo = v;
		ce.valorConta(periodo);
		
	}
}

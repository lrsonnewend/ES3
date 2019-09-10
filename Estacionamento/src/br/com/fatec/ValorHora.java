package br.com.fatec;

public class ValorHora implements CalculoValor{
	private final double hora = 3600000;

	@Override
	public double valorConta(long tempo, Veiculo veiculo) {
		return veiculo.taxa * Math.ceil(tempo / hora);
		//return 0;
	}

}

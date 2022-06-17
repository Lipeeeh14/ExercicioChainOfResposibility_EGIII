package br.com.fateczl.lipe.controller;

import br.com.fateczl.lipe.model.Funcionario;

public class DescontoSegundaFaixa implements IDescontoCOR {
	
	private float SALARIO_MINIMO_FAIXA = 1212;
	private float SALARIO_MAXIMO_FAIXA = 2457.35f;
	private float DESCONTO_PORC = 0.09f;
	
	@Override
	public float calculaDescontoISS(Funcionario func) {
		float desconto = 0;
		
		if (func.getSalario() >= SALARIO_MINIMO_FAIXA && func.getSalario() <= SALARIO_MAXIMO_FAIXA)
			desconto = (func.getSalario() - SALARIO_MINIMO_FAIXA) * DESCONTO_PORC;
		else if (func.getSalario() > SALARIO_MAXIMO_FAIXA)
			desconto = (SALARIO_MAXIMO_FAIXA - SALARIO_MINIMO_FAIXA) * DESCONTO_PORC;
		
		return desconto;
	}

	@Override
	public float proximoDesconto(Funcionario func) {
		DescontoTerceiraFaixa descTerFaixa = new DescontoTerceiraFaixa();
		float desconto = calculaDescontoISS(func);
		
		desconto += descTerFaixa.proximoDesconto(func);
		
		return desconto;
	}
	
}

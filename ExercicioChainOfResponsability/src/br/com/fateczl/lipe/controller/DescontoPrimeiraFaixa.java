package br.com.fateczl.lipe.controller;

import br.com.fateczl.lipe.model.Funcionario;

public class DescontoPrimeiraFaixa implements IDescontoCOR {
	
	private float SALARIO_MINIMO = 1212;
	private float DESCONTO_PORC = 0.075f;
	
	@Override
	public float calculaDescontoISS(Funcionario func) {
		float desconto = 0;
		
		if (func.getSalario() <= SALARIO_MINIMO) 
			desconto = func.getSalario() * DESCONTO_PORC;
		else
			desconto = SALARIO_MINIMO * DESCONTO_PORC;
			
		return desconto;
	}

	@Override
	public float proximoDesconto(Funcionario func) {
		DescontoSegundaFaixa descSegFaixa = new DescontoSegundaFaixa();
		float desconto = calculaDescontoISS(func);
		
		desconto += descSegFaixa.proximoDesconto(func);
		
		return desconto;
	}
	
}

package br.com.fateczl.lipe.controller;

import br.com.fateczl.lipe.model.Funcionario;

public class DescontoTerceiraFaixa implements IDescontoCOR {
	
	private float SALARIO_MINIMO_FAIXA = 2427.36f;
	private float SALARIO_MAXIMO_FAIXA = 3641.03f;
	private float DESCONTO_PORC = 0.12f;
	
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
		DescontoQuartaFaixa descQuartaFaixa = new DescontoQuartaFaixa();
		float desconto = calculaDescontoISS(func);
		
		desconto += descQuartaFaixa.proximoDesconto(func);
		
		return desconto;
	}

}

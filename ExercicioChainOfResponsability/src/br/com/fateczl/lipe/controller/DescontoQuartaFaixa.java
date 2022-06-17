package br.com.fateczl.lipe.controller;

import br.com.fateczl.lipe.model.Funcionario;

public class DescontoQuartaFaixa implements IDescontoCOR {
	
	private float SALARIO_MINIMO_FAIXA = 3641.04f;
	private float SALARIO_MAXIMO_FAIXA = 7087.22f;
	private float DESCONTO_PORC = 0.14f;
	
	@Override
	public float calculaDescontoISS(Funcionario func) {
		float desconto = 0;
		
		if (func.getSalario() >= SALARIO_MINIMO_FAIXA && func.getSalario() <= SALARIO_MAXIMO_FAIXA)
			desconto = (func.getSalario() - SALARIO_MINIMO_FAIXA) * DESCONTO_PORC;
		
		return desconto;
	}

	@Override
	public float proximoDesconto(Funcionario func) {
		return calculaDescontoISS(func);
	}

}

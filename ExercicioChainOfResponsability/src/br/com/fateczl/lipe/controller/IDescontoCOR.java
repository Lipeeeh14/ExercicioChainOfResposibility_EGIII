package br.com.fateczl.lipe.controller;

import br.com.fateczl.lipe.model.Funcionario;

public interface IDescontoCOR {
	public float calculaDescontoISS(Funcionario func);
	public float proximoDesconto(Funcionario func);
}

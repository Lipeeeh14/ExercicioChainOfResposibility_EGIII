package br.com.fateczl.lipe.view;

import org.hibernate.SessionFactory;

import br.com.fateczl.lipe.controller.DescontoPrimeiraFaixa;
import br.com.fateczl.lipe.model.Funcionario;
import br.com.fateczl.lipe.persistence.FuncionarioDAO;
import br.com.fateczl.lipe.util.PagamentoUtil;

public class Principal {

	public static void main(String[] args) {
		SessionFactory sf = PagamentoUtil.getSessionFactory();
		
		Funcionario func = new Funcionario();
		func.setId(1);
		func.setNome("Lipe");
		func.setSalario(1500f);
		
		FuncionarioDAO fDao = new FuncionarioDAO(sf);
		fDao.cadastrar(func);
		
		func = fDao.consultar(func);
		
		DescontoPrimeiraFaixa descPrimFaixa = new DescontoPrimeiraFaixa();
		func.salarioPosDescontos(descPrimFaixa.proximoDesconto(func));
		
		func.toString();
	}

}

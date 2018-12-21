package controller;

import model.*;

public class Teste {

	public static void main(String[] args) {
		ItemDePedido Idp1 = new ItemDePedido();
		Idp1.setQtde(2);
		Idp1.setSubtotal(22.98);
		System.out.println(Idp1.toString());

		ItemDePedido Idp2 = new ItemDePedido();
		Idp2.setQtde(1);
		Idp2.setSubtotal(98.75);
		System.out.println(Idp2.toString());

		UsuarioOld U1 = new UsuarioOld();
		U1.setEmail("camila@gmail.com");
		U1.setLogin("camila");
		U1.setMatricula(232323);
		U1.setNome("Camila");
		U1.setSenha("1234");
		U1.setTelefone("22734461");
		System.out.println(U1.toString());

		Endereco End1 = new Endereco();
		End1.setBairro("Rio Comprido");
		End1.setCep("20251-061");
		End1.setCidade("Rio de Janeiro");
		End1.setComplemento("39");
		End1.setEstado("RJ");
		End1.setLogradouro("39");
		End1.setNumero("39");
		System.out.println(End1.toString());
		
		Notebook Note1 = new Notebook();
		Note1.setDataCadastro("14/07");
		Note1.setDescricao("algo");
		Note1.setEstoque(3);
		Note1.setFigura("algo");
		Note1.setModelo("laranja");
		Note1.setNumeroNote(12345);
		Note1.setPrecoUnitario(40);
		System.out.println(Note1.toString());
		
		Notebook Note2 = new Notebook();
		Note2.setDataCadastro("19/02");
		Note2.setDescricao("algo");
		Note2.setEstoque(5);
		Note2.setFigura("algo");
		Note2.setModelo("azul");
		Note2.setNumeroNote(544333);
		Note2.setPrecoUnitario(80);
		System.out.println(Note2.toString());
		
		Notebook Note3 = new Notebook();
		Note3.setDataCadastro("05/07");
		Note3.setDescricao("algo");
		Note3.setEstoque(2);
		Note3.setFigura("algo");
		Note3.setModelo("verde");
		Note3.setNumeroNote(999948);
		Note3.setPrecoUnitario(66);
		System.out.println(Note3.toString());
		
		Pedido Pd1 = new Pedido();
		Pd1.setDataEmissao("30/06");
		Pd1.setFormaDePagamento("crédito");
		Pd1.setNumero(88839);
		Pd1.setSituacao("pago");
		Pd1.setValorTotal(20.00);
		System.out.println(Pd1.toString());
		

	}

}

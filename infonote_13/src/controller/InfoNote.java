package controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import model.*;
import model.DAO.ClienteDAO;
import model.DAO.EnderecoDAO;
import model.DAO.UsuarioDAO;
import util.*;

public class InfoNote {
	Usuario user;
	boolean logado = false;
	Usuario usuario;
	Cliente cliente;
	
	Configurador config;
	Ajuda ajuda;

	int opcao = 8;
	Notebook notebooks[] = new Notebook[10];
	Pedido pedido;

	private static Cliente clienteGlobal = null;
	private static Funcionario funcionarioGlobal = null;
	private static final int LOGIN = 1;
	private static final int CADASTRAR_USUARIO = 2;
	private static final int BUSCAR_NOTEBOOK = 3;
	private static final int INSERIR_NOTEBOOK = 4;
	private static final int REMOVER_NOTEBOOK = 5;
	private static final int VER_CARRINHO = 6;
	private static final int EFETUAR_COMPRA = 7;
	private static final int AJUDA = 8;
	private static final int SAIR = 9;

	public static void main(String[] args) {
		InfoNote info = new InfoNote();
		int opcao = SAIR;
		do {
			info.mostrarMenu();
			opcao = Teclado.lerInt("Digite sua op��o: ");
			
			switch (opcao) {
			case LOGIN:
				info.efetuarLogin();
				break;
				
			case CADASTRAR_USUARIO:
				info.cadastrarUsuario();
				break;
				
			case BUSCAR_NOTEBOOK:
				info.buscarNotebook();
				break;
				
			case INSERIR_NOTEBOOK:
				info.manterCarrinho();
				break;
				
			case REMOVER_NOTEBOOK:
				info.manterCarrinho();
				break;
				
			case VER_CARRINHO:
				info.manterCarrinho();
				break;
				
			case EFETUAR_COMPRA:
				if (!info.logado) {
					System.out.println("Efetue login para efetuar compra.");
					break;
				} else {
					info.efetuarCompra();
					break;
				}
				
			case AJUDA:
				info.ajuda();
				break;
				
			case SAIR:
				System.out.println("Sa�da do Sistema");
				break;
			default:
				System.out.println("Op��o inv�lida!");
			}
			Teclado.lerTexto("Pressione uma tecla para continuar...");
		} while (opcao != SAIR);
	}

	public InfoNote() {
		// Cria objeto de configura��es
		config = new Configurador();
		Locale.setDefault(new Locale(config.getIdioma(), config.getRegiao()));
		// Cria o objeto Ajuda
		ajuda = new Ajuda(config.getArquivoAjuda());
	}
		
	public void buscarNotebook1() {
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getSerialNote() + "-----" + notebooks[i].getModelo());
			}
		}
	}

	public void mostrarMenu() {
		System.out.println("=================================================");
		System.out.println(" InfoNote - Se n�o � Info n�o vendemos. "
				+ DateFormat.getDateInstance(DateFormat.SHORT).format(new Date()) + " "
				+ DateFormat.getTimeInstance().format(new Date()));
		if (logado == true) {
			System.out.println("Seja bem vindo, " + clienteGlobal.getNomeInvertido());
		}

		System.out.println("==================================================");

		System.out.println("1 - Login");
		System.out.println("2 - Cadastrar Cliente");
		System.out.println("3 - Buscar notebook");
		System.out.println("4 - Inserir Notebook no carrinho");
		System.out.println("5 - Remover Notebook no carrinho");
		System.out.println("6 - ver Carrinho");
		System.out.println("7 - Efetuar Compra");
		System.out.println("8 - Ajuda");
		System.out.println("9 - Sair");

	}

	public void efetuarLogin() {
		String login, senha;
		login = Teclado.lerTexto("Digite o login: ");
		senha = Teclado.lerTexto("Digite a senha: ");
		if (clienteGlobal != null) {
			logado = clienteGlobal.validarLogin(login, senha);
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usu�rio ou senha inv�lido.");
			}

		} else {
			logado = funcionarioGlobal.validarLogin(login, senha);
			if (logado) {
				System.out.println("Login efetuado com sucesso!");
			} else {
				System.out.println("Usu�rio ou senha inv�lido.");
			}

		}
	}

	public void cadastrarUsuario() {
		System.out.println("==================================================");
		System.out.println("=================================================");
		System.out.println(" InfoNote - Cadastro de Usu�rios. ");
		System.out.println("=================================================");

		String login = Teclado.lerTexto(" Login: ");
		String senha = Teclado.lerTexto(" Senha: ");
		int tipo = 1;
		//int tipo = 0; // porque todo cliente � tipo zero
		if (senha.equals("") || senha == null) {
			senha = GerarSenha.gerarSenha();
			System.out.println("Senha gerada: " + senha);
		}

		
		String codigoCliente = Teclado.lerTexto("codigo cliente");
		String nome = Teclado.lerTexto("Nome: ");
		String email = Teclado.lerTexto("E-mail: ");
		String telefone = Teclado.lerTexto("Telefone: ");

		// Endereco
		String logradouro = Teclado.lerTexto("logradouro:");
		String numero = Teclado.lerTexto("numero:");
		String complemento = Teclado.lerTexto("complemento:");
		String bairro = Teclado.lerTexto("bairro");
		String cidade = Teclado.lerTexto("cidade");
		String estado = Teclado.lerTexto("estado");

		String cep = Teclado.lerTexto("CEP: ");

		usuario = UsuarioDAO.inserir(login, senha, tipo);
		cliente = ClienteDAO.inserir(login, senha, tipo, codigoCliente, nome,
		email,telefone);
		Endereco endereco = EnderecoDAO.inserir(logradouro, numero, complemento,
		bairro, cidade, estado, cep, codigoCliente);

		// user = new Usuario("Marcos Lima", "Senha 12345", 1);
		System.out.println("=================================================");
		System.out.println(" Usu�rio Cadastrado Com Sucesso. ");
		System.out.println("=================================================");
		System.out.println(cliente);
		System.out.println(endereco);
		// System.out.println(Usuario);
	}

	public void buscarNotebook() {
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null) {
				System.out.println(notebooks[i].getSerialNote() + "-----" + notebooks[i].getModelo());
			}

		}

	}

	public void manterCarrinho() {
		System.out.println("manterCarrinho - Em Constru��o");
	}

	public void efetuarCompra() {
		System.out.println("efetuarCompra - Em Constru��o");

	}
	
	public void ajuda(){
		System.out.println(ajuda.getTexto());
		
		}

	// InfoNote info = new InfoNote();

	@SuppressWarnings("unlikely-arg-type")
	public void inserirNotebook() {
		// L� o notebook escolhido do teclado
		String numeroNote = Teclado.lerTexto("Informe o n�mero do notebook" + " para compra: ");
		// Cria pedido
		if (pedido == null) {
			pedido = new Pedido();
		}
		// Busca notebook selecionado
		Notebook aux = null;
		for (int i = 0; i < notebooks.length; i++) {
			if (notebooks[i] != null && numeroNote.equals(notebooks[i].getSerialNote())) {
				aux = notebooks[i];
			}
		}
		// Se n�o existir, interrompe
		if (aux == null) {
			return;
		}
		// Cria item
		ItemDePedido item = new ItemDePedido(1, aux.getPrecoUnitario(), aux);
		// Insere item no pedido
		pedido.inserirItem(item);
	}
	
	public static boolean isNumeric(String str)
	{
		try
		{
			@SuppressWarnings("unused")
			int i = Integer.parseInt(str);
		}
		catch(NumberFormatException nfe)
		{
			return false;
					}
		return true;
	}
}

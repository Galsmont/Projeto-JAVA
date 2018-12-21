package model;

public class ItemDePedido {
	private int qtde;
	private double subtotal;

	/**
	 * @return the qtde
	 */
	public int getQtde() {
		return qtde;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "ItemDePedido [qtde=" + qtde + ", subtotal=" + subtotal + "]";
	}

	/**
	 * @param qtde the qtde to set
	 */
	public void setQtde(int qtde) {
		this.qtde = qtde;
	}

	/**
	 * @return the subtotal
	 */
	public double getSubtotal() {
		return subtotal;
	}

	/**
	 * @param subtotal the subtotal to set
	 */
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}

	public ItemDePedido() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ItemDePedido(int qtde, double subtotal) {
		super();
		this.qtde = qtde;
		this.subtotal = subtotal;
	}

	public void mostrar () {
		//Mostrar usuário
		System.out.println("Qtde:" + this.qtde);
		System.out.println("Subtotal:" + this.subtotal);
		
	}
}

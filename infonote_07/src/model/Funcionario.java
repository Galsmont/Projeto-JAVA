package model;

public class Funcionario extends Usuario {
	private String matricula;

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

	public Funcionario() {
		super();
	}

	public Funcionario(String matricula) {
		super();
		this.matricula = matricula;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Funcionario [matricula=" + matricula + ", getMatricula()=" + getMatricula() + ", getLogin()="
				+ getLogin() + ", getSenha()=" + getSenha() + ", getTipo()=" + getTipo() + ", toString()="
				+ super.toString() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + "]";
	}

	

}

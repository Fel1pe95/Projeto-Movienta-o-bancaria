package model.entidades;

public class Conta {

	private Integer agenciaBancaria;
	private Integer numeroDaConta;
	private Integer senha;
	private Double saldo;

	public Conta() {
		super();
	}

	public Conta(Integer agenciaBancaria, Integer numeroDaConta, Integer senha, Double saldo) {
		super();
		this.agenciaBancaria = agenciaBancaria;
		this.numeroDaConta = numeroDaConta;
		this.senha = senha;
		this.saldo = saldo;
	}

	public Integer getAgenciaBancaria() {
		return agenciaBancaria;
	}

	public Integer getNumeroDaConta() {
		return numeroDaConta;
	}

	public Double getSaldo() {
		return saldo;
	}
	
	public Integer getSenha() {
		return senha;
	}

	public void deposito(Double montante) {
		saldo += montante;
	}

	public void saque(Double montante) {
		saldo -= montante;
	}
	

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((agenciaBancaria == null) ? 0 : agenciaBancaria.hashCode());
		result = prime * result + ((numeroDaConta == null) ? 0 : numeroDaConta.hashCode());
		result = prime * result + ((senha == null) ? 0 : senha.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Conta other = (Conta) obj;
		if (agenciaBancaria == null) {
			if (other.agenciaBancaria != null)
				return false;
		} else if (!agenciaBancaria.equals(other.agenciaBancaria))
			return false;
		if (numeroDaConta == null) {
			if (other.numeroDaConta != null)
				return false;
		} else if (!numeroDaConta.equals(other.numeroDaConta))
			return false;
		if (senha == null) {
			if (other.senha != null)
				return false;
		} else if (!senha.equals(other.senha))
			return false;
		return true;
	}
}

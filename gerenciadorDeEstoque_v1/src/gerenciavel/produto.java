package gerenciavel;

import java.util.Objects;

public class produto {

	int cod;
	String nome;
	String descricao;
	int quantidade;
	double pVenda;
	double pCusto;
	double lucro = pVenda - pCusto;

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getpVenda() {
		return pVenda;
	}

	public void setpVenda(double pVenda) {
		this.pVenda = pVenda;
	}

	public double getpCusto() {
		return pCusto;
	}

	public void setpCusto(double pCusto) {
		this.pCusto = pCusto;
	}

	public double getLucro() {
		return lucro;
	}

	public void setLucro(double lucro) {
		this.lucro = lucro;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cod, descricao, lucro, nome, pCusto, pVenda, quantidade);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		produto other = (produto) obj;
		return cod == other.cod && Objects.equals(descricao, other.descricao)
				&& Double.doubleToLongBits(lucro) == Double.doubleToLongBits(other.lucro)
				&& Objects.equals(nome, other.nome)
				&& Double.doubleToLongBits(pCusto) == Double.doubleToLongBits(other.pCusto)
				&& Double.doubleToLongBits(pVenda) == Double.doubleToLongBits(other.pVenda)
				&& quantidade == other.quantidade;
	}

	@Override
	public String toString() {
		return "produto [cod=" + cod + ", nome=" + nome + ", descricao=" + descricao + ", quantidade=" + quantidade
				+ ", pVenda=" + pVenda + ", pCusto=" + pCusto + ", lucro=" + lucro + "]";
	}

}

package gerenciavel;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class estoqueloja {

	String nome;
	String endereco;
	String cep;
	String cidade;
	String bairro;

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	private List<produto> item = new ArrayList<produto>();

	public List<produto> getProdutos() {
        return item;
    }

    public void addProduto(produto produto) {
        this.item.add(produto);
    }

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(bairro, cep, cidade, endereco, item, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		estoqueloja other = (estoqueloja) obj;
		return Objects.equals(bairro, other.bairro) && Objects.equals(cep, other.cep)
				&& Objects.equals(cidade, other.cidade) && Objects.equals(endereco, other.endereco)
				&& Objects.equals(item, other.item) && Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "estoqueloja [nome=" + nome + ", endereco=" + endereco + ", cep=" + cep + ", cidade=" + cidade
				+ ", bairro=" + bairro + ", item=" + item + "]";
	}

}

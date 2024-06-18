package gerenciadorDeEstoque;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import gerenciavel.estoqueloja;
import gerenciavel.produto;

public class executavel {

	static void cadastroLoja(List<estoqueloja> lojas) {

		int cadLoja = 0;

		do {
			estoqueloja loja = new estoqueloja();
			String nomeLoja = JOptionPane.showInputDialog("Qual é o nome da loja?");
			loja.setNome(nomeLoja);
			String enderecoLoja = JOptionPane.showInputDialog("Qual é o nome da rua e número do endereço da loja?");
			loja.setEndereco(enderecoLoja);
			String cepLoja = JOptionPane.showInputDialog("Informe o CEP?");
			loja.setCep(cepLoja);
			String bairroLoja = JOptionPane.showInputDialog("Qual o bairro?");
			loja.setBairro(bairroLoja);
			String cidadeLoja = JOptionPane.showInputDialog("Qual a cidade da loja?");
			loja.setCidade(cidadeLoja);
			lojas.add(loja);
			cadLoja = JOptionPane.showConfirmDialog(null,
					"Loja cadastrada com sucesso.\n" + "Gostaria de cadastrar outra Loja?");
		} while (cadLoja == 0);
	}

	static void cadastroProduto(List<estoqueloja> lojas) {

		int cadProd = 0;

		do {
			produto item = new produto();
			String codigoProduto = JOptionPane.showInputDialog("Informe o codigo do produto.");
			item.setCod(Integer.parseInt(codigoProduto));
			String nomeProd = JOptionPane.showInputDialog("Qual o nome do produto?");
			item.setNome(nomeProd);
			String descricaoProduto = JOptionPane.showInputDialog("Informe uma descrição para o produto:");
			item.setDescricao(descricaoProduto);
			String quantidadeProduto = JOptionPane.showInputDialog("Qual a quantidade de produto(s)?");
			item.setQuantidade(Integer.parseInt(quantidadeProduto));
			String precoVenda = JOptionPane.showInputDialog("Qual o valor de venda?");
			item.setpVenda(Double.parseDouble(precoVenda));
			String precoCsuto = JOptionPane.showInputDialog("Qual o valor de custo?");
			item.setpCusto(Double.parseDouble(precoCsuto));

			String[] nomesLojas = lojas.stream().map(estoqueloja::getNome).toArray(String[]::new);
			String lojaEscolhida = (String) JOptionPane.showInputDialog(null,
					"Escolha a loja para cadastrar o produto:", "Selecionar Loja", JOptionPane.QUESTION_MESSAGE, null,
					nomesLojas, nomesLojas[0]);

			for (estoqueloja loja : lojas) {
				if (loja.getNome().equals(lojaEscolhida)) {
					loja.addProduto(item);
					JOptionPane.showMessageDialog(null, "Produto cadastrado com sucesso na loja " + loja.getNome());
					break;
				}
			}

			cadProd = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar outro produto?");

		} while (cadProd == 0);

	}

	static void listarProdutosPorLoja(List<estoqueloja> lojas) {

		String[] nomesLojas = lojas.stream().map(estoqueloja::getNome).toArray(String[]::new);
		String lojaEscolhida = (String) JOptionPane.showInputDialog(null, "Escolha a loja para listar os produtos:",
				"Selecionar Loja", JOptionPane.QUESTION_MESSAGE, null, nomesLojas, nomesLojas[0]);

		for (estoqueloja loja : lojas) {
			if (loja.getNome().equals(lojaEscolhida)) {
				StringBuilder produtosList = new StringBuilder("Produtos da loja " + loja.getNome() + ":\n");
				for (produto item : loja.getProdutos()) {
					produtosList.append(item.toString()).append("\n");
				}
				JOptionPane.showMessageDialog(null, produtosList.toString());
				break;
			}
		}
	}

	public static void main(String[] args) {

		List<estoqueloja> lojas = new ArrayList<estoqueloja>();
		String choice = "";
		do {
			choice = JOptionPane.showInputDialog("Olá, como posso te ajudar hoje?\n" + "Cadastro de loja, digite 1.\n"
					+ "Listar lojas cadastradas, digite 2.\n" + "Cadastro de produto, digite 3.\n"
							+ "Listar produtos cadastrados, digite 4.\n"
					+ "Finalizar o programa, digite 6.");
			switch (Integer.parseInt(choice)) {
			case 1:
				JOptionPane.showMessageDialog(null, "Inicializando o menu de cadastro de loja....");
				cadastroLoja(lojas);
				break;
			case 2:
				if (lojas.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Não há lojas cadastradas. Por favor, cadastre uma loja primeiro.");
					break;
				}
				for (estoqueloja estoqueloja : lojas) {
					System.out.println(estoqueloja.toString());
				}
				break;
			case 3:
				if (lojas.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Não há lojas cadastradas. Por favor, cadastre uma loja primeiro.");
					break;
				}
				JOptionPane.showMessageDialog(null, "Inicializando o menu de cadastro de produtos....");
				cadastroProduto(lojas);
				break;
			case 4:
				if (lojas.isEmpty()) {
					JOptionPane.showMessageDialog(null,
							"Não há lojas cadastradas. Por favor, cadastre uma loja primeiro.");
					break;
				}
				listarProdutosPorLoja(lojas);
				break;
			case 6:
				JOptionPane.showMessageDialog(null, "Finalizando o programa....");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção invalida.");
				break;
			}

		} while (Integer.parseInt(choice) != 6);

	}

}

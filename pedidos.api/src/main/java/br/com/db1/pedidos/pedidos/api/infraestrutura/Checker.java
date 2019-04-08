package br.com.db1.pedidos.pedidos.api.infraestrutura;

public class Checker {
	
	public static void notNull(Object value, String field){
		if(value == null){
			throw new RuntimeException("Campo " + field + " � obrigat�rio.");
		}
	}
	
	public static void valorMenorQueZero(Double value, String field){
		if(value <= 0 ){
			throw new RuntimeException("Valor Invalido");
		}
	}
	public static void tamanhoCpfIncorreto(String value, String field){
		if(value.length() < 11 ){
			throw new RuntimeException("CPF Invalido");
		}
	}
	public static void tamanhoDoCodigoDoProduto(String value, String field) {
		if(value.length() < 5 && value.length() > 5) {
			throw new RuntimeException("C�digo com tamanho invalido");
		}
	}
	public static void quantidadeMaximaDeItens(Double value, String field) {
		if(value > 10) {
			throw new RuntimeException("Quantidade de itens excedida");
		}
	}
//	public static void quantidadeMaximadeProdutos(List<PedidoItem> produtos,String field) {
//		if(produtos.size() > 10) {
//			throw new RuntimeException("Quantidade de produtos excedida");
//		}
//	}
	

	

}
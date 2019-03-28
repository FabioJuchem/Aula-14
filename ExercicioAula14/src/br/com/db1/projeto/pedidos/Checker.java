package br.com.db1.projeto.pedidos;

public class Checker {
	
	public static void notNull(Object value, String field){
		if(value == null){
			throw new RuntimeException("Campo " + field + " é obrigatório.");
		}
	}
	
	public static void valorMenorQueZero(Double value, String field){
		if(value <= 0 ){
			throw new RuntimeException("Valor Invalido");
		}
	}
	
	

}

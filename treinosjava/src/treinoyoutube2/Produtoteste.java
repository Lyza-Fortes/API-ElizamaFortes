package treinoyoutube2;

public class Produtoteste {
	public static void main(String[] args) {
			
	//Construtor padrão instanciar
	
	Produto p1 = new Produto();
	p1.nome = "Caneta vermelha";
	p1.marca = "Bic";
	p1.valor = 1.50f;	
			
	// construtor com dois parâmetros
	
	Produto p2 = new Produto("Caneta azul", "Bic");
	p1.valor = 1.98f;
			
	// Construtor com três parâmetros
	
	Produto p3 = new Produto("Borracha", "Mercur", 2.0f);

	
	System.out.println("Nome:"+ p1.nome +" marca "+ p1.marca +" valor "+p1.valor);
	
	System.out.println("Nome:"+ p2.nome +" marca "+ p2.marca +" valor "+p2.valor);
	
	System.out.println("Nome:"+ p3.nome +" marca "+ p3.marca +" valor "+p3.valor);
	}
	
	
	
	
	
	
}

package exercicio3;

import java.util.Scanner;

//Leia 2 valores inteiros (A e B). Após, o programa deve mostrar uma mensagem "Sao Multiplos" ou "Nao sao 
//Multiplos", indicando se os valores lidos são múltiplos entre si. Atenção: os números devem poder ser digitados em 
//ordem crescente ou decrescente

public class Ex3 {
	public static void main(String[] args) {

		int n1, n2;

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite o primeiro número: ");
		n1 = sc.nextInt();
		System.out.println("Digite o segundo número: ");
		n2 = sc.nextInt();

		if (n1 % n2 == 0 || n2 % n1 == 0) {
			System.out.println("São múltiplos");

		} else {
			System.out.println("Não são múltiplos");
		}
		sc.close();
	}
}
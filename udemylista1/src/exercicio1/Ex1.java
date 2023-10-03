package exercicio1;

import java.util.Scanner;

//Faça um programa para ler dois valores inteiros, 
//e depois mostrar na tela a soma desses números com uma
//mensagem explicativa, conforme exemplos.

public class Ex1 {
	
	public static void main(String[] args) {
		int n1, n2, resultado;

		Scanner sc = new Scanner(System.in);

		System.out.print("Insira o primeiro número: ");
		n1 = sc.nextInt();

		System.out.print("Insira o segundo número: ");
		n2 = sc.nextInt();

		resultado = n1 + n2;

		System.out.printf("A soma entre %d e %d é = %d", n1, n2, resultado);

		sc.close();
	}
}
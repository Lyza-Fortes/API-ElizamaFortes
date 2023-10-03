package exercicio1;

import java.util.Scanner;

//Fazer um programa para ler um número inteiro, e depois dizer se este número é negativo ou não

public class Ex1 {
	public static void main(String[] args) {
		int n;

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira um número: ");
		n = sc.nextInt();

		if (n < 0) {
			System.out.println(n + " é negativo.");

		} else {
			System.out.println(n + " não é negativo.");
		}
       
		sc.close();
	}

}

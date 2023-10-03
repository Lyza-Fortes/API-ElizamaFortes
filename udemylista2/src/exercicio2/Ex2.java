package exercicio2;

import java.util.Scanner;

//Fazer um programa para ler um número inteiro e dizer se este número é par ou ímpar

public class Ex2 {
	public static void main(String[] args) {
		int n;
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Digite um número: ");
		n = sc.nextInt();
		
		if (n % 2 ==0) {
			System.out.println(n+ " é par.");
			
		}
		else {
			System.out.println(n+ " é ímpar.");
		}
		sc.close();
	}

}

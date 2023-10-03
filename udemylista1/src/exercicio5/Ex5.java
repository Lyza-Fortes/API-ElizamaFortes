package exercicio5;

import java.util.Scanner;

//Fazer um programa para ler o código de uma peça 1, 
//o número de peças 1, o valor unitário de cada peça 1, o 
//código de uma peça 2, o número de peças 2 
//e o valor unitário de cada peça 2. Calcule e mostre o valor a ser pago.

public class Ex5 {
	public static void main(String[] args) {
		
		int cod1, cod2, n1, n2;
		double valor1, valor2;
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Código da peça:  ");
		cod1 = sc.nextInt();
		System.out.println("Número de peças:  ");
		n1 = sc.nextInt();
		System.out.println("valor:  ");
		valor1 = sc.nextDouble();
		
		System.out.println("Código da peça:  ");
		cod2 = sc.nextInt();
		System.out.println("Número de peças:  ");
		n2 = sc.nextInt();
		System.out.println("Valor:  ");
		valor2 = sc.nextDouble();
		
		System.out.println("Total a pagar:  "+ (valor1+valor2));
		
	}

}

package exercicio3;

import java.util.Scanner;

//Fazer um programa para ler quatro valores inteiros A, B, C e D. A seguir, calcule e mostre a diferença do produto 
//de A e B pelo produto de C e D segundo a fórmula: DIFERENCA = (A * B - C * D).
	
public class Ex3 {
	
	public static void main(String[] args) {
		
		int a, b, c, d, dif;
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Insira quatro valores: ");
		a = sc.nextInt();
		b = sc.nextInt();
		c = sc.nextInt();
		d = sc.nextInt();
		
		dif = a * b - c * d;
		
		System.out.println("A Diferença é = "+ dif);
		
		sc.close();
	}
	

}

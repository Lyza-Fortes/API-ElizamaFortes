package exercicio6;

import java.util.Scanner;

//Fazer um programa que leia três valores com ponto flutuante de dupla precisão:
//A, B e C. Em seguida, calcule e mostre: 
//a) a área do triângulo retângulo que tem A por base e C por altura. 
//b) a área do círculo de raio C. (pi = 3.14159) 
//c) a área do trapézio que tem A e B por bases e C por altura. 
//d) a área do quadrado que tem lado B. 
//e) a área do retângulo que tem lados A e B

public class Ex6 {
	public static void main(String[] args) {
		
		double a, b, c, pi = 3.14159;
		
		Scanner sc = new Scanner (System.in);
		
		a = sc.nextDouble();
		b = sc.nextDouble();
		c = sc.nextDouble();
		
		System.out.printf("A área do triângulo retângulo que tem %.2f por base e %.2f por altura = %.2f%n", a, c, a * c/2.0);
		System.out.printf("A área do círculo de raio %.2f é = %.2f%n",c, pi * c * c);
		System.out.printf("A área do trapézio que tem %.2f e %.2f por bases e %.2f por altura é = %.2f%n", a, b, c, (a + b) / 2.0 * c);
		System.out.printf("A área do quadrado que tem lado %.2f é = %.2f%n",b, b*b);
		System.out.printf("A área do retângulo que tem lados %.2f e %.2f é = %.2f%n", a, b, a * b);
		
		sc.close();

	}
}

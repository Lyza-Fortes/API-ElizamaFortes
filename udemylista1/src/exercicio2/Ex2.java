package exercicio2;

import java.util.Locale;
import java.util.Scanner;

//Faça um programa para ler o valor do raio de um círculo, 
//e depois mostrar o valor da área deste círculo com quatro 
//casas decimais conforme exemplos.
//Fórmula da área: area = π . raio2
//Considere o valor de π = 3.14159

public class Ex2 {
	public static void main(String[] args) {
		double area, r, pi = 3.14159;
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Insira o raio de um círculo: ");
		r = sc.nextDouble(); 
		
		area = pi * r * r;
		
		System.out.printf("area = %.4f%n ", area);
		
		sc.close();
	
	}

}

package exercicio4;

import java.util.Scanner;

//Fazer um programa que leia o número de um funcionário, 
//seu número de horas trabalhadas, o valor que recebe por 
//hora e calcula o salário desse funcionário. A seguir, 
//mostre o número e o salário do funcionário, com duas casas decimais
public class Ex4 {
	public static void main(String[] args) {
		
		int numero;
		double salario, horas, valor;
		
		Scanner sc = new Scanner (System.in);
		
		System.out.println("Insira seu número: ");
		numero = sc.nextInt();
		System.out.println("Insira o número de horas trabalhadas: ");
		horas = sc.nextDouble();
		System.out.println("Valor que recebe por hora:  ");
		valor = sc.nextDouble();
		
		salario = valor * horas;
		
		System.out.printf("O funcionário %d recebe %.2f mensalmente ", numero, salario);
		
		sc.close();
		
	}   

}

package exercicio7;

import java.util.Scanner;

//Leia 2 valores com uma casa decimal (x e y), que devem representar as coordenadas 
//de um ponto em um plano. A seguir, determine qual o quadrante ao qual pertence o 
//ponto, ou se está sobre um dos eixos cartesianos ou na origem (x = y = 0).
//Se o ponto estiver na origem, escreva a mensagem “Origem”.
//Se o ponto estiver sobre um dos eixos escreva “Eixo X” ou “Eixo Y”, conforme for a situação.

public class Ex7 {
	public static void main(String[] args) {
		double x, y;

		Scanner sc = new Scanner(System.in);

		System.out.println("valor 1: ");
		x = sc.nextDouble();
		System.out.println("valor 2: ");
		y = sc.nextDouble();

		if (x > 0 && y < 0) {
			System.out.println("Está no Q4");

		}
		else if (y > 0 && x < 0) {
			System.out.println("Está no Q1");
		}
		else if (x > 0 && y > 0) {
			System.out.println("Está no Q2");
		}
		else if (x < 0 && y < 0) {
			System.out.println("Está no Q3");
		} else if (x == 0 && y == 0) {
			System.out.println("Origem");
		}
		else if (x == 0 && y != 0) {
			System.out.println("Está no eixo y");
		
		} else if (y == 0 && x != 0) {
			System.out.println("Está no eixo x");
		} sc.close();
		

	}
}
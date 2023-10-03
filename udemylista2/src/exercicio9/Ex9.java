package exercicio9;

import java.util.Scanner;

public class Ex9 {
	public static void main(String[] args) {

		int x, soma = 0;
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira um número: ");
		x = sc.nextInt();

		while (x != 0 ) {
			soma = soma + x;
			x = sc.nextInt();

		}
		System.out.println("A soma dos numeros inseridos é = " + soma);

		sc.close();
	}
}

package exercicio5;

import java.util.Scanner;

//Com base na tabela abaixo, escreva um programa que leia o código de um item e a quantidade deste item. A 
//seguir, calcule e mostre o valor da conta a pagar

public class Ex5 {
	public static void main(String[] args) {
		int cod, quant;
		double total;

		Scanner sc = new Scanner(System.in);

		System.out.println("Código do produto: ");
		cod = sc.nextInt();
		System.out.println("Quantidade de  produto: ");
		quant = sc.nextInt();

		if (cod == 1) {
			total = quant * 4.00;

		} else if (cod == 2) {
			total = quant * 4.50;

		} else if (cod == 3) {
			total = quant * 5.00;

		} else if (cod == 4) {
			total = quant * 2.00;

		} else
			total = quant * 1.50;

		System.out.println("Total a pagar: " + total);
		sc.close();

	}
}

package exercicio4;

import java.util.Scanner;

//Leia a hora inicial e a hora final de um jogo. A seguir calcule a duração do jogo, sabendo que o mesmo pode 
//começar em um dia e terminar em outro, tendo uma duração mínima de 1 hora e máxima de 24 horas.

public class Ex4 {
	public static void main(String[] args) {

		int horainicial, horafinal, duracao;
		Scanner sc = new Scanner(System.in);

		System.out.println("Insira a hora inicial: ");
		horainicial = sc.nextInt();
		System.out.println("Insira a hora final: ");
		horafinal = sc.nextInt();
		if (horainicial < horafinal) {
			duracao = horafinal - horainicial;

		} else {
			duracao = 24 - horainicial + horafinal;

		}System.out.println("O jogo  durou "+duracao+" horas.");

	}
}

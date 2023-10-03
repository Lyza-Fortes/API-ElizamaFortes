package treinoyoutube1;

import java.util.Scanner;

// Alunoteste representa o objeto dentro dela (Aluno)

public class Alunoteste { // chamar método main
	public static void main(String[] args) {

		double nota1, nota2, media;

		Scanner sc = new Scanner(System.in);

		System.out.println("Insira nota da prova:  ");
		nota1 = sc.nextInt();

		System.out.println("Insira nota do teste:  ");
		nota2 = sc.nextInt();

		// Instanciação de objeto
		Aluno a1 = new Aluno();

		media = a1.nota(nota1, nota2);
		System.out.println("Média: " + media);
		
		sc.close();
	}
}
package exercicio1;

import java.util.Scanner;

//Escreva um programa que repita a leitura de uma senha até que ela seja válida. Para cada leitura de senha 
//incorreta informada, escrever a mensagem "Senha Invalida". Quando a senha for informada corretamente deve ser 
//impressa a mensagem "Acesso Permitido" e o algoritmo encerrado. Considere que a senha correta é o valor 2002

public class Ex1 {
	public static void main(String[] args) {

		int senha, num = 2002;

		Scanner sc = new Scanner(System.in);

		System.out.println("Digite sua senha: ");
		senha = sc.nextInt();

		while (senha != num) {
			System.out.println("Senha inválida");
			senha = sc.nextInt();
		}

		System.out.println("Acesso permitido");
	     
		sc.close();
	}

}

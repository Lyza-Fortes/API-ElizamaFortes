package exercicio3;

import java.util.Scanner;

//Um Posto de combustíveis deseja determinar qual de seus produtos tem a preferência de seus clientes. Escreva 
//um algoritmo para ler o tipo de combustível abastecido (codificado da seguinte forma: 1.Álcool 2.Gasolina 3.Diesel 
//4.Fim). Caso o usuário informe um código inválido (fora da faixa de 1 a 4) deve ser solicitado um novo código (até 
//que seja válido). O programa será encerrado quando o código informado for o número 4. Deve ser escrito a 
//mensagem: "MUITO OBRIGADO" e a quantidade de clientes que abasteceram cada tipo de combustível, conforme 
//exemplo

public class Ex3 {
	public static void main(String[] args) {

		int opcao = 0, alcool = 0, gasolina = 0, diesel = 0;

		Scanner sc = new Scanner(System.in);

		do {

			System.out.println("Digite 1 para alcool: ");
			System.out.println("Digite 2 para gasolina: ");
			System.out.println("Digite 3 para diesel : ");
			System.out.println("Digite 4 para sair: ");
			opcao = sc.nextInt();

			switch (opcao) {
			case 1:
				alcool++;
				break;
			case 2:
				gasolina++;
				break;
			case 3:
				diesel++;
				break;

			}
		} while (opcao != 4);
		sc.close();

		System.out.println("Muito obrigado\n Alcool: " + alcool + "\n Gasolina: " + gasolina + "\n Diesel: " + diesel);
	}

}

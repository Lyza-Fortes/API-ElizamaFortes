package teste1;

import java.util.Locale;

public class exercicio1 {
	public static void main(String[] args) {
		
	
	String produto1 = "COMPUTER", produto2= "OFFICE DESCK";
	int age = 30, code = 5290;
	char gender = 'F';
    Double price1 = 2100.0, price2 = 650.50, measure = 53.234567;
    
    System.out.println("PRODUCTS:");
    System.out.printf("%S WHITCH PRICE IS $ %.2f%n", produto1,  price1);   
    System.out.printf("%S WHITCH PRICE IS $ %.2f%n", produto2,  price2);
    System.out.println("RECORD "+ age + " years old, "+code+ " ande "+gender);
    
    System.out.println("MEASUE WITH LIGHT DECIMAL PLACES "+ measure);
    System.out.printf("ROUDED (THREE DECIMAL PLACES): %.3f%n", measure);
    Locale.setDefault(Locale.US);
    System.out.printf("US DECIMAL POINT: %.3f ", measure);
    
	}

}

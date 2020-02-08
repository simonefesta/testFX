

/*
 * Copyright Simone Festa
 */

public class Model {
	public float Calculate(long number1, long number2, String operator) {
		System.out.println("step7");
		System.out.println("vado nei calcoli");
		
		System.out.println(number1);
		System.out.println(operator);
		System.out.println(number2);
		
		switch(operator) {
		
		
		
		case "+":
			return number1+number2;
		case "-":
			return number1-number2;
		case "x":
			System.out.println("----------");
			
			return number1*number2;
		case "/":
				return number1/number2;
		case "c":
			return 0;
		case "sqrt":
			return (float) Math.sqrt(number1);
		
		
		default:   //se non premo questi pulsanti ma altri
			return 0;
			
		
		
		
		
		
		
		}
		
	
	}

}

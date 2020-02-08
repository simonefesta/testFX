import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

/*
 * Copyright 2020 Simone Festa
 */


public class Controller  {
	@FXML
	private Label result;  //link risultato al label fxml
	private long number1 = 0; //valore default
	private String operator ="";
	private boolean start = true;
	private  Model model = new Model();
	
	@FXML
	public void processNumbers(ActionEvent event) {
		
		if(start) { System.out.println("step0"); //azzero il parse. Se metto 3 cifre, ci vado solo una volta.
				    result.setText("");
					start = false;
				
		}
		System.out.println("number");
		String value = ((Button)event.getSource()).getText(); //prende il testo corrispondente al bottone e lo metto in value
		result.setText(result.getText()+value); //prendo il valore che già è presente, e sommo.
		System.out.println(result);				//prendo la stringa finale, cioè il primo numero.
	
	}
	
	public void processOperators(ActionEvent event) {
		String value = ((Button)event.getSource()).getText(); //Prendo l'operazione.
		if(value.equals("c")) { float output = model.Calculate(number1,0,operator);
								result.setText(String.valueOf(output));
								operator = "";
								start = true;
		}
		else if(value.equals("sqrt")) { number1 = Long.parseLong(result.getText());
										operator = value;
										Float output = model.Calculate(number1,number1,operator);
										result.setText(String.valueOf(output));
										operator = "";
										start = true;
										
			
			
			
			
		}
		else if(value.equals("^2")) {System.out.println("QUADRATO");
									 operator="x";
									 number1 = Long.parseLong(result.getText());
									 float output = model.Calculate(number1,number1,operator);
									 result.setText(String.valueOf(output));
									 operator = "";
									 start = true;
			
									}
		else {
		System.out.println(result);
		System.out.println(value);
		if (!value.equals("=")) {	//Entro se l'operazione NON è =.
			System.out.println("step1");
			if(!operator.isEmpty())	//se operatore non vuoto
				{System.out.println("step2");
				 return;}
			System.out.println("step3");
			operator = value;
			System.out.println(operator);
			number1 = Long.parseLong(result.getText());	//facendo qualsiasi operazione, copio il valore che avevo prima in number1 e azzero.
			result.setText("");
			System.out.println("step4");
			
		} else {// Ci vado se l'operazione è = .Adesso prendo il secondo numero! Lo salvo quando premo uguale, perchè so che ho finito.
			System.out.println("step5");
				long number2 = Long.parseLong(result.getText());
				if (number2 == 0) {result.setText("Impossibile dividere per 0");
									operator = "";
									start = true;
								  }
				else {
					System.out.println("step6");
					float output = model.Calculate(number1, number2,operator);
					result.setText(String.valueOf(output));
					operator = "";
					start = true;
				}
			}
			
			
		}
	}
}




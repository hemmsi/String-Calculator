package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.length() == 1){
			return Integer.parseInt(text);	
		}
		String[] numbers = text.split(",");

		return Integer.parseInt(numbers[0]) + Integer.parseInt(numbers[1]);
    }

}

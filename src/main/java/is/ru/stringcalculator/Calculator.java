package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){
		if(text.equals("")){
			return 0;
		}
		if(text.length() == 1){
			return toInt(text);	
		}
		
		String[] numbers = text.split(",");
		int total = 0;
		for(int i = 0; i< numbers.length; i++){
			total += toInt(numbers[i]);
		}
		
		return total;
    }

    private static int toInt(String text){
    	return Integer.parseInt(text);
    }
}

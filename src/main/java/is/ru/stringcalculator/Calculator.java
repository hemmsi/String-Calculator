package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){
				
		String[] numbers = split(text);
		
		int total = 0;
		for(int i = 0; i < numbers.length; i++){
			total += toInt(numbers[i]);
		}
		
		return total;
    }

    private static int toInt(String text){
    	if(text.equals("")){
			return 0;
		}
    	return Integer.parseInt(text);
    }
    private static String[] split(String text){
    	return text.split("\\n|,");
    } 
}

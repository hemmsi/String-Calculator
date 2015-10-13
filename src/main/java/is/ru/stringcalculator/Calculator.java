package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){

        String[] numbers = split(text);
        
        String negNumbers ="";

        int total = 0;
        for(int i = 0; i < numbers.length; i++){
        	if(numbers[i].startsWith("-")){
        		negNumbers += numbers[i] + ",";
        	}
            total += toInt(numbers[i]);
        }
 		checkForNeg(negNumbers);

        return total;
    }

    private static int toInt(String text){
        if(text.equals("")){
            return 0;
        }
        return Integer.parseInt(text);
    }

    private static String[] split(String text){
        String delimiter = "\n|,";

        if(text.length() > 2 && text.charAt(0) == '/' && text.charAt(1) == '/'){
            delimiter += "|" + text.charAt(2);
            return text.substring(3).split(delimiter);
        }
        return text.split(delimiter);
    }
    
    private static void checkForNeg(String text){
       if(text.length() > 0){
        	text = text.substring(0, text.length()-1);
        	throw new RuntimeException("Negatives not allowed: " + text);
        }
    }
}
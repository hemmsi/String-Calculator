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
        if(text.startsWith("-")){
            throw new RuntimeException("Negatives not allowed: " + text);
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
    public static void main(String[] args){
       System.out.println(add("-1,2"));
    }

}
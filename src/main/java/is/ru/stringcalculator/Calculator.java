package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){

        String[] numbers = split(text);
        String negNumbers = "";

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
        if(!text.equals("") && Integer.parseInt(text) <= 1000){
            return Integer.parseInt(text);
        }
        return 0;
    }

    private static String[] split(String text){
        String delimiter = "\n|,";

        if(text.startsWith("//")){
            return splitCustom(text, delimiter);
        }
        return text.split(delimiter);
    }

    private static void checkForNeg(String text){
        if(text.length() > 0){
            text = text.substring(0, text.length()-1);
            throw new RuntimeException("Negatives not allowed: " + text);
        }
    }
    private static String[] splitCustom(String text, String delimiter){
        int index = 3;
        delimiter += '|';

        if(text.charAt(index - 1) == '['){

            for(int i = index; text.charAt(i) != '\n'; i++, index = i){
                if(text.charAt(i) == '['){
                    delimiter += '|';
                }else if(text.charAt(i) =='*') {
                    delimiter += "\\" + text.charAt(i);
                }else if(text.charAt(i) !=']'){
                    delimiter += text.charAt(i);
                }
            }
        }else{
            delimiter += text.charAt(index - 1);
        }
        return text.substring(index + 1).split(delimiter);
    }
}
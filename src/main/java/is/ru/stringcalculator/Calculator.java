package is.ru.stringcalculator;

public class Calculator {

    public static int add(String text){
        String[] numbers;
        if(text.length() > 2 && text.charAt(0) == '/' && text.charAt(1) == '/'){
            String delimiter = String.valueOf(text.charAt(2));
            numbers = splitDiffDel(text.substring(3), delimiter);

        }else{
            numbers = split(text, "");
        }

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
    private static String[] split(String text, String delimiter){

        return text.split("\n|,|" + delimiter);
    }
    private static String[] splitDiffDel(String text, String delimiter){
      return split(text,delimiter);

    }
    public static void main(String[] args){
       System.out.println(add("1,5"));
    }
}

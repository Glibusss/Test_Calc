
import java.io.IOException;

import java.util.Scanner;

public class Main {

    public static int romanToInt(String s) {


        int ans = 0, num = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            switch (s.charAt(i)) {
                case 'I' -> num = 1;
                case 'V' -> num = 5;
                case 'X' -> num = 10;
                case 'L' -> num = 50;
                case 'C' -> num = 100;
                case 'D' -> num = 500;
                case 'M' -> num = 1000;
            }
            if (4 * num < ans) ans -= num;
            else ans += num;
        }
        return ans;
    }
public static boolean isRoman(String s){
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)<='A'||s.charAt(i)>='Z'){
                return false;
            }
        }
        return true;
}
    public static String intToRoman(int num) {

        String[] M = {"", "M", "MM", "MMM"};
        String[] C = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String[] X = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String[] I = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];}


    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        System.out.println(calc(input));



}
    public static String calc(String input)throws IOException{
        String[] ops = input.split(" ");
        if(ops.length>3){
            try{
                throw new IOException();}
            catch (IOException e){
                System.out.println("формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)\n");
            }
            return "";

        }
        String operand1 =ops[0];
        String operand2=ops[2];
        String operator = ops[1];
        String result = null;
        int op1,op2;

        if(!(isRoman(operand1)&&isRoman(operand2))){//Norm
            try{

                op1=Integer.parseInt(operand1);

            }
            catch(NumberFormatException e){
                System.out.println("Разные системы исчисления");
                return "";
            }
            try{

                op2=Integer.parseInt(operand2);

            }
            catch(NumberFormatException e){
                System.out.println("Разные системы исчисления");
                return "";
            }

            op1=Integer.parseInt(operand1);
            op2=Integer.parseInt(operand2);

            if((op1<1||op1>10)||(op2<1||op2>10)){
                try{
                    throw new IOException();}
                catch (IOException e){
                    System.out.println("Число должно быть в диапазоне от 1 до 10\n");
                }
                return "";
            }

            switch (operator) {
                case "+" -> result = Integer.toString(op1 + op2);
                case "-" -> result = Integer.toString(op1 - op2);
                case "*" -> result = Integer.toString(op1 * op2);
                case "/" -> result = Integer.toString(op1 / op2);
            }

        }//НОрма, проверка на разные системы + вычисление в арабской

        if(isRoman(operand1)&&isRoman(operand2)){
            if((romanToInt(operand1)<1||romanToInt(operand1)>10)||(romanToInt(operand2)<1||romanToInt(operand2)>10)){
                try{
                    throw new IOException();}
                catch (IOException e){
                    System.out.println("Число должно быть в диапазоне от 1 до 10\n");
                }
                return "";
            }
if((romanToInt(operand1)<=romanToInt(operand2))&&operator.equals("-")){
    try{
        throw new IOException();}
    catch (IOException e){
        System.out.println("В римской системе счисления нет чисел от 0 и меньше\n");
    }
    return "";
}
            op1 = romanToInt(operand1);
op2=romanToInt(operand2);
            switch (operator) {
                case "+" -> result = intToRoman(op1 + op2);
                case "-" -> result = intToRoman(op1 - op2);
                case "*" -> result = intToRoman(op1 * op2);
                case "/" -> result = intToRoman(op1 / op2);
            }


}//Норма, римские
return result;
        }




    
    
    }













   


import java.io.IOException;
import java.util.Scanner;

class Calc {
    public static void main(String[] args) throws scannerExept {
        Convert convert = new Convert();
        String[] sings = {"+", "-", "/", "*"};//массив самх сиволов
        String[] singsF = {"\\+", "-", "/", "\\*"};// массив их значений
        Scanner console = new Scanner(System.in);
        String exp = console.nextLine();
        int singsIndex = -1;//нужно чтобы проверить ввелся ли знак, мало ли
        for (int i = 0; i < sings.length; i++) {
            if (exp.contains(sings[i])) {
                singsIndex = i;
                break;
            }
        }
        if (singsIndex == -1) {
            System.out.println("Введите амперант");//нет знака +,-,*,/;
            return;
        }
        if (singsIndex == -1) //делю по знаку
        {
            System.out.println("Некорректное выражение");
            return;
        }


        String[] ch = exp.split(singsF[singsIndex]);
        if(convert.isRoman(ch[0]) == convert.isRoman(ch[1])){
            int a,b;
            boolean isRoman = convert.isRoman(ch[0]);//смотрим римские ли
            if(isRoman) {
                a = convert.romanToInt(ch[0]); if((a< 0)|| (a>11)) {throw new scannerExept("Неверное число, диапазон от 1-10");}
                b = convert.romanToInt(ch[1]); if((b<= 0)|| (b>11)) {throw new scannerExept("Неверное число, диапазон от 1-10");}

            }else{
                a = Integer.parseInt(ch[0]);if((a< 0)|| (a>11)) {throw new scannerExept("Неверное число, диапазон от 1-10");}
                b = Integer.parseInt(ch[1]);if((a< 0)|| (b>11)) {throw new scannerExept("Неверное число, диапазон от 1-10");}
            }
            int result;
            switch (sings[singsIndex]) {
                case "+":
                    result = a + b;
                    break;
                case "-":
                    result = a - b;
                    break;
                case "*":
                    result = a * b;
                    break;
                default:
                    result = a / b;
                    break;
            }
                if(isRoman){
                    if (result<0){throw new scannerExept("Меньше нуля");}
                System.out.println(convert.intToRoman(result));//вывыодим римскими
            }
            else{
                System.out.println(result);//выводим арабскими
            }
        }else{
            System.out.println("Числа должны быть в одном формате");
        }


    }
}
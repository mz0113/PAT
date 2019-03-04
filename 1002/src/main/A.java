package main;

import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        String n = new Scanner(System.in).nextLine();
        char[] chars = n.toCharArray();
        Long i = 0l;
        for (char c:chars) {
            i+=Integer.valueOf(String.valueOf(c));
        }
        char[] str = i.toString().toCharArray();
        StringBuffer buffer = new StringBuffer();
        for (char c:str) {
            switch (c){
                case '0':buffer.append("ling ");break;
                case '1':buffer.append("yi ");break;
                case '2':buffer.append("er ");break;
                case '3':buffer.append("san ");break;
                case '4':buffer.append("si ");break;
                case '5':buffer.append("wu ");break;
                case '6':buffer.append("liu ");break;
                case '7':buffer.append("qi ");break;
                case '8':buffer.append("ba ");break;
                case '9':buffer.append("jiu ");break;
            }
        }
        System.out.println(buffer.deleteCharAt(buffer.length()-1).toString());
    }
}
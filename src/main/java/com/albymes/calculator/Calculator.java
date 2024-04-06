package com.albymes.calculator;
import java.util.Scanner;

public class Calculator {
    public static void calculator() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the arithmetic expression:");
        String expression = scanner.nextLine();

        try {
            double result = evaluateExpression(expression);
            System.out.println("Result: " + result);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: kindly enter an expression" + e.getMessage());
        }
    }

    public static double evaluateExpression(String expression) {
        expression = expression.replaceAll("\\s+", "");
        String [] nums = expression.split("");

        if (expression.length() == 3) {
            double a = Integer.parseInt(nums[0]);
            String b = String.valueOf(nums[1]);
            double c = Integer.parseInt(String.valueOf(nums[2]));;

            return twoDigitCalculator(a, c, b);
        } else if (expression.length() == 4) {
            char characterAtIndex2 = expression.charAt(1);
            if(Character.isDigit(characterAtIndex2)){
                int twoCharacters = Integer.valueOf(expression.substring(0, 2));
                return twoDigitCalculator(twoCharacters, Double.parseDouble(nums[3]), nums[2]);
            } else if (Character.isDigit(expression.charAt(2)) && Character.isDigit(expression.charAt(3))) {
                int twoCharacters = Integer.valueOf(expression.substring(2, 4));
                return twoDigitCalculator(Double.parseDouble(nums[0]), twoCharacters, nums[1]);
            }
        } else if ((expression.length() == 5)){
            if(Character.isDigit(expression.charAt(1)) && Character.isDigit(expression.charAt(4))){
                int twoCharacters = Integer.valueOf(expression.substring(0, 2));
                int lastTwoCharacters = Integer.valueOf(expression.substring(3, 5));
                if(twoCharacters <= 10 || lastTwoCharacters <= 10){
                    return twoDigitCalculator(twoCharacters, lastTwoCharacters,  nums[2]);
                }
            } else if (!Character.isDigit(expression.charAt(1)) && !Character.isDigit(expression.charAt(3))) {
                double num1 = Double.parseDouble(nums[0]);
                double num2 = Double.parseDouble(nums[2]);
                double num3 = Double.parseDouble(nums[4]);
                String operator1 = nums[1];
                String operator2 = nums[3];
              return twoOperatorsCalculator(num1, num2, num3, operator1, operator2);
            }
        } else if ((expression.length() == 6)) {
            if (Character.isDigit(expression.charAt(1))) {
                int twoCharacters = Integer.valueOf(expression.substring(0, 2));
                if (twoCharacters >= 1 && twoCharacters <= 10) {
                    double num2 = Double.parseDouble(nums[3]);
                    double num3 = Double.parseDouble(nums[5]);
                    String operator1 = nums[2];
                    String operator2 = nums[4];
                    return  twoOperatorsCalculator(twoCharacters, num2, num3, operator1, operator2);
                }
            } else if (Character.isDigit(expression.charAt(3))) {
                int twoCharacters = Integer.valueOf(expression.substring(2, 4));
                if (twoCharacters >= 1 && twoCharacters <= 10) {
                    double num1 = Double.parseDouble(nums[0]);
                    double num3 = Double.parseDouble(nums[5]);
                    String operator1 = nums[1];
                    String operator2 = nums[4];
                    return  twoOperatorsCalculator(num1, twoCharacters, num3, operator1, operator2);
                }
            } else if (Character.isDigit(expression.charAt(5))) {
                int twoCharacters = Integer.valueOf(expression.substring(4, 6));
                if (twoCharacters >= 1 && twoCharacters <= 10) {
                    double num1 = Double.parseDouble(nums[0]);
                    double num2 = Double.parseDouble(nums[2]);
                    String operator1 = nums[1];
                    String operator2 = nums[3];
                    return  twoOperatorsCalculator(num1, num2, twoCharacters, operator1, operator2);
                }
            }
        } else if ((expression.length() == 7)) {
            char a = expression.charAt(1);
            char b = expression.charAt(4);
            if (Character.isDigit(a) && Character.isDigit(b)) {
                double num1 = Integer.valueOf(expression.substring(0, 2));
                double num2 = Integer.valueOf(expression.substring(3, 5));
                if ((num1 >= 1 && num1 <= 10) && (num2 >= 1 && num2 <= 10) ) {
                    double num3 = Double.parseDouble(nums[6]);
                    String operator1 = nums[2];
                    String operator2 = nums[5];
                    return  twoOperatorsCalculator(num1, num2, num3, operator1, operator2);
                }
            } else if (Character.isDigit(expression.charAt(1)) && Character.isDigit(expression.charAt(6))) {
                double num1 = Integer.valueOf(expression.substring(0, 2));
                double num3 = Integer.valueOf(expression.substring(5, 7));
                if ((num1 >= 1 && num1 <= 10) && (num3 >= 1 && num3 <= 10) ) {
                    double num2 = Double.parseDouble(nums[3]);
                    String operator1 = nums[2];
                    String operator2 = nums[4];
                    return  twoOperatorsCalculator(num1, num2, num3, operator1, operator2);
                }
            } else if (Character.isDigit(expression.charAt(3)) && Character.isDigit(expression.charAt(6))) {
                double num2 = Integer.valueOf(expression.substring(2, 4));
                double num3 = Integer.valueOf(expression.substring(5, 7));
                if ((num2 >= 1 && num2 <= 10) && (num3 >= 1 && num3 <= 10) ) {
                    double num1 = Double.parseDouble(nums[0]);
                    String operator1 = nums[1];
                    String operator2 = nums[4];
                    return  twoOperatorsCalculator(num1, num2, num3, operator1, operator2);
                }
            }
        }  else if ((expression.length() == 8)) {
            if (Character.isDigit(expression.charAt(1)) && Character.isDigit(expression.charAt(4))
                    && Character.isDigit(expression.charAt(7))) {
                double num1 = Integer.valueOf(expression.substring(0, 2));
                double num2 = Integer.valueOf(expression.substring(3, 5));
                double num3 = Integer.valueOf(expression.substring(6, 8));
                if ((num1 >= 1 && num1 <= 10) && (num2 >= 1 && num2 <= 10) && (num3 >= 1 && num3 <= 10) ) {
                    String operator1 = nums[2];
                    String operator2 = nums[5];
                    return  twoOperatorsCalculator(num1, num2, num3, operator1, operator2);
                }
            }
        }


        System.out.println("Wrong Expression");
        return Double.NaN;
    }

    public static double twoDigitCalculator(double a, double c, String operator) {
        if((a >= 1  && a <= 10) && (c >= 1 && c <= 10)){
            switch (operator) {
                case "+":
                    return a + c;
                case "-":
                    return a - c;
                case "*":
                    return a * c;
                case "/":
                    return a / c;
            }
        }

        System.out.println("Enter Numbers from 1 to 10");
        return Double.NaN;
    }

// -, + : +, + ; - , +

    public static double twoOperatorsCalculator(double num1, double num2, double num3,
                                     String operator1, String operator2) {
       if("+".equals(operator1) && "+".equals( operator2)){
           return  num1 + num2 + num3;
       } else if("+".equals( operator1) && "-".equals( operator2)){
           return  num1 +  num2 -  num3;
       } else if("-".equals( operator1) && "-".equals( operator2)){
           return  num1 -  num2 -  num3;
       } else if("+".equals( operator1) && "*".equals( operator2)){
           return  num1 +  num2 *  num3;
       }  else if("-".equals( operator1) && "+".equals( operator2)){
           return  num1 -  num2 +  num3;
       }  else if("*".equals( operator1) && "+".equals( operator2)){
           return  num1 *  num2 +  num3;
       }  else if("*".equals( operator1) && "*".equals( operator2)){
           return  num1 *  num2 *  num3;
       }  else if("*".equals( operator1) && "-".equals( operator2)){
           return  num1 *  num2 -  num3;
       } else if("/".equals( operator1) && "*".equals( operator2)){
           return  num1 /  num2 *  num3;
       }  else if("-".equals( operator1) && "/".equals( operator2)){
           return  num1 -  num2 /  num3;
       }  else if("+".equals( operator1) && "/".equals( operator2)){
           return  num1 +  num2 /  num3;
       }  else if("/".equals( operator1) && "/".equals( operator2)){
           return  num1 /  num2 /  num3;
       } else if("/".equals( operator1) && "-".equals( operator2)){
           return  num1 /  num2 - num3;
       }  else if("/".equals( operator1) && "+".equals( operator2)){
           return  num1 /  num2 + num3;
       }  else if("-".equals( operator1) && "*".equals( operator2)){
           return  num1 -  num2 *  num3;
       }  else if("*".equals( operator1) && "/".equals( operator2)){
           return  num1 -  num2 /  num3;
       }

        System.out.println("Wrong Expression");
        return Double.NaN;
       }
}



import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

//        t_1();
//        t_2();
//        t_3();
//        t_4();
    }

    // 1) Вычислить n-ое треугольного число (сумма чисел от 1 до n), n! (произведение чисел от 1 до n)

    static void t_1() {
        System.out.print("Введите число n: ");
        Scanner scanner = new Scanner(System.in);
        int n = 0;
        if (scanner.hasNextInt()) {
            n = scanner.nextInt();
        }
        scanner.close();
        int sum = 0;
        int fact = 1;
        for (int i = 1; i <= n; i++) {
            sum += i;
            fact *= i;
        }
        System.out.printf("Сумма чисел от 1 до %d = %d \n", n, sum);
        System.out.printf("Факториал числа %d = %d \n", n, fact);
    }

// 2) Вывести все простые числа от 1 до 1000

    static void t_2(){
        for (int i = 1; i <= 1000; i++) {
            boolean Simple = true;
            boolean Sqrt = true;
            for (int j = 2; j < i && Sqrt; j++) {
                if (i % j == 0) Simple = false;
                if (j * j > i) Sqrt = false;
            }
            if (Simple) System.out.printf("%d ", i);
        }
    }


// 3) Реализовать простой калькулятор


    static void t_3(){
        Scanner scanner = new Scanner(System.in);
        String input = " ";
        while (!input.isEmpty()) {
            System.out.println("Введите задачу: ");
            input = scanner.nextLine().trim();
            String[] members = input.split("\\*|/|\\+|-");
            float firstMember = 0;
            float secondMember = 0;
            boolean parsed = false;
            try {
                if (members.length == 2) {
                    firstMember = Float.parseFloat(members[0]);
                    secondMember = Float.parseFloat(members[1]);
                    parsed = true;
                } else if (members.length == 3) {
                    firstMember = -1*Float.parseFloat(members[1]);
                    secondMember = Float.parseFloat(members[2]);
                    parsed = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            if (parsed) {
                if (input.indexOf('*') > 0) System.out.println(firstMember * secondMember);
                else if (input.indexOf('/') > 0) System.out.println(firstMember / secondMember);
                else if (input.indexOf('+') > 0) System.out.println(firstMember + secondMember);
                else if (input.indexOf('-') > 0) System.out.println(firstMember - secondMember);
            } else {
                System.out.println("Ошибка");
                break;
            }
        }
        scanner.close();
    }


//4) (дополнительное задание) Задано уравнение вида q + w = e, q, w, e >= 0.
//Некоторые цифры могут быть заменены знаком вопроса, например, 2? + ?5 = 69.
//Требуется восстановить выражение до верного равенства.
//Предложить хотя бы одно решение или сообщить, что его нет.


    public static void t_4(){
        System.out.println("Введите задачу: ");
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine().trim();
        int count = 0;
        for (char c : input.toCharArray()) {
            if (c == '?') count++;
        }
        boolean hasDecision = false;
        for (int num = 0; num < Math.pow(10,count); num++) {
            String expr = input.trim();
            int n = num;
            while (expr.indexOf('?') > 0) {
                String numStr = String.valueOf(n % 10);
                n /= 10;
                expr = expr.replaceFirst("\\?", numStr);
            }
            String[] members = expr.split("\\+|=");
            try {
                int firstMember = Integer.parseInt(members[0].trim());
                int secondMember = Integer.parseInt(members[1].trim());
                int result = Integer.parseInt(members[2].trim());
                if (firstMember + secondMember == result) {
                    System.out.println(expr);
                    hasDecision = true;
                }
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        if (!hasDecision) {
            System.out.println("Ошибка");
        }
        scanner.close();
    }


}
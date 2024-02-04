import java.util.Scanner;


class TwiceEvenNumber {
    private final int number;

    public TwiceEvenNumber(int number) {
        this.number = number;
    }

    public boolean isTwiceEven() {
        int sum = 0;
        int product = 1;
        int temp = number;

        while (temp != 0) {
            int digit = temp % 10;
            sum += digit;
            product *= digit;
            temp /= 10;
        }

        return (sum % 2 == 0) && (product % 2 == 0);
    }
}


public class LaboratoryWork_1 {
    public static void main(String[] args) {
        while (true) {
            Scanner input = new Scanner(System.in);
            int steps;
            int n;
            Text_Bot("main_menu");
            switch (input.nextInt()) {
                case 1:
                    Text_Bot("Input_type_1");
                    steps = SyracuseSequenceSteps(input.nextInt());
                    Text_Bot("out");
                    System.out.println(steps);
                    break;
                case 2:
                    Text_Bot("Input_type_2");
                    n = input.nextInt();
                    int[] numbers = new int[n];
                    for (int i = 0; i < n; i++) {
                        numbers[i] = input.nextInt();
                    }
                    int result = calculateAlternatingSum(numbers);
                    Text_Bot("out");
                    System.out.println(result);
                    break;
                case 3:
                    int treasureX = input.nextInt();
                    int treasureY = input.nextInt();
                    steps = findTreasure(treasureX, treasureY, input);
                    Text_Bot("out");
                    System.out.println(steps);
                    break;
                case 4:
                    Text_Bot("Input_type_3");
                    n = input.nextInt(); // количество дорог
                    int maxRoad = 0;
                    int maxHeight = 0;
                    for (int i = 0; i < n; i++) {
                        int numTunnels = input.nextInt();
                        int currentMaxHeight = calculateMaxHeight(numTunnels, input);

                        if (currentMaxHeight > maxHeight) {
                            maxHeight = currentMaxHeight;
                            maxRoad = i + 1;
                        }
                    }
                    Text_Bot("out");
                    System.out.println(maxRoad + " " + maxHeight);
                    break;
                case 5:
                    Scanner scanner = new Scanner(System.in);
                    System.out.print("Введите трехзначное число: ");
                    n = scanner.nextInt();

                    if (n < 100 || n > 999) {
                        System.out.println("Неверный Ввод! Пожалуйста, введите трехзначное число.");
                    } else {
                        TwiceEvenNumber number = new TwiceEvenNumber(n);
                        if (number.isTwiceEven()) {
                            System.out.println(n + " - это дважды четное число.");
                        } else {
                            System.out.println(n + " - не является дважды четным числом.");
                        }
                    }
                    break;
                case 6:
                    System. exit(0);
            }
        }
    }


    public static void Text_Bot(String choice){
        switch (choice) {
            case ("main_menu"):
                System.out.println("""
                        1. Сиракузская последовательность
                        2. Сумма ряда
                        3. Ищем клад
                        4. Логистический максимин
                        5. Дважды четное число
                        6 .Выход""");
                break;
            case ("out"):
                System.out.println("Вывод: ");
                break;
            case ("Input_type_1"):
                System.out.println("Вводится одно натуральное число n");
                break;
            case ("Input_type_2"):
                System.out.println("Вводится количество чисел и сами числа через пробел");
                break;
            case ("Input_type_3"):
                System.out.println("Два целых числа: номер дороги (начиная нумерацию с единицы), по " +
                "которой нужно проехать, чтобы высота грузовика была наибольшей, и сама эта высота.");
                break;


        }
    }
    public static int SyracuseSequenceSteps(int n) {
        int steps = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n = n / 2;
            } else {
                n = 3 * n + 1;
            }
            steps++;
        }
        return steps;
    }
    public static int calculateAlternatingSum(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (i % 2 == 0) {
                sum += numbers[i];
            } else {
                sum -= numbers[i];
            }
        }
        return sum;
    }
    public static int findTreasure(int treasureX, int treasureY, Scanner input) {
        int currentX = 0;
        int currentY = 0;
        int minInstructions = 0;

        while (true) {
            String direction = input.next();
            if (direction.equals("стоп")) {
                break;
            }
            int steps = input.nextInt();

            switch (direction) {
                case "север" -> currentY += steps;
                case "юг" -> currentY -= steps;
                case "запад" -> currentX -= steps;
                case "восток" -> currentX += steps;
            }

           minInstructions++;
           if (currentX == treasureX && currentY == treasureY) {
               break;
           }
        }

        return minInstructions;
    }
    public static int calculateMaxHeight(int numTunnels, Scanner input) {
        int max = 0;
        for (int i = 0; i < numTunnels; i++) {
            int height = input.nextInt();
            if (height < max || i == 0) {
                max = height;
            }
        }
        return max;
    }

}

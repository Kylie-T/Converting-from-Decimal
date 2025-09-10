import java.util.ArrayList;
import java.util.Scanner;

class DecimalTest {
    public static void main(String[] args) {

        boolean mayRun = true;

        while (mayRun) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter a number");
            double num = scanner.nextDouble();

            System.out.println("Enter the base");
            int base = scanner.nextInt();

            Decimal conversion = new Decimal(num, base);
            ArrayList<Integer> convertInt = conversion.conInt();
            ArrayList<Integer> convertFrac = conversion.conDec();

            for (int numInt : convertInt) {
                if (numInt < 10) {
                    System.out.print(numInt);
                } else {
                    for (int i = 0; i < conversion.hexNum.length;i++) {
                        if (conversion.hexNum[i] == numInt) {
                            System.out.print(conversion.hexLet[i]);
                            break;
                        }
                    }
                }
            }
            if (!convertFrac.isEmpty()) {
                System.out.print(".");
                for (int decimalNum : convertFrac) {
                    if (decimalNum < 10) {
                        System.out.print(decimalNum);
                    } else {
                        for (int i = 0; i < conversion.hexNum.length;i++) {
                            if (conversion.hexNum[i] == decimalNum) {
                                System.out.print(conversion.hexLet[i]);
                                break;
                            }
                        }
                    }
                }

                if (convertFrac.size() > 10) {
                    System.out.print("...");
                }
                System.out.println("\nAnother? (type n or y)");
                Scanner scannerAns = new Scanner(System.in);
                String answer = scannerAns.nextLine();
                if (answer.charAt(0) == 'n') {
                    mayRun = false;
                }
            }
        }
    }
}

// Kylie Tate
// Date: 9-7-25

import java.util.Scanner;
import java.util.ArrayList;

class DecimalTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a number");
        double num = scanner.nextFloat();

        System.out.println("Enter the base");
        int base = scanner.nextInt();

        Decimal conversion = new Decimal(num, base);

        conversion.conIntBack();
        for(int i = 0; i < conversion.conInt().size(); i++) {
            System.out.print(conversion.conInt().get(i));
        }
        System.out.print(".");
        for(int i = 0; i < conversion.conDec().size(); i++) {
            System.out.print(conversion.conDec().get(i));
        }
    }
}
class Decimal {

    private double num;
    private int base;

    public Decimal(double num, int base) {
        this.num = num;
        this.base = base;
    }
    public ArrayList<Integer> conIntBack() {
        ArrayList<Integer> remaindersBack = new ArrayList<>();
        int wholeNum = (int) this.num;
        while (wholeNum != 0) {
            int remainder = wholeNum % this.base;
            remaindersBack.add(remainder);
            wholeNum /= this.base;
        }
        return remaindersBack;
    }
    public ArrayList<Integer> conInt() {
        ArrayList<Integer> remain = conIntBack();
        ArrayList<Integer> result = new ArrayList<>();
        for(int i = remain.size() - 1; i >= 0; i--) {
            result.add(remain.get(i));
        }
        return result;
    }
    public ArrayList<Integer> conDec() {
        ArrayList<Integer> fracNums = new ArrayList<>();
        double fracNum = this.num - (int)this.num;
        while (fracNum != 0) {
            double product = fracNum * this.base;
            int frontNum = (int) product;
            fracNums.add(frontNum);
            if (product >= 1) {
                product -= Math.ceil(product);
            }
            fracNum = product;
        }
        return fracNums;
    }

}
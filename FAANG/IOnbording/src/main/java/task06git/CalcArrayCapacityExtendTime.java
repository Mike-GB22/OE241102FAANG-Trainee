package task06git;

public class CalcArrayCapacityExtendTime {
    public static void main(String[] args) {
        doCalc(10,  1_000_000);
        doCalc(2,  10);
    }

    public static void doCalc(int initSize, int toSize) {
        System.out.printf("\n��������� ��������: %d, ������� ��������: %d\n%d", initSize, toSize, initSize);

        int curentSize = initSize;
        int countOfExtends = 0;
        while (curentSize < toSize){
            countOfExtends++;
            curentSize = (curentSize * 3 / 2) + 1;
            System.out.print(" -> " + curentSize);
        }
        System.out.printf("\n��� �������� %d ���������, �� ��������� ArrayList c %d �� %d, �� ���-�� ��� ����������: %d\n",toSize, initSize, curentSize, countOfExtends);
    }
}

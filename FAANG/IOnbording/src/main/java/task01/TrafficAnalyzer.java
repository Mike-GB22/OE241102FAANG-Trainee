//2024.11.02

package task01;

import java.util.Arrays;

public class TrafficAnalyzer {

    public static void main(String[] args) {
        int[] traffic = {1, 20, 30, 50, 100, 500, 1000, 1, 2, 3};
        printMaxTraffic("Variant 1: " + getMaxTraffic(traffic));
        printMaxTraffic("Variant 2: " + getMaxTrafficVariantTwo(traffic));

    }

    public static int getMaxTraffic(int[] traffic){
        int max = traffic[0];
        for (int i = 1; i < traffic.length; i++){
            if (traffic[i] > max) max = traffic[i];
        }
        return  max;
    }
    public static int getMaxTrafficVariantTwo(int[] traffic){
        return Arrays.stream(traffic).max().orElse(0);
    }

    public static void printMaxTraffic(String str){
        System.out.println("Max volume of traffic: " + str);
    }
}

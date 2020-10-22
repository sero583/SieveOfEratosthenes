package com.sero583.sieveoferatosthenes;

public class Main {
    public static final int EXIT_CODE_OK = 0;
    public static final int EXIT_CODE_NO_ARGS = 1;
    public static final int EXIT_CODE_INVALID_ARGS = 2;

    public static final int START = 2;
    public static final int LINEBREAK_AFTER = 20;

    public static void main(String[] args) {
        // do not check more for null we don't care about fancy JREs or other outer calls to this method in an abusive way
	    if(args.length<1) {
            System.out.println("Please input the maximum value.");
	        return;
        }

	    int max;

	    try {
            max = Integer.parseInt(args[0]);
        } catch(NumberFormatException e) {
	        System.out.println("Maximum value must be an integer.");
	        System.exit(EXIT_CODE_INVALID_ARGS);
	        return;
        }

	    System.out.println("Using range " + START + "-" + max + ".");


	    int printed = 0;
	    int itMax = max+1; // max+1 to include last number of iteration too into this loop
        String result = "Prime numbers = [";
	    for(int i = START; i < itMax; i++) {
	        if(isPrimeNumber(i)) {
                result += String.valueOf(i) + (i < (max) ? (++printed%LINEBREAK_AFTER == 0 ? "\n" : ", ") : "");
            }
        }
	    result = result.substring(0, result.length()-2) +  "]";

	    System.out.println(result);
    }

    private static boolean isPrimeNumber(int value) {
        if(value<=1) return false;

        for(int i = 2; i < value+1; i++) {
            if(i==value) continue;

            if(value%i==0) {
                return false;
            }
        }
        return true;
    }
}

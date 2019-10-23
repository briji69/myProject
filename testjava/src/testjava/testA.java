package testjava;

import java.util.Scanner;

public class testA {
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the number");
		int n=sc.nextInt();
		
		for(int i =1;i<=n;i++) {
			int k =0;
			k++;
			for(int j =1; j<=i ; j++) {
				System.out.print((char)(k+64)+" ");
			}System.out.println();
		}
	}
}

package com.otsi;

import java.util.Arrays;
import java.util.Scanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SortingInSpringBootApplication {

	public static void main(String[] args) {
		SpringApplication.run(SortingInSpringBootApplication.class, args);

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter no of rows ::");
		int n = sc.nextInt();
		System.out.println("Enter no of columns ::");
		int m = sc.nextInt();
		int arr[][] = new int[n][m];
		for (int i = 0; i < n; i++) {
			System.out.println("Enter " + m + " values for " + (i + 1) + " column ::");
			for (int j = 0; j < m; j++) {
				arr[i][j] = sc.nextInt();
			}
		}
		System.out.println("Entered Matrix Is ::");
		for (int[] is : arr) {
			printMatrix(is);

		}
		System.out.println("After Sorting Matrix Is ::");
		for (int[] is : arr) {
			Arrays.sort(is);
			printMatrix(is);

		}

	}

	public static void printMatrix(int[] is) {
		for (int i : is) {
			System.out.print(i);
			System.out.print("\t");
		}
		System.out.print("\n");

	}

}

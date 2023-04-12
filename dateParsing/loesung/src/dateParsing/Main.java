package dateParsing;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		String[] parts = input.split("-");
		
		String tag = parts[0];
		String monat = parts[1];
		String jahr = parts[2];
		
		System.out.println("Tag: " + tag);
		System.out.println("Monat: " + monat);
		System.out.println("Jahr: " + jahr);
	}
}

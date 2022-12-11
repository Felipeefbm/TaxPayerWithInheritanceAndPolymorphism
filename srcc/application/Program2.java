package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Company;
import entities.Individual;
import entities.TaxPayer;

public class Program2 {

	public static void main(String[] args) {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		List<TaxPayer> listTaxPayer =  new ArrayList<>();
		
		System.out.print("Enter the number of tax payerss: ");
		int n = sc.nextInt();
		
		for(int i = 1; i<=n; i++) {
			System.out.println("TAX PAYER #" + i + " DATA: ");
			System.out.print("Indiviual or Company (i/c)? ");
			char options = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			
			System.out.print("Anual Income: ");
			Double anualIncome = sc.nextDouble();
			
			if(options == 'i') {
				System.out.print("Health expenditures: ");
				Double healthExpenditures = sc.nextDouble();
				listTaxPayer.add(new Individual(name, anualIncome, healthExpenditures));
			}
			else {
				System.out.print("Number of employees: ");
				int quantityEmployees = sc.nextInt();
				listTaxPayer.add(new Company(name,anualIncome, quantityEmployees));
				
			}
			
		}
			
		System.out.println();
		System.out.println("TAXES PAID: ");
		Double totalTaxes = 0.0;
		for (TaxPayer list : listTaxPayer) {
			System.out.println(list.getName() + ": $" + String.format("%.2f", list.tax()));
			totalTaxes += list.tax();
		}
		
		System.out.println();
		System.out.println("TOTAL TAXES: $" + String.format("%.2f",totalTaxes));
			
	
		sc.close();
	}

}

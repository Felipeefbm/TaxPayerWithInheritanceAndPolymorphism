package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		List <Product> listProduct = new ArrayList<>();
		
		SimpleDateFormat sdf1 = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.print("Enter the number of product: ");
		int n = sc.nextInt();
		
		for (int i = 1; i <= n; i++) {
			System.out.println("Product #"+ i + " data: ");
			System.out.print("Common, used or imported (c/u/i)? ");
			char options = sc.next().charAt(0);
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Price: ");
			Double price = sc.nextDouble();
			
			if (options == 'c') {
				listProduct.add(new Product(name, price));
			}
			
			if (options == 'u') {
				System.out.print("Manufacture date (DD/MM/YYYY): ");
				Date variableDate = sdf1.parse(sc.next());
				listProduct.add(new UsedProduct(name, price, variableDate));
			}
			
			if(options == 'i') {
				System.out.print("Customs fee : ");
				double customsFee = sc.nextDouble();
				listProduct.add(new ImportedProduct(name, price, customsFee));
			}
		}
			
			
			
		System.out.println("PRICE TAGS: ");
		for(Product c : listProduct) {
			System.out.println(c.priceTag());
		}
			
		
		
		sc.close();
	}

}

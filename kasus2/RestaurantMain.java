package kasus2;

/**
*@author Mentari Ayu Alysia Sudrajat
*@version 1.0
*@since 2022-03-12
*/

import java.util.Scanner;

public class RestaurantMain {
	public static void main(String[] args) {
		
		Restaurant menu = new Restaurant();
		menu.tambahMenuMakanan("B", "Bala-Bala", 1_000, 20);
		Restaurant.nextID();
		menu.tambahMenuMakanan("G", "Gehu", 1_000, 20);
		Restaurant.nextID();
		menu.tambahMenuMakanan("T", "Tahu", 1_000, 0);
		Restaurant.nextID();
		menu.tambahMenuMakanan("M", "Molen", 1_000, 20);
		
		System.out.println("\t= = = = = = Menu = = = = = =");
		menu.tampilMenuMakanan();
		
		Scanner input = new Scanner(System.in);
		String foodCode;
		double totalPrice=0;
		int quantity;
		int ya;
		
		System.out.print("\n\nMau Pesan Makanan ?\nKlik '1' untuk memesan : ");
		ya = input.nextInt();
		
		if(ya == 1) {
			System.out.println("\nSilakan pilih makanan");
			System.out.println("\nuntuk memesan, silakan masukkan kode makanan!");
			System.out.print("Mau Makan Apa?\t: ");
			foodCode = input.next();
			System.out.print("Berapa\t\t: ");
			quantity = input.nextInt();
			menu.orderFood(foodCode, quantity);
			totalPrice += menu.hitungHarga(foodCode, quantity);
			menu.Summary(foodCode, quantity, totalPrice);
		
			menu.reduceStok(foodCode, quantity);
			System.out.println("\nStok Menu saat ini : ");
			menu.tampilMenuMakanan();
		}
			
	}
}
package kasus2;

public class Restaurant {
	public String[] order;
	public String[] nama_makanan;
	public double[] harga_makanan;
	public int[] stok;
	public static byte id=0;
	public byte berhasil = 0;
	makanan[] menu = new makanan[4];
	
	public Restaurant(){
		order = new String[10];
		nama_makanan = new String[10];
		harga_makanan = new double[10];
		stok = new int[10];
	}
	
	public void tambahMenuMakanan(String menuCode, String nama, double harga, int stok){
		menu[id] = new makanan(menuCode, nama, harga, stok);
	}
	
	public void tampilMenuMakanan(){
		int j=1;
		for(int i=0 ; i<=id ; i++){
			if(!isOutOfStock(i)){
				System.out.println("\t" + menu[i].getOrder() + " " + menu[i].getNama_makanan() 
						+ "[" + menu[i].getStok() + "]" + "\tRp. " + menu[i].getHarga_makanan());
			}
		}
	}
	
	public boolean isOutOfStock(int id){ //memeriksa ketersediaan stok, apakah habis atau belum
		if(menu[id].getStok() == 0){
			return true;
		} else {
			return false;
		}
	}
	
	public static void nextID(){
		id++;
	}
	
	public void orderFood(String menuCode, int jumlah){
		int id_temp = -1;
		for(int i=0 ; i<=id ; i++){
			if(menuCode.compareTo(menu[i].getOrder())==0){
				id_temp = 1;
			}
		}
		
		if(id_temp == -1){
			System.out.println("Menu yang dipesan tidak tersedia");
		}
		else if (menu[id_temp].getStok() < jumlah){ //output jika pemesanan lebih dari stok yang tersedia
			System.out.println("\nPemesanan gagal karena melebihi stok dari menu");
		}
		else {
			System.out.println("\nSip! Pemesanan Berhasil!"); //output jika pemesanan berhasil (tidak melebihi stok)
			berhasil = 1;
		}
	}
	
	public double hitungHarga(String menuCode, int jumlah){ //untuk menghitung total harga
		double totalHarga = 0 ;
		int id_temp = -1;
		for(int i=0; i<=id ; i++){
			if (menuCode.compareTo(menu[i].getOrder()) == 0){
				id_temp = i;
			}
		}
		if(id_temp != -1){
			totalHarga = menu[id_temp].getHarga_makanan()*jumlah;
		}
		
		return totalHarga;
	}
	
	
	public void Summary(String menuCode, int jumlah, double totalHarga){ //untuk menampilkan rincian pesanan
		if(berhasil == 1) {
			System.out.println("\n\t= = = =  Rincian Pesanan = = = = ");
			System.out.print("Makanan \t\t\t: ");
			for(int i=0 ; i<=id ; i++){
				if (menuCode.compareTo(menu[i].getOrder()) == 0){
					System.out.println(menu[i].getNama_makanan());
				}
			}
			System.out.println("Jumlah \t\t\t\t: " + jumlah);
			System.out.println("Total Harga yang Harus Dibayar \t: " + totalHarga);
			}
		}
	public void reduceStok(String menuCode, int jumlah) {//untuk menghitung ketersediaan stok setelah pemesanan
		int id_temp = -1;
		for(int i=0 ; i<=id ; i++){
			if (menuCode.compareTo(menu[i].getOrder()) == 0){
				if(berhasil == 1) {
					menu[i].setStok(menu[i].getStok()-jumlah);
				}
			}
		}
	}
	
	
}

class makanan{ //class baru
	private String order;
	private String nama_makanan;
	private double harga_makanan;
	private int stok;
	
	public makanan(String menuCode, String nama, double harga, int stock){
		order = menuCode;
		nama_makanan = nama;
		harga_makanan = harga;
		stok = stock;
	}

	public String getnama() {
		return null;
	}

	public String getOrder() {
		return order;
	}

	public void setOrder(String order) {
		this.order = order;
	}

	public String getNama_makanan() {
		return nama_makanan;
	}

	public void setNama_makanan(String nama_makanan) {
		this.nama_makanan = nama_makanan;
	}

	public double getHarga_makanan() {
		return harga_makanan;
	}

	public void setHarga_makanan(double harga_makanan) {
		this.harga_makanan = harga_makanan;
	}

	public int getStok() {
		return stok;
	}

	public void setStok(int stok) {
		this.stok = stok;
	}
	
	
}
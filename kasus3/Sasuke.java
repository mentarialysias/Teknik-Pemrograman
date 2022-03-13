package kasus3;

public class Sasuke extends Itachi { 
	String Dojutsu = "Sharingan";
	
	void printDojutsu() {
		super.printDojutsu(); 
		System.out.println(this.Dojutsu);
	}
}

package main;

import BD.ExtraccionBD;
import interfazGrafica.Login;

public class Main {
	
	
	public static void main(String[] args) {
		ExtraccionBD.preparaDatos();
		new Login();
		
	}
	
}

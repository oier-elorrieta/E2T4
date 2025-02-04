package controlador;


import java.util.ArrayList;
import vista.*;
import java.util.concurrent.CountDownLatch;

import Modelo.Agentzia;

public class Main {
	public static void main(String[] args) {
		boolean vuelta = true;
		ArrayList<Agentzia> listaAgencias = new ArrayList<>();
		Metodos.añadirAgencias(listaAgencias);
		System.out.println(listaAgencias.get(0));
		LoginPantaila.pantLogin(listaAgencias);
		do {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			vuelta = LoginPantaila.checkVuelta();
		}while (vuelta == true);
		
	}
}

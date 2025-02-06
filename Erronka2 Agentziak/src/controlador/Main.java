package controlador;

import java.util.ArrayList;
import vista.*;
import java.util.concurrent.CountDownLatch;

import ModeloDAO.*;
import ModeloPOJOS.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Agentzia> zerrendaAgentziak = new ArrayList<>();
		ArrayList<Bidaia> zerrendaBidaiak = new ArrayList<>();
		ArrayList<Zerbitzua> zerrendaZerbitzuak = new ArrayList<>();
		BidaiaDAO.bidaiaKargatu(zerrendaBidaiak, zerrendaZerbitzuak);
		AgentziaDAO.agentziaKargatu(zerrendaAgentziak, zerrendaBidaiak);
		LoginPantaila.pantLogin(zerrendaAgentziak);
		for (int i = 0; i < zerrendaAgentziak.size(); i++) {
			System.out.println("Elemento " + i + ": " + zerrendaAgentziak.get(i));
		}
	}
}

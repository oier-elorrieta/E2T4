package controlador;

import java.util.ArrayList;
import vista.*;

import ModeloDAO.*;
import ModeloPOJOS.*;

public class Main {
	public static void main(String[] args) {
		ArrayList<Agentzia> zerrendaAgentziak = new ArrayList<>();
		ArrayList<Bidaia> zerrendaBidaiak = new ArrayList<>();
		AgentziaDAO.agentziaKargatu(zerrendaAgentziak, zerrendaBidaiak);
		LoginPantaila.pantLogin(zerrendaAgentziak, zerrendaBidaiak);
	}
}

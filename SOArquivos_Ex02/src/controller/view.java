package controller;

import java.io.IOException;

public class view {

	public static void main(String[] args) throws IOException {
		SteamController ac = new SteamController();
		
		ac.jogadoresAtivos("2020","March",60);
	}
}

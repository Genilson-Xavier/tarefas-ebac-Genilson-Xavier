package br.com.ebac;

import com.google.gson.Gson;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());

        // Usando gson adicionado no pom para saida de mapa em json
        Map<Integer, String> colours = new HashMap<>();
        colours.put(1, "blue");
        colours.put(2, "yellow");
        colours.put(3, "green");

        Gson gson = new Gson();

        String output = gson.toJson(colours);

        logger.log(Level.INFO, output);
    }

}
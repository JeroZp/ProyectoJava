import java.util.*;
import java.io.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenido! Elije la opción que deseas ejecutar");
        System.out.println("1. Buscar por número");
        Scanner sc = new Scanner(System.in);
        int option = sc.nextInt();

        if (option == 1) {
            Main.buscarNumero();
        }
    }
    
    public static ArrayList <String[]> datos = new ArrayList<>();
    
    private static void buscarNumero() {
        if (Main.datos.isEmpty()) { Main.leerCSV(); }
        
        System.out.println("-¿Sobre cuál número quieres buscar información?");
        int p = Main.datos.size();
        Scanner sc = new Scanner(System.in);
        String num = sc.next();
        System.out.println("Los resultados del número " + num + ":");

        for (int i = 0; i < p; i++) {
            if (num.compareTo(Main.datos.get(i)[0]) == 0) {
                System.out.println(Main.datos.get(i)[1]);
            } else {
                System.out.println("No se encontró nada al respecto");
            }
        }
    }
    
    public static void leerCSV() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
            reader.readLine();
            String dato;
            while ((dato = reader.readLine()) != null) {
                dato = dato.toLowerCase(Locale.ROOT);
                dato = dato.replace(";;", " ");
                String[] parts = dato.split(":");
                Main.datos.add(parts);
            }

            System.out.println("CSV leído con éxito, ya puede ser usado!");

        } catch (IOException e) { e.printStackTrace(); }
    }
}

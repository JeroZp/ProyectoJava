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
    private static void buscarNumero() {
        if (Main.metadata.isEmpty()) {
            Main.leerCSV();
        }

        System.out.println("-¿Sobre cuál número quieres buscar información?");
        int p = Main.metadata.size();
        String num = sc.next();
        System.out.println("Los resultados del número " + num + ":");

        for (int i = 0; i < p; i++) {
            if (num.compareTo(Main.metadata.get(i)[0]) == 0) {
                System.out.println(Main.metadata.get(i)[1]);
            }
        }
    }
    public static Scanner sc = new Scanner(System.in);
    public static ArrayList <String[]> metadata = new ArrayList<>();
    public static void leerCSV() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("data.csv"));
            reader.readLine();
            String dato;
            while ((dato = reader.readLine()) != null) {
                dato = dato.toLowerCase(Locale.ROOT);
                dato = dato.replace(";;", " ");
                String[] parts = dato.split(":");
                Main.metadata.add(parts);
            }

            System.out.println("CSV leído con éxito, ya puede ser usado!");

        } catch (IOException e) { e.printStackTrace(); }
    }
}
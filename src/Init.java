import java.util.InputMismatchException;
import java.util.Scanner;

import controllers.FinderAPI;
import controllers.JsonGenerator;
import models.Movie;

public class Init {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingresar id de película");
        try {
            var id = sc.nextInt();
            sc.nextLine();
            while(id != 0) {
                Movie movie = FinderAPI.findMovie(id);
                JsonGenerator.createJson(movie);
                System.out.println("Ingresar otro id de película");
                System.out.println("Sino presiona el número 0 para salir");
                id = sc.nextInt();
                sc.nextLine();
            }
        }catch(InputMismatchException e){
            System.out.println("Numero no encontrado ");
        }
        sc.close();
    }
}

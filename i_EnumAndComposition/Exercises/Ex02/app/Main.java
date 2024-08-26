package i_EnumAndComposition.Exercises.Ex02.app;

import i_EnumAndComposition.Exercises.Ex02.entities.Post;

import java.util.Scanner;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        
        Locale.setDefault(Locale.US);
        
        Scanner sc = new Scanner(System.in);
        
        Post p1 = new Post("Just a test", "Just a normal test");

        System.out.println(p1);

        p1.addComment("WOOOW");
        p1.addComment("Nice post");

        for (int c = 0 ; c < 20 ; c++) {
            p1.likePost();
        }

        System.out.println(p1);
        
        sc.close();
    }
}


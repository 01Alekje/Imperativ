import java.util.Scanner;

import static java.lang.System.in;
import static java.lang.System.out;

/*
 *  Using class objects to represent heroes
 *  https://en.wikipedia.org/wiki/Gladiators_(1992_UK_TV_series)
 *
 * See:
 * - ex5classes
 */
public class Ex6ClassObjects {

    public static void main(String[] args) {
        new Ex6ClassObjects().program();
    }

    final Scanner sc = new Scanner(in);

    void program() {
        // -------- Input ------------
        Hero hero1 = askForHero(1);
        Hero hero2 = askForHero(2);

        // ------- Output --------------
        compare(hero1, hero2);

    }

    // ------ The class to use  -----------
    // A class for objects that describes a Hero
    class Hero {
        String name;
        int strength;

        public Hero(String n, int s) {
            name = n;
            strength = s;
        }
    }

    Hero askForHero(int i) {
        out.print("What's the name of hero " + i + "? > ");
        String name = sc.next();
        out.print("How strong is " + name + "? > ");
        int strength = sc.nextInt();
        return new Hero(name, strength);
    }

    void compare(Hero h1, Hero h2) {
        String message;

        if (h1.strength > h2.strength) {
            message = h2.name + " is stronger";
        } else if (h2.strength > h1.strength) {
            message = h2.name + " is stronger";
        } else {
            message = "They are equally strong";
        }

        out.print(message);
    }

}

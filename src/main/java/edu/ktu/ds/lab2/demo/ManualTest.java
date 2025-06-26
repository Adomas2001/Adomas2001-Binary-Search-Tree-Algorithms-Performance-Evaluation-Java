package edu.ktu.ds.lab2.demo;


import edu.ktu.ds.lab2.utils.*;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.Locale;

/*
 * Bst or Set testing without Gui
 * It shows a BST tree distribution beautifully on console when working with IntelliJ
 * If it doesn't look beautiful, you should change the settings by :
 *      FIle -> Settings -> Editor -> File Encodings -> Global encoding to change to UTF-8
 *
 */
public class ManualTest {

    static Car[] cars;
    static ParsableSortedSet<Car> cSeries = new ParsableBstSet<>(Car::new, Car.byPrice);

    public static void main(String[] args) throws CloneNotSupportedException {
        Locale.setDefault(Locale.US); // We unify number formats
        executeTest();
    }

    public static void executeTest() throws CloneNotSupportedException {
        Car c1 = new Car("Renault", "Laguna", 1997, 50000, 1700);
        Car c2 = new Car.Builder()
                .make("Renault")
                .model("Megane")
                .year(2001)
                .mileage(20000)
                .price(3500)
                .build();
        Car c3 = new Car.Builder().buildRandom();
        Car c4 = new Car("Renault Laguna 2001 115900 700");
        Car c5 = new Car("Renault Megane 1946 365100 9500");
        Car c6 = new Car("Honda   Civic  2001  36400 80.3");
        Car c7 = new Car("Renault Laguna 2001 115900 7500");
        Car c8 = new Car("Renault Megane 1946 365100 950");
        Car c9 = new Car("Honda   Civic  2007  36400 850.3");

        Car[] carsArray = {c9, c7, c8, c5, c1, c6};

        Ks.oun("Auto Set/Bst:");
        ParsableSortedSet<Car> carsSet = new ParsableBstSet<>(Car::new);

        for (Car c : carsArray) {
            carsSet.add(c);
            Ks.oun("Filling Set/Bst " + c + ". Its size: " + carsSet.size());
        }
        Ks.oun("");
        Ks.oun(carsSet.toVisualizedString(""));

        ParsableSortedSet<Car> carsSet2 = new ParsableBstSet<>(Car::new);
        carsSet2.add(c7);
        carsSet2.add(c4);
        carsSet2.add(c2);
        carsSet2.add(c3);

        carsSet2.add(c6);

        ParsableSortedSet<Car> carsSet3 = new ParsableBstSet<>(Car::new);
        carsSet3.add(c7);
        carsSet3.add(c4);
        carsSet3.add(c2);





        Ks.oun("Supplemented copy of the car kit:");
        Ks.oun(carsSet2.toVisualizedString(""));

        c9.setMileage(10000);

        Ks.oun("Original:");
        Ks.ounn(carsSet2.toVisualizedString(""));

        //Headset
        Set<Car> Headset = carsSet2.headSet(c6);
        Ks.oun("Original Headset:");
        Ks.ounn(Headset.toVisualizedString(""));

        //subset
        Set<Car> subset1 = carsSet2.subSet(c7,c3);
        Ks.oun("Original subset:");
        Ks.ounn(subset1.toVisualizedString(""));

        //Tailset
        Set<Car> tailset = carsSet2.tailSet(c4);
        Ks.oun("Original tailset:");
        Ks.ounn(tailset.toVisualizedString(" "));


        //Containsall
        Ks.oun("to check if carset3 is subset of carset2");
       boolean tf= carsSet2.containsAll(carsSet3);
       if(tf)
       {
           Ks.oun("The set is a subset of the original set");

       }
       else Ks.oun("The set is not subset");

       //retainall
        Ks.oun("Retainall");
        carsSet3.retainAll(carsSet2);
       Ks.oun(carsSet3.toVisualizedString(""));






        Ks.oun("Do the elements exist in the set/bst?");
        for (Car c : carsArray) {
            Ks.oun(c + ": " + carsSet.contains(c));
        }
        Ks.oun(c2 + ": " + carsSet.contains(c2));
        Ks.oun(c3 + ": " + carsSet.contains(c3));
        Ks.oun(c4 + ": " + carsSet.contains(c4));
        Ks.oun("");

        Ks.oun("Do the elements exist in the copy of the set/bst?");
        for (Car c : carsArray) {
            Ks.oun(c + ": " + carsSet2.contains(c));
        }
        Ks.oun(c2 + ": " + carsSet2.contains(c2));
        Ks.oun(c3 + ": " + carsSet2.contains(c3));
        Ks.oun(c4 + ": " + carsSet2.contains(c4));
        Ks.oun("");

        Ks.oun("Car set/bst with iterator:");
        Ks.oun("");
        for (Car c : carsSet) {
            Ks.oun(c);
        }
        Ks.oun("");
        Ks.oun("Car set in AVL-tree:");
        ParsableSortedSet<Car> carsSetAvl = new ParsableAvlSet<>(Car::new);
        for (Car c : carsArray) {
            carsSetAvl.add(c);
        }
        Ks.ounn(carsSetAvl.toVisualizedString(""));

        Ks.oun("Car set/bst with iterator:");
        Ks.oun("");
        for (Car c : carsSetAvl) {
            Ks.oun(c);
        }

        Ks.oun("");
        Ks.oun("Car set with reverse iterator:");
        Ks.oun("");
        Iterator<Car> iter = carsSetAvl.descendingIterator();
        while (iter.hasNext()) {
            Ks.oun(iter.next());
        }

        Ks.oun("");
        Ks.oun("Car set toString () method: ");
        Ks.ounn(carsSetAvl);

        // We clean and form sets by reading from a file
        carsSet.clear();
        carsSetAvl.clear();

        Ks.oun("");
        Ks.oun("Car set in BS-tree:");
        carsSet.load("data\\ban.txt");
        Ks.ounn(carsSet.toVisualizedString(""));
        Ks.oun("Find out why the tree only grew in one direction.");

        Ks.oun("");
        Ks.oun("Car set in AVL-tree:");
        carsSetAvl.load("data\\ban.txt");
        Ks.ounn(carsSetAvl.toVisualizedString(""));

        Set<String> carsSet4 = CarMarket.duplicateCarMakes(carsArray);
        Ks.oun("Duplicate car brands:\n" + carsSet4.toString());

        Set<String> carsSet5 = CarMarket.uniqueCarModels(carsArray);
        Ks.oun("Unique car models:\n" + carsSet5.toString());
    }

    static ParsableSortedSet<Car> generateSet(int kiekis, int generN) {
        cars = new Car[generN];
        for (int i = 0; i < generN; i++) {
            cars[i] = new Car.Builder().buildRandom();
        }
        Collections.shuffle(Arrays.asList(cars));

        cSeries.clear();
        Arrays.stream(cars).limit(kiekis).forEach(cSeries::add);
        return cSeries;
    }
}

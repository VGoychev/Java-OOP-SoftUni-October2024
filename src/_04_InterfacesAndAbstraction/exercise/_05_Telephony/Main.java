package _04_InterfacesAndAbstraction.exercise._05_Telephony;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] phoneNumbers = scanner.nextLine().split("\\s+");
        String[] urls = scanner.nextLine().split("\\s+");
        List<String> numbers = new ArrayList<>(Arrays.asList(phoneNumbers));
        List<String> sites = new ArrayList<>(Arrays.asList(urls));

        Smartphone smartphone = new Smartphone(numbers, sites);

        System.out.println(smartphone.call());
        System.out.println(smartphone.browse());
    }
}

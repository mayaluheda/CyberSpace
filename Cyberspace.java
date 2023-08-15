/**
 * The Cyberspace class maintains a collection of Webpage objects
 * 
 * @author Maya Lu-Heda
 * @version 10/20/22
 */

import java.util.Scanner;
import java.io.*;

public class Cyberspace {

    // Instance variables
    private Webpage[] webpages;
    private final int MAX = 10;
    private int count;

    /**
     * Constructor for Cyberspace
     */
    public Cyberspace() {
        webpages = new Webpage[MAX];
        count = 0;
    }

    /**
     * Accessor for the number of Webpages
     * @return the number of Webpages
     */
    public int getCount() {
        return count;
    }

    /**
     * Reset the number of Webpages to zero
     */
    public void resetCount() {
        count = 0;
    }

    /**
     * Adds a Webpage to the collection
     * @param the Webpage to be added
     */
    public void addWebpage(Webpage webpage) {
        if (count < MAX) {
            webpages[count] = webpage;
            count++;
        }
        else {
            System.out.println("Not enough storage for " + webpage.getURL() + "!");
        }
    }

    /**
     * Reads user input URLs from the keyboard and adds 
     * the corresponding Webpages to the collection
     */
    public void readFromKeyboard() {
        Scanner scan = new Scanner(System.in);
        String url = scan.nextLine();
        while (!url.equals("q")) {
            addWebpage(Webpage.readAndCreateWebpage(url));
            url = scan.nextLine();
        }
        scan.close();
    }

    /**
     * Reads URLs listen one-per-line from input file and adds
     * the corresponding (to each URL) Webpages to the collection
     */
    public void readFromFile(String fileName) {
        try {
            Scanner scan = new Scanner(new File(fileName));
            while (scan.hasNext()) {
                String url = scan.nextLine();
                addWebpage(Webpage.readAndCreateWebpage(url));
            }
        } catch (FileNotFoundException e){
            System.out.println(e);
        }
    }

    /**
     * Finds the largest (longest html code) webpage in the collection
     * @return the largest webpage
     */
    public Webpage findLargestWebpage() {
        if (count == 0) {
            return null;
        }

        Webpage largest = webpages[0];
        for (int i = 1; i < count; i++) {
            if (webpages[i].compareTo(largest) == 1) {
                largest = webpages[i];
            }
        }
        return largest;
    }

    /** 
     * toString() method for Cyberspace
     * @return a String representation of a collection of webpages
     */
    public String toString() {
        String s = "*********************************************";
        s += "\nOn my way to Cyberspace and beyond!";
        s += "\nMy current visits: ";
        s += "\n\nResults from visiting " + count + " pages:";
        s += "\n#lines\tUniversal Resource Locator (URL)";

        if (count == 0) {
            s += "\n>>> Largest page is " + findLargestWebpage() + "\n";
            return s;
        }

        for (int i = 0; i < count; i++) {
            s += "\n" + webpages[i];
        }
        s += "\n>>> Largest page is " + findLargestWebpage().getNumLines() 
        + ":\t " + findLargestWebpage().getURL() + "\n";
        return s;
    }

    /**
     * The main method for testing
     * @param args the command-line arguments
     */
    public static void main(String[] args) {
        Cyberspace cs = new Cyberspace();

        // Empty Cyberspace
        System.out.println(cs); // Expected: Largest = null

        // File input
        cs.readFromFile("myURLs.txt");
        System.out.println(cs); // Expected: 10 pages, Largest = https://www.wellesley.edu

        cs.resetCount();

        // Command-line arguments
        if (args.length > 0) {
            cs.readFromFile(args[0]);
        }
        // Keyboard input
        else {
            cs.readFromKeyboard();
        }
        System.out.println(cs);
    }
}
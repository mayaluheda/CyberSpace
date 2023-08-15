import java.util.*;
import java.io.*;
import java.net.URL;

/**
 * The Webpage class represents an online website
 *
 * @author Maya Lu-Heda 
 * @version 10-18-22
 */
public class Webpage
{
    // Instance variables
    private String url;
    private int numLines;

    /**
     * Constructor for objects of class Webpage
     * @param website the url of the webpage
     */
    public Webpage(String website, int numLines)
    {
        // initialise instance variables
        url = website;
        this.numLines = numLines;
    }
    
    /**
     * Reads and creates a Webpage with given a URL address as a string
     * @param link URL address input to be assigned to a Webpage
     */
    public static Webpage readAndCreateWebpage(String link){
        int numLines = 0;
    	// Read number of lines on URL linked page
        try{
            URL u = new URL(link);
            Scanner urlScan = new Scanner (u.openStream());
            while(urlScan.hasNext()) {
                urlScan.nextLine();
                numLines++;
            }
        } catch (IOException ex3){
            System.out.println("IO Exception");   
        }
        // Creates and returns Webpage
        Webpage out = new Webpage(link, numLines);
        return out;
    }
    
    /**
     * Compares Webpage objects to find the largest one
     * @param other the other Webpage
     * @return 0 if Webpages have same number of lines
     * 		1 if invoking Webpage has more lines
     *      -1 if invoking Webpage has less lines
     */
    public int compareTo(Webpage other){
        if (this.numLines-other.getNumLines() == 0){
            return 0;
        }
        if (this.numLines-other.getNumLines() > 0){
            return 1;
        }
        return -1;
    }
    
    /**
     * Getter method used to determine number of lines for a Webpage
     * @return the number of lines in html code of the Webpage
     */
    public int getNumLines(){
        return numLines;
    }
    
    /**
     * Setter method used to set number of lines for a Webpage
     * @param nL number of lines to set numLines to
     */
    public void setNumLines(int nL){
        numLines = nL;
    }
    
    /**
     * toString() method for Webpage
     * @return a String representation of Webpage objects (the url, number of lines in html code)
     */
    public String toString(){
        return numLines + "\t" + url; 
    }
    
    /**
     * Getter method used to determine url for a Webpage
     * @return the url of the Webpage
     */
    public String getURL(){
        return url;
    }
    
    /**
     * Setter method used to change url for a Webpage
     * @param website new website to set url to 
     */
    public void setURL(String website){
        url = website;
    }
    /**
     * Testing file, used for testing purposes
     */
    public static void main (String[] args){
        
        Webpage tester1 = readAndCreateWebpage("http://www.bing.com"); //should be 19
        System.out.println(tester1.toString());
        
        Webpage tester2 = readAndCreateWebpage("http://www.google.com"); //should be 19
        System.out.println(tester2.toString());
        
        Webpage tester3 = readAndCreateWebpage("https://www.netflix.com"); //should be 92
        System.out.println(tester3.toString());
        
        Webpage tester4 = readAndCreateWebpage("https://www.cnn.com"); //should be 234
        System.out.println(tester4.toString());
        
        Webpage tester5 = readAndCreateWebpage("http://www.wellesley.edu"); //should be 7
        System.out.println(tester5.toString());
        
        Webpage tester6 = readAndCreateWebpage("https://www.wellesley.edu/cs"); //should be 885
        System.out.println(tester6.toString());
        
        Webpage tester7 = readAndCreateWebpage("http://www.noaa.gov"); //should be 7
        System.out.println(tester7.toString());
        
        Webpage tester8 = readAndCreateWebpage("http://cs.wellesley.edu/~cs230/assignments/assign502/aFewWebPagesForTesting/0lines.txt"); //should be 0
        System.out.println(tester8.toString());
        
        Webpage tester9 = readAndCreateWebpage("http://cs.wellesley.edu/~cs230/assignments/assign502/aFewWebPagesForTesting/1lines.txt"); //should be 1
        System.out.println(tester9.toString());
        
        Webpage tester10 = readAndCreateWebpage("http://cs.wellesley.edu/~cs230/assignments/assign502/aFewWebPagesForTesting/10lines.txt"); //should be 10
        System.out.println(tester10.toString());
    }
}

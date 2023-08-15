/**
 * The CyberspaceApp class reads the input (a set of URLs, 
 * each provided as a String) to the program through
 * command-line arguments or keyboard input.
 *
 * @author Maya Lu-Heda
 * @version 10/21/22
 */
public class CyberspaceApp
{
    public static void main(String [] args){
        Cyberspace cs = new Cyberspace();

        // Command-line arguments
        if (args.length > 0) {
            System.out.println("Command-line arguments:");
            cs.readFromFile(args[0]);
        }
        // Keyboard input
        else {
            System.out.println("Keyboard input:");
            cs.readFromKeyboard();
        }
        System.out.println(cs.toString());
    }
}
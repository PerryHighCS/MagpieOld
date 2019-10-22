import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

/**
 * A simple class to run the Magpie class.
 * @author Laurie White
 * @version April 2012
 */
public class Main
{

    /**
     * Create a Magpie, give it user input, and print its replies.
     */
    public static void main(String[] args) throws FileNotFoundException 
    {
        boolean echo = false;

        // Read from either a specified file or the Standard input
        Scanner in;
        if (args.length == 1) { // If there is a file specified on the command line
            in = new Scanner(new File(args[0])); // Use it
            echo = true;
        }        
        else { // No file - use System.in
            in = new Scanner (System.in);
        }
        
        // Create the Magpie chatbot
        Magpie maggie = new Magpie();
        System.out.println (maggie.getGreeting());

        // Get the first statement from the input
        String statement = in.nextLine();
        
        // Loop getting statements and responding to them until done
        while (!statement.equals("Bye"))
        {            
            // Show the statement if reading from a file
            if (echo) {
                System.out.println("< " + statement);
            }
            
            // Respond to the statement
            System.out.println (maggie.getResponse(statement));
            
            // Get the next statement from the user, quit if there are no more
            if (in.hasNextLine()) {
                statement = in.nextLine();                
            }
            else {
                statement = "Bye";
            }
        }
    }
}

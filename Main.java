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
        if (args.length == 1) {
            in = new Scanner(new File(args[0]));
            echo = true;
        }        
        else {
            in = new Scanner (System.in);
        }
        
        Magpie maggie = new Magpie();
        System.out.println (maggie.getGreeting());

        String statement = in.nextLine();
        while (!statement.equals("Bye"))
        {
            System.out.println (maggie.getResponse(statement));
            
            // Get the next statement from the user, quit if there are no more
            if (in.hasNextLine()) {
                statement = in.nextLine();
            }
            else {
                statement = "Bye";
            }
            
            //
            if (echo) {
                System.out.println(statement);
            }
        }
    }

}

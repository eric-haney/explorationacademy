package org.theexplorationacademy.game.server;

/**
 * The Server class starts a game server on the specified port.
 *
 */
public class Server 
{
    public static void main( String[] args )
    {
        if (args.length != 1)
        {
            printUsage();
        }
        else
        {
            int port = 0;

            try
            {
                port = Integer.parseInt(args[0]);
                if (port < 1 || port > 65535)
                {
                    printUsageWithError("Invalid port: "+args[0]+" (must be 1-65535)");
                }

                System.out.println("Starting game server on port: "+args[0]+".");
            }
            catch (NumberFormatException nfe)
            {
                printUsageWithError("Invalid port: "+args[0]+" (must be an integer)");
            }
        }
    }

    private static void printUsage()
    {
        System.out.println("\nUSAGE: ");
        System.out.println("$ java -jar org-theexplorationacademy-game-server-0.1.jar PORT\n\n");
    }

    private static void printUsageWithError(String message)
    {
        System.out.println("\nERROR: "+message);
        printUsage();
    }
}

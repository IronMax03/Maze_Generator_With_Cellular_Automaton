/**
 * The `Main` class serves as the entry point for the Maze Generator application.
 * It creates an instance of the `mazeGenerator` class, initializes the maze, introduces a delay, and then runs the Cellular Automaton rules to generate a maze.
 *
 * @author Maximilien Notz
 */
public class Main
{
    /**
     * The main method, serving as the entry point for the Maze Generator application.
     *
     * @param args The command-line arguments (not used in this application).
     */
    public static void main(String[] args)
    {
        mazeGenerator mazeGen = new mazeGenerator(100);

        try
        {
            Thread.sleep(4000);
        }
        catch (Exception e)
        {
            System.out.println(e.getLocalizedMessage());
        }

        mazeGen.runRules(50);
    }
}
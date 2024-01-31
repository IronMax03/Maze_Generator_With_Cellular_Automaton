/**
 * The `mazeGenerator` class implements the maze generator using Cellular Automaton (CA) principles inspired by Conway's Game of Life.
 * The generator creates a maze with walls and corridors based on a randomized grid and applies rules to organize the grid into a maze pattern.
 * The class includes methods for running the CA rules, calculating the diagonal and Neumann neighborhoods, and introducing a delay between iterations.
 *
 * @author Maximilien Notz
 */
public class mazeGenerator
{
    /**
     * The maze grid used for generating the maze.
     */
    private Grid maze;

    /**
     * The size of the maze grid.
     */
    private short Size;

    /**
     * The count of generation (iterations) taken by the Cellular Automaton.
     */
    private short generationCount;

    /**
     * Constructor for the `mazeGenerator` class.
     *
     * @param Size The size of the maze grid.
     */
    public mazeGenerator(int Size)
    {
        this.Size = (short)Size;
        this.maze = new Grid(Size, Size, 7, 0);
        this.maze.randomizeMaze();
        this.generationCount = 0;
    }

    /**
     * Runs the Cellular Automaton rules for a specified number of steps.
     *
     * @param n The number of generations to run the rules.
     */
    public void runRules(int n)
    {
        maze.setTitle("Cellular Automaton");
        n += generationCount;
        // revers the chaos
        short DNCount; // diagonal neighborhood count
        short NNCount; // neumann neighborhood count
        for(; generationCount < n; ++generationCount)
        {
            sleep((short) 250);
            for (short x = 1; x < Size - 1; ++x)
            {
                for (short y = 1; y < Size - 1; ++y)
                {
                    DNCount = diagonalNeighborhood(x, y);
                    NNCount = neumannNeighborhood(x, y);

                    if(maze.getAt(x, y))
                    {
                        if (NNCount % 2 == DNCount % 2);
                        else if(DNCount + NNCount >=4 || DNCount > NNCount || DNCount + NNCount == 0)
                        {
                            maze.setAt(x, y, false);
                        }
                    }
                    else
                    {
                        if (DNCount == 4 && NNCount == 3 && generationCount > 10);
                        else if(NNCount > 2 || DNCount == 0 || DNCount + NNCount < 4)
                        {
                            maze.setAt(x, y, true);
                        }
                    }
                }
            }
            maze.update();
        }
    }

    /**
     * Calculates the diagonal neighborhood count for a given cell.
     *
     * @param x The x-coordinate of the cell a short data type.
     * @param y The y-coordinate of the cell a short data type.
     * @return The count of neighboring cells in the diagonal directions.
     */
    public short diagonalNeighborhood(short x, short y)
    {
        short count = 0;
        for (short[] i: new short[][]{{1,1},{-1,-1},{-1,1},{1,-1},})
        {
            if(this.maze.getAt(x + i[0], y + i[1]))
            {
                ++count;
            }
        }
        return count;
    }


    /**
     * Calculates the Neumann neighborhood count for a given cell.
     *
     * @param x The x-coordinate of the cell in a short data type.
     * @param y The y-coordinate of the cell in a short data type.
     * @return The count of neighboring cells in the Neumann directions.
     */
    private short neumannNeighborhood(short x, short y)
    {
        short count = 0;
        for (short[] i: new short[][]{{0,1},{0,-1},{-1,0},{1,0},})
        {
            if(this.maze.getAt(x + i[0], y + i[1]))
            {
                ++count;
            }
        }
        return count;
    }

    /**
     * Introduces a delay for a specified time.
     *
     * @param time The duration of the delay in milliseconds.
     */
    private void sleep(short time)
    {
        try
        {
            Thread.sleep(time);
        }
        catch (InterruptedException ex)
        {
            Thread.currentThread().interrupt();
            System.out.println("/!\\");
        }
    }
}

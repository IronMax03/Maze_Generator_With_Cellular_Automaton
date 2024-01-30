/**
 * @author Maximilien Notz
 */
public class mazeGenerator
{
    private Grid maze;
    private short Size;
    private short stepsCount;
    private short DNCount; // diagonal neighborhood count
    private short NNCount; // neumann neighborhood count

    public mazeGenerator(int Size)
    {
        this.Size = (short)Size;
        this.maze = new Grid(Size, Size, 7, 0);
        this.maze.randomizeMaze();
        this.stepsCount = 0;
    }

    public void runRules(int n)
    {
        maze.setTitle("Cellular Automaton");
        n += stepsCount;
        // revers the chaos
        short DNCount; // diagonal neighborhood count
        short NNCount; // neumann neighborhood count
        for(; stepsCount < n; ++stepsCount)
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
                        if (DNCount == 4 && NNCount == 3 && stepsCount > 10);
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

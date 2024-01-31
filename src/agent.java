/**
 * The `agent` class represents an agent with a position, signature, and the ability to navigate a maze.
 * The agent uses a stack to store positions and flags to inspect and modify the maze.
 *
 * @author Maximilien Notz
 */
public class agent
{
    /**
     * The `vector2D` class represents a 2-dimensional vector with components x and y.
     */
    class vector2D
    {
        /** The x-component of the vector. */
        public int x;

        /** The y-component of the vector. */
        public int y;

        /**
         * Constructs a new `vector2D` instance by copying the components of another vector.
         *
         * @param vec The vector to copy.
         */
        public vector2D(vector2D vec)
        {
            this.x = vec.x;
            this.y = vec.y;
        }

        /**
         * Constructs a new `vector2D` instance with specified x and y components.
         *
         * @param x The x-component of the vector.
         * @param y The y-component of the vector.
         */
        public vector2D(int x, int y)
        {
            this.x = x;
            this.y = y;
        }

        /**
         * Sets the position of the vector by copying the components of another vector.
         *
         * @param vec The vector with the new components.
         */
        public void setPosition(vector2D vec)
        {
            this.x = x;
            this.y = y;
        }

        /**
         * Sets the position of the vector with specified x and y components.
         *
         * @param x The new x-component of the vector.
         * @param y The new y-component of the vector.
         */
        public void setPosition(int x, int y)
        {
            this.x = x;
            this.y = y;
        }
    }

    /** The position of the agent. */
    vector2D position;

    /** The signature assigned to the agent. */
    private short signature;

    /** A stack to store the agent's map. */
    private Stack agentMap = new Stack<vector2D>();

    /** A stack to store points on the map. */
    private Stack pointsMap = new Stack<vector2D>();

    /** Static array to store flags. */
    private static short[][] flags;

    /** Static reference to the maze. Use to get inputs from the maze */
    private static Grid maze;

    /**
     * Constructs an agent with a specified signature, x and y coordinates, and a reference to the maze.
     *
     * @param signature The signature assigned to the agent.
     * @param x         The x-coordinate of the agent's initial position.
     * @param y         The y-coordinate of the agent's initial position.
     * @param maze      The maze in which the agent navigates.
     */
    public agent(short signature, int x, int y, Grid maze)
    {
        this.signature = signature;
        this.position = new vector2D(x, y);
        this.maze = maze;
    }

    /**
     * Constructs an agent with a specified signature, x and y coordinates.
     *
     * @param signature The signature assigned to the agent.
     * @param x         The x-coordinate of the agent's initial position.
     * @param y         The y-coordinate of the agent's initial position.
     */
    public agent(short signature, int x, int y)
    {
        this.signature = signature;
        this.position = new vector2D(x, y);
    }

    /**
     * Initializes the flags array based on the maze, marking walls as -1 and open paths as 0.
     */
    public static void initFlag()
    {
        flags = new short[maze.sizeX][maze.sizeY];
        for(int i = 0; i < maze.sizeX; ++i)
        {
            for(int j = 0; j < maze.sizeY; ++j)
            {
                if(maze.getAt(i, j)) flags[i][j] = 0;
                else  flags[i][j] = -1;
            }
        }
    }

    /**
     * Looks around the agent's current position and adds neighboring open positions to the agentMap.
     *
     * @param maze The maze to look around.
     */
    private void lookAround(Grid maze)
    {
        for (short[] i: new short[][]{{0,1},{0,-1},{-1,0},{1,0}})
        {
            if(position.x + i[0] > maze.sizeX && position.y + i[1] > maze.sizeY)
            {
                if (maze.getAt(position.x + i[0], position.y + i[1])) {
                    agentMap.push(new vector2D(position));
                }
            }
        }
    }

    /**
     * Inspects the maze, modifying open paths based on flags and agentMap.
     *
     * @param maze The maze to inspect.
     * @return True if modifications are made to the maze, false otherwise.
     */
    public boolean inspectMaze(Grid maze)
    {
        boolean temp = false;
        while (!agentMap.isEmpty())
        {
            lookAround(maze);
            flags[position.x][position.y] = signature;
            position.setPosition((vector2D) agentMap.pop());
        }

        while(!pointsMap.isEmpty())
        {
            position = (vector2D) pointsMap.pop();
            for(short[] vec: new short[][]{{0,1},{0,-1},{-1,0},{1,0}})
            {
                if(  flags[position.x + vec[0] * 2][position.y + vec[1] * 2] != -1 &&
                     flags[position.x + vec[0] * 2][position.y + vec[1] * 2] != signature)
                {
                    temp = true;
                    maze.setAt(position.x + vec[0],position.y + vec[1], false);
                    break;
                }
            }
        }
        if (temp) System.out.println("out");
        return temp;
    }
}
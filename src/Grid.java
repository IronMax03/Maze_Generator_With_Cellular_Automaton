import java.awt.*;
import java.util.Random;
import javax.swing.*;
/**
 * @author Maximilien Notz
 */
public class Grid extends JFrame
{
    private  int CellSize, GridThikness;

    public int sizeX, sizeY;
    private boolean[][] array;
    
    public Grid(int sizeX, int sizeY, int CellSize, int GridThikness)
    {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.CellSize = CellSize;
        this.GridThikness = GridThikness;
        this.array = new boolean[sizeX][sizeY];
        
        for(int x = 0; x < sizeX; ++x)
        {
            for(int y = 0; y < sizeY; ++y)
            {
                this.array[x][y] = false;
            }            
        }
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800 + CellSize + 10, 800 + CellSize + 10);
        setVisible(true);
        setBackground(Color.gray);
    }
    
    public void paint(Graphics graph)
    {
        for(int row = 0; row < this.sizeY; ++row)
        {
            for(int col = 0; col < this.sizeX; ++col)
            {
                if(array[row][col])
                {
                    graph.setColor(Color.white);
                }
                else
                {
                    graph.setColor(Color.black);
                }
                 graph.fillRect(col * CellSize + CellSize+10, (this.sizeY-row) * CellSize+CellSize+35, CellSize - GridThikness, CellSize - GridThikness);
            }
        }
    }
    
    public void update()
    {
        repaint();
    }
    
    public void setAt(int x, int y, boolean var)
    {
        this.array[x][y] = var;
    }
    
    public boolean getAt(int x, int y)
    {
        return this.array[x][y];
    }

    public void randomizeMaze()
    {
        Random rand = new Random();

        this.array[0][sizeY - 2] = true;
        this.array[sizeX-2][0] = true;

        for (short x = 1; x < sizeX-1; ++x)
        {
            for (short y = 1; y < sizeY-1; ++y)
            {
                this.array[x][y] = rand.nextBoolean();
            }
        }
    }
}

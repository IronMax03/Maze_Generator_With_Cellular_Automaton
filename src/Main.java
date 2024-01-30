/**
 * @author Maximilien Notz
 */
public class Main
{
    public static void main(String[] args)
    {
        runTestCases();
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


    private static void runTestCases()
    {
        //test cases Stack
        Stack MyStack = new Stack<Integer>();
        assert(MyStack.isEmpty());
        MyStack.push(1);
        assert(!MyStack.isEmpty());
        assert((Integer) MyStack.pop() == 1);
        assert(MyStack.isEmpty());

        System.out.println("All tests cases passed");
    }
}
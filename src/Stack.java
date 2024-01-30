/**
 * @author Maximilien Notz
 */
public class Stack <Type>
{
    class Node <Type>
    {
        public Type data;
        public Node nextNode;

        public Node(Type data)
        {
            this.data = data;
            this.nextNode = null;
        }

        public Node(Type data, Node nextNode)
        {
            this.data = data;
            this.nextNode = nextNode;
        }
    }
    private Node head;

    public Stack()
    {
        this.head = null;
    }
    
    public void push(Type data)
    {
        this.head = new Node(data, this.head);
    }
    
    public Type pop()
    {
        Type temp = (Type)head.data;
        this.head = head.nextNode;
        return (Type)temp;
    }
    
    public boolean isEmpty()
    {
        return this.head == null;
    }
}

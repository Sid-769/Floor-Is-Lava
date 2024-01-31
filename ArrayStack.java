public class ArrayStack<T> implements StackADT<T> {
    private static final int DEFAULT_CAPACITY = 10;  

    private T[] array;  
    private int top;   

    // Constructor to initialize the stack
    public ArrayStack() {
        array = (T[]) new Object[DEFAULT_CAPACITY];  // Initialize array with default capacity
        top = -1;   // Initialize top as -1 indicating stack is empty
    }

    // Method to add an element to the top of the stack
    public void push(T element) {
        array[++top] = element;  // Increment top and add the element
        // Check if stack is 75% full, expand capacity if true
        if ((double)(top + 1) / array.length >= 0.75) {
            expandCapacity();
        }
    }

    // Method to remove and return the top element of the stack
    public T pop() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is empty");  // Throw exception if stack is empty
        }

        T element = array[top--];  // Retrieve top element and decrement top

        // Shrink capacity if stack is less than 22.5% full and capacity is at least 25
        if ((double)top / array.length <= 0.225 && array.length >= 25) {
            shrinkCapacity();
        }
        // Additional shrink capacity condition - seems redundant
        if ((double)top / array.length > 0.775 && array.length >= 25) {
            shrinkCapacity();
        }

        return element;
    }

    // Method to get the top element of the stack without removing it
    public T peek() throws StackException {
        if (isEmpty()) {
            throw new StackException("Stack is empty");  // Throw exception if stack is empty
        }

        return array[top];
    }

    
    public boolean isEmpty() {
        return top == -1;
    }

    
    public int size() {
        return top + 1;
    }

    // Clear the stack and reset to default capacity
    public void clear() {
        array = (T[]) new Object[DEFAULT_CAPACITY];
        top = -1;
    }

    
    public int getCapacity() {
        return array.length;
    }

    
    public int getTop() {
        return top;
    }

    // Generate a string representation of the stack
    public String toString() {
        if (isEmpty()) {
            return "Empty stack.";
        }

        StringBuilder result = new StringBuilder("Stack: ");
        for (int i = top; i >= 0; i--) {
            result.append(array[i]);
            if (i > 0) {
                result.append(", ");
            } else {
                result.append(".");
            }
        }
        return result.toString();
    }

    // Private method to expand the capacity of the stack
    private void expandCapacity() {
        T[] newArray = (T[]) new Object[array.length + 10];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    // Private method to shrink the capacity of the stack
    private void shrinkCapacity() {
        T[] newArray = (T[]) new Object[array.length - 10];
        System.arraycopy(array, 0, newArray, 0, newArray.length);
        array = newArray;
    }
}
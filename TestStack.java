
public class TestStack {

	public static void main(String[] args) {

		ArrayStack<String> sStack = new ArrayStack<String>();
		ArrayStack<Integer> iStack = new ArrayStack<Integer>();

		if (sStack.isEmpty() && sStack.size() == 0 && sStack.getTop() == -1) {
			System.out.println("TestStack - Test 0 Passed");
		} else {
			System.out.println("TestStack - Test 0 Failed");
		}

		// ------------------------------------------------

		if (sStack.toString().equals("Empty stack.")) {
			System.out.println("TestStack - Test 1 Passed");
		} else {
			System.out.println("TestStack - Test 1 Failed");
		}

		// ------------------------------------------------

		sStack.push("Red");
		sStack.push("Green");
		sStack.push("Blue");
		sStack.push("Yellow");
		sStack.push("Purple");
		sStack.push("Cyan");
		sStack.push("Black");
		
		if (sStack.size() == 7 && sStack.getCapacity() == 10 && sStack.getTop() == 6) {
			System.out.println("TestStack - Test 2 Passed");
		} else {
			System.out.println("TestStack - Test 2 Failed");
		}

		// ------------------------------------------------

		if (sStack.toString().equals("Stack: Black, Cyan, Purple, Yellow, Blue, Green, Red.")) {
			System.out.println("TestStack - Test 3 Passed");
		} else {
			System.out.println("TestStack - Test 3 Failed");
		}

		// ------------------------------------------------

		String res1 = sStack.peek();
		String res2 = sStack.pop();
		String res3 = sStack.peek();
		String res4 = sStack.pop();
		
		if (res1.equals("Black") && res2.equals("Black") && res3.equals("Cyan") && res4.equals("Cyan") && sStack.size() == 5 && sStack.getTop() == 4) {
			System.out.println("TestStack - Test 4 Passed");
		} else {
			System.out.println("TestStack - Test 4 Failed");
		}

		// ------------------------------------------------

		for (int i = 0; i < 5; i++) {
			sStack.pop();
		}

		if (sStack.isEmpty() && sStack.isEmpty() && sStack.getTop() == -1) {
			System.out.println("TestStack - Test 5 Passed");
		} else {
			System.out.println("TestStack - Test 5 Failed");
		}

		// ------------------------------------------------

		boolean b1 = false, b2 = false;
		
		try {
			sStack.pop();
		} catch (StackException e) {
			if (e.getMessage().equals("StackException: Stack is empty")) {
				b1 = true;
			}
		}
		
		try {
			sStack.peek();
		} catch (StackException e) {
			if (e.getMessage().equals("StackException: Stack is empty")) {
				b2 = true;
			}
		}
				
		if (b1 && b2) {
			System.out.println("TestStack - Test 6 Passed");
		} else {
			System.out.println("TestStack - Test 6 Failed");
		}

		// ------------------------------------------------

		for (int i = 50; i <= 65; i++) {
			iStack.push(i);
		}
		b1 = iStack.getCapacity() == 30;

		for (int i = 15; i < 50; i++) {
			iStack.push(i);
		}
		b2 = iStack.getCapacity() == 70;

		for (int i = 0; i < 15; i++) {
			iStack.push(i);
		}
		
		if (b1 && b2 && iStack.getCapacity() == 90 && iStack.getTop() == 65) {
			System.out.println("TestStack - Test 7 Passed");
		} else {
			System.out.println("TestStack - Test 7 Failed");
		}

		// ------------------------------------------------

		for (int i = 0; i < 45; i++) {
			iStack.pop();
		}
		b1 = iStack.getCapacity() == 80;
		
		for (int i = 0; i < 5; i++) {
			iStack.pop();
		}
		b2 = iStack.getCapacity() == 60;
		
		for (int i = 0; i < 9; i++) {
			iStack.pop();
		}

		if (b1 && b2 && iStack.size() == 7 && iStack.getCapacity() == 30) {
			System.out.println("TestStack - Test 8 Passed");
		} else {
			System.out.println("TestStack - Test 8 Failed");
		}

		// ------------------------------------------------


		iStack.clear();
		
		if (iStack.size() == 0 && iStack.getTop() == -1 && iStack.getCapacity() == 10) {
			System.out.println("TestStack - Test 9 Passed");
		} else {
			System.out.println("TestStack - Test 9 Failed");
		}

	}

}

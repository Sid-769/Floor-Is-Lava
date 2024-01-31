import javax.swing.JOptionPane;

public class TestPath {

	private static String[] expOutputs = new String[] {
		"Path: 12 17 22 21 20 15 10 5 0 1 2 3 4 9 14 19 24 0G",
		"Path: 2 3 4 9 14 19 24 23 18 13 8 7 12 22 21 20 1 0 0G",
		"No solution found",
		"Path: 10 5 0 1 2 3 4 9 14 19 18 17 16 21 20 3G",
		"Path: 4 9 14 19 24 23 22 17 12 7 2 1 0 5 10 15 20 0G",
		"Path: 0 5 10 11 12 17 22 23 24 0G",
		"Path: 44 34 24 14 4 5 6 7 17 27 45 46 47 48 49 39 29 19 9 54 64 74 84 94 95 96 86 76 66 67 68 78 88 98 93 92 82 72 62 43 42 32 22 12 2 1 0 10 20 30 40 50 60 70 80 90 3G",
		"Path: 21 22 23 24 25 44 64 65 66 67 68 48 28 27 69 70 50 30 71 72 52 32 33 34 73 74 75 76 56 36 37 38 77 78 98 118 117 116 115 135 155 154 153 133 113 112 132 131 111 110 130 129 109 108 128 127 107 106 126 125 105 104 124 144 143 163 183 203 223 243 263 283 303 164 165 145 146 147 148 149 150 151 152 172 173 193 194 195 196 176 177 178 198 218 238 258 278 298 318 338 358 378 20G",
		"Path: 189 188 187 186 185 184 183 182 181 169 149 129 109 89 69 49 29 209 229 249 269 289 309 329 349 369 190 191 192 193 194 195 196 197 198 0G",
		"No solution found"
	};

	private static void runTest (int num) {
		
		MineEscape prog = new MineEscape("mine" + num + ".txt");
		String res = prog.findEscapePath();

		if (res.equals(expOutputs[num])) {
			System.out.println("TestPath - Test " + num + " Passed");
		} else {
			System.out.println("TestPath - Test " + num + " Failed");
		}
		
		JOptionPane.showMessageDialog(null,"TestPath - Test " + num + " Passed");
	}
	
	public static void main(String[] args) {
		
		MapCell.TIME_DELAY = 0;

		// Run all tests sequentially.
		for (int i = 0; i < 10; i++) {
			runTest(i);
		}
		
	}

}

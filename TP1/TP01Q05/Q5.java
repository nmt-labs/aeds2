class Q5 {
	public static boolean isFim(String s) {
		if ((s.length() == 1) && (s.charAt(0) == '0')) {
			return true;
		} else {
			return false;
		}
	}

	public static String subs(String s) {
		char a, b, c;
		String newString = "";
		if (s.charAt(0) == '2') {
			a = s.charAt(2);
			b = s.charAt(4);
			s = s.replace('A', a);
			s = s.replace('B', b);
			for (int i = 6; i < s.length(); i++) {
				newString += s.charAt(i);
			}
		} else if (s.charAt(0) == '3') {
			a = s.charAt(2);
			b = s.charAt(4);
			c = s.charAt(6);
			s = s.replace('A', a);
			s = s.replace('B', b);
			s = s.replace('C', c);
			for (int i = 8; i < s.length(); i++) {
				newString += s.charAt(i);
			}
		}

		return newString;
	}

	public static String not(String s) {
		s = s.replace("not(0)", "1");
		s = s.replace("not(1)", "0");
		return s;
	}

	public static String and(String s) {
		s = s.replace("and(0 , 1)", "0");
		s = s.replace("and(0 , 0)", "0");
		s = s.replace("and(1 , 0)", "0");
		s = s.replace("and(1 , 1)", "1");

		s = s.replace("and(0 , 1 , 0)", "0");
		s = s.replace("and(0 , 0 , 0)", "0");
		s = s.replace("and(1 , 0 , 0)", "0");
		s = s.replace("and(1 , 1 , 1)", "1");
		s = s.replace("and(0 , 0 , 1)", "0");
		s = s.replace("and(1 , 1 , 0)", "0");
		s = s.replace("and(0 , 1 , 1)", "0");
		s = s.replace("and(1 , 0 , 1)", "0");

		return s;
	}

	public static String or(String s) {
		s = s.replace("or(0 , 1)", "1");
		s = s.replace("or(0 , 0)", "0");
		s = s.replace("or(1 , 0)", "1");
		s = s.replace("or(1 , 1)", "1");
		s = s.replace("or(0, 0)", "0");
		s = s.replace("or(0, 1)", "1");
		s = s.replace("or(1, 0)", "1");
		s = s.replace("or(1, 1)", "1");

		s = s.replace("or(0 , 1 , 0)", "1");
		s = s.replace("or(0 , 0 , 0)", "0");
		s = s.replace("or(1 , 0 , 0)", "1");
		s = s.replace("or(1 , 1 , 1)", "1");
		s = s.replace("or(0 , 0 , 1)", "1");
		s = s.replace("or(1 , 1 , 0)", "1");
		s = s.replace("or(0 , 1 , 1)", "1");
		s = s.replace("or(1 , 0 , 1)", "1");

		s = s.replace("or(0 , 1 , 0 , 0)", "1");
		s = s.replace("or(0 , 0 , 0 , 0)", "0");
		s = s.replace("or(1 , 0 , 0 , 0)", "1");
		s = s.replace("or(1 , 1 , 1 , 0)", "1");
		s = s.replace("or(0 , 0 , 1 , 0)", "1");
		s = s.replace("or(1 , 1 , 0 , 0)", "1");
		s = s.replace("or(0 , 1 , 1 , 0)", "1");
		s = s.replace("or(1 , 0 , 1 , 0)", "1");

		s = s.replace("or(0 , 1 , 0 , 1)", "1");
		s = s.replace("or(0 , 0 , 0 , 1)", "0");
		s = s.replace("or(1 , 0 , 0 , 1)", "1");
		s = s.replace("or(1 , 1 , 1 , 1)", "1");
		s = s.replace("or(0 , 0 , 1 , 1)", "1");
		s = s.replace("or(1 , 1 , 0 , 1)", "1");
		s = s.replace("or(0 , 1 , 1 , 1)", "1");
		s = s.replace("or(1 , 0 , 1 , 1)", "1");

		return s;

	}

	public static void main(String[] args) {
		String s = new String();
		Boolean fim = false;
		while (fim != true) {
			s = MyIO.readLine();
			if (isFim(s) == true) {
				fim = true;
				break;
			}
			s = subs(s);
			while (s != "0" || s != "1"){
				s = not(s);
				s = and(s);
				s = or(s);
				if(s.charAt(0) == '0'||s.charAt(0) == '1'){
					break;
				}
			}
			System.out.println(s);
		}
	}
}

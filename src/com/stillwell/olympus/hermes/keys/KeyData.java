package com.stillwell.olympus.hermes.keys;

public class KeyData
{

	public static final int UNDEFINED = 65535;
	private static Key keys[] = new Key[] {
		// character, code, name
		
		new Key(UNDEFINED, 16, "SHIFT"),
		new Key(UNDEFINED, 17, "CONTROL"),
		new Key(UNDEFINED, 18, "ALT"),
		new Key(UNDEFINED, 20, "CAPS_LOCK"),
		new Key(UNDEFINED, 36, "HOME"),
		new Key(UNDEFINED, 38, "UP_ARROW"),
		new Key(UNDEFINED, 40, "DOWN_ARROW"),
		new Key(UNDEFINED, 37, "LEFT_ARROW"),
		new Key(UNDEFINED, 39, "RIGHT_ARROW"),
		new Key(UNDEFINED, 155, "INSERT"),
		new Key(UNDEFINED, 524, "WINDOW_KEY"),
		
		new Key(8, 8, "BACK_SPACE"),
		new Key(10, 10, "ENTER"),
		new Key(27, 27, "ESC"),

		new Key(32, 32, "SPACE"),
		new Key(33, 49, "EXCLAMATION_MARK"),
		new Key(34, 222, "QUOTATION_MARK"),
		new Key(35, 51, "HASHTAG"),
		new Key(36, 52, "DOLLAR_SIGN"),
		new Key(37, 53, "PERCENT_SIGN"),
		new Key(38, 55, "AMPERSAND"),
		new Key(39, 222, "SINGLE_QUOTE"),
		new Key(40, 57, "LEFT_PARENTHESIS"),
		new Key(41, 48, "RIGHT_PARENTHESIS"),
		
		new Key(42, 56, "TIMES"),
		new Key(43, 61, "PLUS"),
		new Key(44, 44, "COMMA"),
		new Key(45, 45, "MINUS"),
		new Key(46, 46, "PERIOD"),
		new Key(47, 47, "DIVIDED_BY"),
		new Key(48, 48, "ZERO"),
		new Key(49, 49, "ONE"),
		new Key(50, 50, "TWO"),
		new Key(51, 51, "THREE"),
		new Key(52, 52, "FOUR"),
		new Key(53, 53, "FIVE"),
		new Key(54, 54, "SIX"),
		new Key(55, 55, "SEVEN"),
		new Key(56, 56, "EIGHT"),
		new Key(57, 57, "NINE"),
		new Key(58, 59, "COLON"),
		new Key(59, 59, "SEMICOLON"),
		new Key(60, 44, "LESS_THAN"),
		new Key(61, 61, "EQUAL"),
		new Key(62, 46, "GREATER_THAN"),
		new Key(63, 47, "QUESTION_MARK"),
		new Key(64, 50, "AT"),

		new Key(65, 65, "A"),
		new Key(66, 66, "B"),
		new Key(67, 67, "C"),
		new Key(68, 68, "D"),
		new Key(69, 69, "E"),
		new Key(70, 70, "F"),
		new Key(71, 71, "G"),
		new Key(72, 72, "H"),
		new Key(73, 73, "I"),
		new Key(74, 74, "J"),
		new Key(75, 75, "K"),
		new Key(76, 76, "L"),
		new Key(77, 77, "M"),
		new Key(78, 78, "N"),
		new Key(79, 79, "O"),
		new Key(80, 80, "P"),
		new Key(81, 81, "Q"),
		new Key(82, 82, "R"),
		new Key(83, 83, "S"),
		new Key(84, 84, "T"),
		new Key(85, 85, "U"),
		new Key(86, 86, "V"),
		new Key(87, 87, "W"),
		new Key(88, 88, "X"),
		new Key(89, 89, "Y"),
		new Key(90, 90, "Z"),

		new Key(91, 91, "LEFT_BRACKET"),
		new Key(92, 92, "BACK_SLASH"),
		new Key(93, 93, "RIGHT_BRACKET"),
		new Key(94, 54, "CARET"),
		new Key(95, 95, "UNDER_SCORE"),
		new Key(96, 192, "GRAVE"),

		new Key(97, 65, "a"),
		new Key(98, 66, "b"),
		new Key(99, 67, "c"),
		new Key(100, 68, "d"),
		new Key(101, 69, "e"),
		new Key(102, 70, "f"),
		new Key(103, 71, "g"),
		new Key(104, 72, "h"),
		new Key(105, 73, "i"),
		new Key(106, 74, "j"),
		new Key(107, 75, "k"),
		new Key(108, 76, "l"),
		new Key(109, 77, "m"),
		new Key(110, 78, "n"),
		new Key(111, 79, "o"),
		new Key(112, 80, "p"),
		new Key(113, 81, "q"),
		new Key(114, 82, "r"),
		new Key(115, 83, "s"),
		new Key(116, 84, "t"),
		new Key(117, 85, "u"),
		new Key(118, 86, "v"),
		new Key(119, 87, "w"),
		new Key(120, 88, "x"),
		new Key(121, 89, "y"),
		new Key(122, 90, "z"),

		new Key(123, 123, "LEFT_BRACE"),
		new Key(124, 92, "PIPE"),
		new Key(125, 125, "RIGHT_BRACE"),
		new Key(126, 192, "TILDE"),
		new Key(127, 127, "DELETE"),

	};
	
	public static boolean undefined(int character)
	{
		return (character == UNDEFINED);
	}

	public static String getName(int character, int code)
	{
		String name = "";

		if(undefined(character))
		{
			for(Key k : keys)
				if(k.getCode() == code)
					name = k.getName();
		}
		else
		{
			for(Key k : keys)
				if(k.getCharacter() == character)
					name = k.getName();
		}

		return name;
	}
	
	public static Key getKey(String name)
	{
		for(Key k : keys)
			if(k.getName().equals(name))
				return k;
		System.out.println("Key not found");
		return null;
	}

}

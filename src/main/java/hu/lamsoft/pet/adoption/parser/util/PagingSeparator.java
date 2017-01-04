package hu.lamsoft.pet.adoption.parser.util;

import java.io.IOException;

public enum PagingSeparator {

	HU("/"),
	EN(" of "),
	DE(" von ");
	
	private String separatorString;
	
	private PagingSeparator(String separatorString) {
		this.separatorString = separatorString;
	}
	
	public static String getSeparator(String pagingString) {
		if(pagingString != null) {
			for(PagingSeparator separator : values()) {
				if(pagingString.contains(separator.separatorString)) {
					return separator.separatorString;
				}
			}
		}
		return null;
	}
	
	public static int getTotalItems(String totalItemsString) throws IOException {
		if(totalItemsString == null) {
			return 0;
		}
		String separatorString = getSeparator(totalItemsString);
		return Integer.parseInt(totalItemsString.substring(totalItemsString.indexOf(separatorString) + separatorString.length()));
	}

	public static boolean hasMorePage(String totalItemsString) throws IOException {
		if(totalItemsString == null) {
			return false;
		}
		String separatorString = getSeparator(totalItemsString);
		String totalItems = totalItemsString.substring(totalItemsString.indexOf(separatorString) + separatorString.length());
		return !totalItemsString.endsWith("-"+totalItems+separatorString+totalItems);
	}
	
}

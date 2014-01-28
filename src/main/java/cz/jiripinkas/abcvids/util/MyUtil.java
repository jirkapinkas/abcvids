package cz.jiripinkas.abcvids.util;


public final class MyUtil {

    private static String removeDiacritics(String string) {
        String result = "";
        string = string.replace("ž", "z");
        string = string.replace("Ž", "Z");
        string = string.replace("ý", "y");
        string = string.replace("Ý", "Y");
        string = string.replace("ú", "u");
        string = string.replace("Ú", "U");
        string = string.replace("ť", "t");
        string = string.replace("Ť", "T");
        string = string.replace("ň", "n");
        string = string.replace("Ň", "N");
        string = string.replace("ó", "o");
        string = string.replace("ö", "o");
        string = string.replace("Ó", "O");
        string = string.replace("ß", "ss");
        String with_diac = "ůčšáäčďěéíĺžňóöôŕřšťúüýžźŮČŠÁÄČĎĚÉÍĹŇÓÖÔŔŘÚÜÝŽŐőÖöŰűÜü";
        String without_diac = "ucsaacdeeillnooorrstuuyzzUCSAACDEEILLNOOORRTUUYZOoOoUuUu";
        for (int l = 0; l < string.length(); l++) {
            if (with_diac.indexOf(string.charAt(l)) != -1)
                result += without_diac.charAt(with_diac.indexOf(string.charAt(l)));
            else
                result += string.charAt(l);
        }
        return result;
    }

    public static String transformNameToShortName(String name) {
    	// remove diacritics
        name = removeDiacritics(name);
        // remove special characters
        name = name.replace(" ", "-");
        name = name.replace(".", "-");
        name = name.replace(",", "-");
        name = name.replace("/", "-");
        name = name.replace("\\", "-");
        name = name.replace("?", "-");
        name = name.replace("!", "-");
        name = name.replace("=", "-");
        name = name.replace("+", "-");
        name = name.replace("*", "-");
        name = name.replace(";", "-");
        name = name.replace(":", "-");
        name = name.replace("@", "-");
        name = name.replace("#", "-");
        name = name.replace("$", "-");
        name = name.replace("%", "-");
        name = name.replace("^", "-");
        name = name.replace("&", "-");
        name = name.replace("(", "-");
        name = name.replace(")", "-");
        name = name.replace("{", "-");
        name = name.replace("}", "-");
        name = name.replace("[", "-");
        name = name.replace("]", "-");
        name = name.replace("\"", "-");
        name = name.replace("'", "-");
        name = name.replace("|", "-");
        name = name.replace("<", "-");
        name = name.replace(">", "-");
        name = name.replace("~", "-");
        name = name.replace("-------", "-");
        name = name.replace("------", "-");
        name = name.replace("-----", "-");
        name = name.replace("----", "-");
        name = name.replace("---", "-");
        name = name.replace("--", "-");
        name = name.toLowerCase();
        if (name.endsWith("-")) {
            name = name.substring(0, name.length() - 1);
        }
        name = name.trim();
        return name;
    }
}

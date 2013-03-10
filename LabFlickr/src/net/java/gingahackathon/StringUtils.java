package net.java.gingahackathon;


import java.io.UnsupportedEncodingException;
import java.util.Vector;

public final class StringUtils {
	public static String[] split(String original, String separator) {
		Vector nodes = new Vector();
		// Parse nodes into vector
		int index = original.indexOf(separator);
		while (index >= 0) {
			nodes.addElement(original.substring(0, index));
			original = original.substring(index + separator.length());
			index = original.indexOf(separator);
		}
		// Get the last node
		nodes.addElement(original);

		// Create splitted string array
		String[] result = new String[nodes.size()];
		if (nodes.size() > 0) {
			for (int loop = 0; loop < nodes.size(); loop++) {
				result[loop] = (String) nodes.elementAt(loop);
				System.out.println(result[loop]);
			}

		}

		return result;
	}
	
	public static String unescapeJS(String vl) {
		try {
			return java.net.URLDecoder.decode(vl,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// This should never happen
			e.printStackTrace();
		}
		return "Unsupported UTF-8: " + vl;
	}
	public static String escapeJS(String vl) {
		try {
			return java.net.URLEncoder.encode(vl,"UTF-8");
		} catch (UnsupportedEncodingException e) {
			// This should never happen
			e.printStackTrace();
		}
		return "Unsupported UTF-8: " + vl;
	}

}

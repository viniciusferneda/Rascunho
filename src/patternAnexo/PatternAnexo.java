package patternAnexo;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAnexo {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final Pattern p = Pattern.compile("(\\d{11})(\\d{11})(\\d{8})(.{20})(\\d{4})(\\d{3})\\.(.{3})");
		final Matcher m = p.matcher("0000000000000441323513000000400077062439          0667001.pdf");
		boolean matchFound = m.find();
		Object[] parameters = null;
		if (matchFound) {
			parameters = new String[m.groupCount()];
			for (int i = 1; i <= m.groupCount(); i++) {
				parameters[i - 1] = m.group(i);
			}
		}
		System.out.println(parameters);
	}

}

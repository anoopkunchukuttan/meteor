import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import org.tartarus.snowball.SnowballStemmer;

import edu.cmu.meteor.util.Constants;

public class Stemmer {
	public static void main(String[] args) throws Throwable {
		if (args.length != 1) {
			System.err
					.println("Snowball stem some text in a supported language");
			System.err.println("Languages: en da de es fi fr hu pt ro ru tr");
			System.err.println("Usage: Stemmer lang < in > out");
			System.exit(1);
		}

		String lang = Constants.normLanguageName(args[0]);
		SnowballStemmer stemmer = Constants.newStemmer(lang);

		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		String line;

		while ((line = in.readLine()) != null) {
			StringBuilder sb = new StringBuilder();
			StringTokenizer tok = new StringTokenizer(line);
			while (tok.hasMoreTokens()) {
				stemmer.setCurrent(tok.nextToken());
				stemmer.stem();
				sb.append(" " + stemmer.getCurrent());
			}
			System.out.println(sb.toString().trim());
		}
	}
}

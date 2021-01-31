package coaching.csv;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * TODO Implement CSV parsing logic here
 */
public class DefaultCsvParser implements CsvParser {

	Scanner scanner = null;
	CsvFileConfig fileConfig = null;
	int nSegment = 0;

	/**
	 * Initialize parser
	 *
	 * @param file         CSV file
	 * @param parserConfig Configuration
	 */
	public DefaultCsvParser(File file, CsvFileConfig parserConfig) throws IOException {

		if (file == null || parserConfig == null) {
			throw new IllegalArgumentException("Arguments can not be null");
		}

		this.fileConfig = parserConfig;

		Scanner tempScanner = new Scanner(new FileReader(file));

		if (tempScanner.hasNext()) { // read first line and close it
			String line = tempScanner.next();
			this.nSegment = line.split(Pattern.quote(parserConfig.delimiter)).length;
		}

		tempScanner.close();

		this.scanner = new Scanner(new FileReader(file));
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void close() {
		scanner.close();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return
	 */
	public boolean hasNext() {
		return scanner.hasNext();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @return
	 */
	public CsvLine next() throws IOException {

		CsvLine csvLine = new CsvLine();

		if (scanner.hasNext()) {
			String line = scanner.next();
			String[] segments;

			if (fileConfig.quoted) {
				line = line.replaceAll("\"", "");
			}

			segments = line.split(Pattern.quote(fileConfig.delimiter), 0);

			if(segments.length != nSegment)
			{
				this.close();
				throw new IOException("Incompatible of data column.");
			}

			for (int i = 0; i < segments.length; i++) {
				csvLine.set(i, segments[i].trim());
			}
		}

		return csvLine;
	}
}

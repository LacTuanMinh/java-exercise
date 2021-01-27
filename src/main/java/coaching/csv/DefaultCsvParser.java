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

    /**
     * Initialize parser
     *
     * @param file         CSV file
     * @param parserConfig Configuration
     */
    public DefaultCsvParser(File file, CsvFileConfig parserConfig) {

        try {
            this.scanner = new Scanner(new FileReader(file));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        this.fileConfig = parserConfig;
    }

    /**
     * {@inheritDoc}
     *
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
    @Override
    public boolean hasNext() {
        return scanner.hasNext();
    }

    /**
     * {@inheritDoc}
     *
     * @return
     */
    @Override
    public CsvLine next() {

        CsvLine csvLine = new CsvLine();

        if (scanner.hasNext()) {
            String line = scanner.next();
            String[] segments;

            if (fileConfig.quoted) {
                line = line.replaceAll("\"", "");
            }

            segments = line.split(Pattern.quote(fileConfig.delimiter),0);

            for (int i = 0; i < segments.length; i++) {
                csvLine.set(i, segments[i].trim());
            }
        }

        return csvLine;
    }
}

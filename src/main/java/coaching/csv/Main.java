package coaching.csv;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        ClassLoader classLoader = ClassLoader.getSystemClassLoader();
        File file = new File(classLoader.getResource("abnormal.csv").getFile());
        CsvFileConfig configuration = new CsvFileConfig();
        configuration.setDelimiter("|");
        configuration.setQuoteMode(false);
        CsvParser parser = new DefaultCsvParser(file, configuration);

        List<CsvLine> lines = new ArrayList<>();
        while (parser.hasNext()) {
            lines.add(parser.next());
        }

        parser.close();

//        CsvWriter writer = new DefaultCsvWriter(configuration, new File(classLoader.getResource("resultContainer.csv").getFile()));
        CsvWriter writer = new DefaultCsvWriter(configuration, new File("resultContainer.csv"));

        writer.write(lines);

        writer.close();

    }
}

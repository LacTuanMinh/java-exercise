package coaching.csv;

import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.Collection;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * TODO Implement CSV writing logic here
 */
public class DefaultCsvWriter implements CsvWriter {

    FileWriter writer = null;
    CsvFileConfig fileConfig = null;

    /**
     * Initialize writer
     *
     * @param config Config
     * @param file   File to be written
     */
    public DefaultCsvWriter(CsvFileConfig config, File file) {

        try {
            this.writer = new FileWriter(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.fileConfig = config;
    }

    /**
     * {@inheritDoc}
     *
     * @param line CSV line
     */
    @Override
    public void write(CsvLine line) {

        String[] data = line.getSegments().values().toArray(new String[0]);
        String formattedLine;
        if (fileConfig.quoted) {
//            formattedLine = "\"" + StringUtils.join(data, "\"" + fileConfig.delimiter + "\"") + "\"";
            formattedLine = Arrays.stream(data).collect(Collectors.joining("\"" + fileConfig.delimiter + "\"", "\"", "\""));
        } else {
            formattedLine = Arrays.stream(data).collect(Collectors.joining(fileConfig.delimiter));
        }

        try {
            writer.write(formattedLine + "\r\n");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * {@inheritDoc}
     *
     * @param lines Multiple CSV lines
     */
    @Override
    public void write(Collection<CsvLine> lines) {

        for (CsvLine line : lines) {
            write(line);
        }

//        CsvLine[] array = (CsvLine[]) lines.toArray();
//        int len = array.length
//        for (int i = 0; i < len; i++) {
//            write(array[i]);
//
//            if(i < len)
//                write(array[i]+"\r\n");
//        }
    }

    /**
     * {@inheritDoc}
     *
     * @throws IOException
     */
    @Override
    public void close() {
        try {
            writer.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

}

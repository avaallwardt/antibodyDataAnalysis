package org.example;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;

import java.io.FileReader;
import java.io.IOException;
import java.io.StringWriter;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
public class ConsensusWriter {

    // call this in the consensus main and then it will automatically throw the IO exception

    public static void createNewCSV1(List<org.example.Row> rows) throws IOException {
        StringWriter writer = new StringWriter();
        //using custom delimiter and quote character

        Writer writer2 = Files.newBufferedWriter(Paths.get("src/allDataFiltered-onlyLongCDR3.csv"));

        CSVWriter csvWriter = new CSVWriter(writer2, ',', '\"');

        List<String[]> data = toStringArray(rows);

        //ArrayList<String[]> data2 = new ArrayList<>();
        for(int i = 0; i < data.size(); i++){
            csvWriter.writeNext(data.get(i));
        }

        //csvWriter.writeAll(data);

        try {
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(writer);
    }

    public static void createNewCSV2(List<org.example.Row> rows) throws IOException {
        StringWriter writer = new StringWriter();
        //using custom delimiter and quote character

        Writer writer2 = Files.newBufferedWriter(Paths.get("src/sortedByLength.csv"));

        CSVWriter csvWriter = new CSVWriter(writer2, ',', '\"');

        List<String[]> data = toStringArray(rows);

        //ArrayList<String[]> data2 = new ArrayList<>();
        for(int i = 0; i < data.size(); i++){
            csvWriter.writeNext(data.get(i));
        }

        //csvWriter.writeAll(data);

        try {
            csvWriter.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println(writer);
    }



    private static List<String[]> toStringArray(List<org.example.Row> rows) {
        List<String[]> records = new ArrayList<String[]>();

        Iterator<org.example.Row> it = rows.iterator();
        while (it.hasNext()) {
            org.example.Row row = it.next();
            // should've just made 1 instance variable for Row - make it an arrayList and add all of these data points into it
            records.add(new String[] { row.getSeq_id(), row.getUid(), row.getChain(), row.getProductive(), row.getV_full(), row.getV_gene(), row.getD_full(), row.getD_gene(), row.getJ_full(), row.getJ_gene(), row.getCdr3_length(), row.getCdr3_nt(), row.getCdr3_aa(), row.getV_start(), row.getVdj_nt(), row.getVj_aa(), row.getVar_muts_nt(), row.getVar_muts_nt(), row.getVar_identity_nt(), row.getVar_identity_aa(), row.getVar_mut_count_nt(), row.getVar_mut_count_aa(), row.getVar_ins(), row.getVar_del(), row.getIsotype(), row.getRaw_input(), row.getNumDChainMatches() });
        }
        return records;
    }



}

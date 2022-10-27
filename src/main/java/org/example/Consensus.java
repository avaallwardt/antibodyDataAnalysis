package org.example;

import com.opencsv.CSVReader;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Consensus {

    private static ArrayList<org.example.Row> rows = new ArrayList<org.example.Row>();

    private static double total1;
    private static double total2;
    private static double total3;

    private static double productive1;
    private static double productive2;
    private static double productive3;

    private static double prodD331;
    private static double prodD332;
    private static double prodD333;

    private static double prodD33Yydf1;
    private static double prodD33Yydf2;
    private static double prodD33Yydf3;

    private static double prodD33YydfLong1;
    private static double prodD33YydfLong2;
    private static double prodD33YydfLong3;


    public static void main(String[] args) throws IOException {

        convertCSVToList("src/2_1_consensus.csv");
        findProportions(1);
        convertCSVToList("src/2_2_consensus.csv");
        findProportions(2);
        convertCSVToList("src/2_3_consensus.csv");
        findProportions(3);

        double totalTotal = total1 + total2 + total3;
        double totalProductive = productive1 + productive2 + productive3;
        double totalProdD33 = prodD331 + prodD332 + prodD333;
        double totalProdD33Yydf = prodD33Yydf1 + prodD33Yydf2 + prodD33Yydf3;
        double totalProdD33YydfLong = prodD33YydfLong1 + prodD33YydfLong2 + prodD33YydfLong3;

        double proportionProductive = totalProductive / totalProductive;
        double proportionProdD33 = totalProdD33 / totalProductive;
        double proportionProdD33Yydf = totalProdD33Yydf / totalProductive;
        double proportionProdD33YydfLong = totalProdD33YydfLong / totalProductive;

        System.out.println("Productive: " + proportionProductive);
        System.out.println("Productive D3-3: " + proportionProdD33);
        System.out.println("Productive D3-3 YYDF: " + proportionProdD33Yydf);
        System.out.println("Productive D3-3 YYDF Long: " + proportionProdD33YydfLong);


        /*
        convertCSVToList();
        addCSV("src/2CDR3sWithYYDF.csv");
        addCSV("src/3CDR3sWithYYDF.csv");


        parseByProductive();
        parseByD33();
        sortByCDR3Length();
        findCDR3sWithYYDF();

        filterBySize();

        ConsensusWriter.createNewCSV1(rows);

         */
    }

    public static void convertCSVToList(String fileName) throws IOException {
        CSVReader reader = new CSVReader(new FileReader(fileName), ',');

        //ArrayList<Row> rows = new ArrayList<Row>();
        String[] record = null;

        while ((record = reader.readNext()) != null) {
            org.example.Row row = new org.example.Row();
            row.setSeq_id(record[0]);
            //row.setUid(record[1]);
            row.setChain(record[2]);
            row.setProductive(record[3]);
            row.setV_full(record[4]);
            row.setV_gene(record[5]);
            row.setD_full(record[6]);
            row.setD_gene(record[7]);
            row.setJ_full(record[8]);
            row.setJ_gene(record[9]);
            row.setCdr3_length(record[10]);
            row.setCdr3_nt(record[11]);
            row.setCdr3_aa(record[12]);
            row.setV_start(record[13]);
            row.setVdj_nt(record[14]);
            row.setVj_aa(record[15]);
            row.setVar_muts_nt(record[16]);
            row.setVar_muts_aa(record[17]);
            row.setVar_identity_nt(record[18]);
            row.setVar_identity_aa(record[19]);
            row.setVar_mut_count_nt(record[20]);
            row.setVar_mut_count_aa(record[21]);
            row.setVar_ins(record[22]);
            row.setVar_del(record[23]);
            row.setIsotype(record[24]);
            row.setRaw_input(record[25]);
            rows.add(row);
        }
        reader.close();
    }

    public static void ORIGINALparseByProductive() throws IOException {

        CSVReader reader = new CSVReader(new FileReader("src/1_consensus.csv"), ',');

        // how do i handle the title of the columns? (aka the first row) -- i had it  add it to the list if it equals productive

        ArrayList<org.example.Row> newRows = new ArrayList<org.example.Row>();
        String[] record = null;
        while ((record = reader.readNext()) != null) {
            if (record[3].equals("yes") || record[3].equals("productive")) {
                org.example.Row row = new org.example.Row();
                row.setSeq_id(record[0]);
                //row.setUid(record[1]);
                row.setChain(record[2]);
                row.setProductive(record[3]);
                row.setV_full(record[4]);
                row.setV_gene(record[5]);
                row.setD_full(record[6]);
                row.setD_gene(record[7]);
                row.setJ_full(record[8]);
                row.setJ_gene(record[9]);
                row.setCdr3_length(record[10]);
                row.setCdr3_nt(record[11]);
                row.setCdr3_aa(record[12]);
                row.setV_start(record[13]);
                row.setVdj_nt(record[14]);
                row.setVj_aa(record[15]);
                row.setVar_muts_nt(record[16]);
                row.setVar_muts_aa(record[17]);
                row.setVar_identity_nt(record[18]);
                row.setVar_identity_aa(record[19]);
                row.setVar_mut_count_nt(record[20]);
                row.setVar_mut_count_aa(record[21]);
                row.setVar_ins(record[22]);
                row.setVar_del(record[23]);
                row.setIsotype(record[24]);
                row.setRaw_input(record[25]);
                newRows.add(row);
            }
//
        }
        reader.close();

           /*
        try {
            FileOutputStream fileOut =
                    new FileOutputStream("consensus.dat");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(rows);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data is saved in /tmp/employee.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }

         */
        ConsensusWriter.createNewCSV1(newRows);
    }

    public static void parseByProductive() throws IOException {
        for(int i = rows.size() - 1; i > -1; i--) {
            if (!(rows.get(i).getProductive().equals("yes") || rows.get(i).getProductive().equals("productive"))) {
                rows.remove(i);
            }
        }
    }

    public static void parseByD33() throws IOException {
        // CSVReader reader = new CSVReader(new FileReader("src/myCSV.csv"), ',');

        // how do i handle the title of the columns? (aka the first row) -- i had it  add it to the list if it equals productive

        //ArrayList<Row> rows = new ArrayList<Row>();
        // String[] record = null;

        for(int i = rows.size() - 1; i > -1; i--){
            if(!(rows.get(i).getD_full().contains("D3-3") || rows.get(i).getD_full().equals("d_full"))){
                rows.remove(i);
            }
        }
        /*
        while ((record = reader.readNext()) != null) {
            if (record[6].contains("D3-3") || record[3].equals("d_full")) {
                Row row = new Row();
                // Row row = rows.get(6);
                row.setSeq_id(record[0]);
                //row.setUid(record[1]);
                row.setChain(record[2]);
                row.setProductive(record[3]);
                row.setV_full(record[4]);
                row.setV_gene(record[5]);
                row.setD_full(record[6]);
                row.setD_gene(record[7]);
                row.setJ_full(record[8]);
                row.setJ_gene(record[9]);
                row.setCdr3_length(record[10]);
                row.setCdr3_nt(record[11]);
                row.setCdr3_aa(record[12]);
                row.setV_start(record[13]);
                row.setVdj_nt(record[14]);
                row.setVj_aa(record[15]);
                row.setVar_muts_nt(record[16]);
                row.setVar_muts_aa(record[17]);
                row.setVar_identity_nt(record[18]);
                row.setVar_identity_aa(record[19]);
                row.setVar_mut_count_nt(record[20]);
                row.setVar_mut_count_aa(record[21]);
                row.setVar_ins(record[22]);
                row.setVar_del(record[23]);
                row.setIsotype(record[24]);
                row.setRaw_input(record[25]);
                rows.add(row);
            }
        }
        reader.close();
        // MR U - HOW DO I USE THE SAME CREATENEWCSV METHOD AND CHANGE THE NAME -- actually, i just made rows an instance variable so now i can make all of the changes to the spreadsheet and then generate a new spreadsheet
        // BUT then it will just keep adding rows instead of modifying them -- maybe make it so that it iterates through the arraylist to change it instead of the csv?
        // OR: could create a method to turn the csv into an array list and then diff methods to change the rows arraylist then make a csv at the end
        // ConsensusWriter.createNewCSV2(rows);

         */
    }

    public static void sortByCDR3Length() throws IOException {
        for (int j = 1; j < rows.size(); j++)
        {
            int minIndex = j;
            for (int k = j + 1; k < rows.size(); k++)
            {
                if (rows.get(k).getCdr3_aa().length() < rows.get(minIndex).getCdr3_aa().length())
                {
                    minIndex = k;
                }
            }
            org.example.Row currentRow = rows.get(j);
            rows.set(j, rows.get(minIndex));
            rows.set(minIndex, currentRow);
        }
    }

    // this sorts by sequence id alphabetically - what do you mean sort alphabetically?
    public static void sortAlphabetically() throws IOException {
        for (int j = 1; j < rows.size(); j++)
        {
            int minIndex = j;
            for (int k = j + 1; k < rows.size(); k++)
            {
                if (rows.get(k).getSeq_id().length() < rows.get(minIndex).getSeq_id().length())
                {
                    minIndex = k;
                }
            }
            org.example.Row currentRow = rows.get(j);
            rows.set(j, rows.get(minIndex));
            rows.set(minIndex, currentRow);
        }
    }

    // what does m length refer to?
    public static void sortByMLength() throws IOException {
        for (int j = 1; j < rows.size(); j++)
        {
            int minIndex = j;
            for (int k = j + 1; k < rows.size(); k++)
            {
                if (rows.get(k).getVar_muts_aa().length() < rows.get(minIndex).getVar_muts_aa().length())
                {
                    minIndex = k;
                }
            }
            org.example.Row currentRow = rows.get(j);
            rows.set(j, rows.get(minIndex));
            rows.set(minIndex, currentRow);
        }
    }

    // looks for match of 4 of yydfwsgyyt
    public static void parseByD3AminoAcids() throws IOException {
        String dChainReading = "YYDFWSGYYT";
        for(int i = rows.size() - 1; i > -1; i--) {
            int numDChainMatches = 0;
            for (int j = 0; j < dChainReading.length() - 3; j++) {
                if (rows.get(i).getCdr3_aa().contains(dChainReading.substring(j, j + 4))) {
                    numDChainMatches++;
                    // System.out.println(rows.get(i).getCdr3_aa() + " " + numDChainMatches);
                }
            }
            if ((numDChainMatches == 0) && !(rows.get(i).getCdr3_aa().equals("cdr3_aa"))) {
                rows.remove(i);
            }
            else if(i == 0) {
                rows.get(i).setNumDChainMatches("Number D Chain Sequence Matches");
            }
            else{
                rows.get(i).setNumDChainMatches(String.valueOf(numDChainMatches));
            }
        }


            /*
            for(int j = 0; j < rows.get(i).getCdr3_aa().length() - 4; j++){
                for(int k = 0; k < dChainReading.length() - 4; k++){
                    if(rows.get(i).getCdr3_aa().substring(j, j+4).equalsIgnoreCase(dChainReading.substring(k, k+4))){
                        numDChainMatches++;
                    }
                }
            }
            if(numDChainMatches == 0){
                rows.remove(i);
            }
        }

             */
/*
        for(int i = 0; i < rows.size(); i++){
            int numDChainMatches = 0;
            for(int j = 0; j < rows.get(i).getCdr3_aa().length() - 4; j++){
                for(int k = 0; k < dChainReading.length() - 4; k++){
                    if(rows.get(i).getCdr3_aa().substring(j, j+4).equalsIgnoreCase(dChainReading.substring(k, k+4))){
                        numDChainMatches++;
                    }
                }
            }
            if(i != 0){
                rows.get(i).setNumDChainMatches(Integer.toString(numDChainMatches));
            }
            else{
                rows.get(i).setNumDChainMatches("Number D Chain Sequence Matches");
            }
        }

 */
    }

    public static void findCDR3sWithYYDF() throws IOException {
        for(int i = rows.size() - 1; i > -1; i--){
            int numDChainMatches = 0;
            if(!(rows.get(i).getCdr3_aa().contains("YYDF") || (rows.get(i).getCdr3_aa().equals("cdr3_aa")))){
                rows.remove(i);
            }
            else{
                for(int j = 0; j <= rows.get(i).getCdr3_aa().length() - 4; j++){
                    if(rows.get(i).getCdr3_aa().substring(j, j+4).equalsIgnoreCase("YYDF")){
                        numDChainMatches++;
                    }
                }
                if(i != 0){
                    rows.get(i).setNumDChainMatches(Integer.toString(numDChainMatches));
                }
                else{
                    rows.get(i).setNumDChainMatches("Number YYDF Matches");
                }
            }
        }
    }



    public static void findProportions(int csvNum) throws IOException{
        /*
        double productiveOfAll = 0;
        double d33OfProductive = 0;
        double yydfOfD33Productive = 0;
        double d33OfAll = 0;
        double yydfAndD33OfAll = 0;

         */
        if(csvNum == 1){
            total1 = rows.size();
            parseByProductive();
            productive1 = rows.size();
            parseByD33();
            prodD331 = rows.size();
            findCDR3sWithYYDF();
            prodD33Yydf1 = rows.size();
            filterBySize();
            prodD33YydfLong1 = rows.size();
        }
        else if(csvNum == 2){
            total2 = rows.size();
            parseByProductive();
            productive2 = rows.size();
            parseByD33();
            prodD332 = rows.size();
            findCDR3sWithYYDF();
            prodD33Yydf2 = rows.size();
            filterBySize();
            prodD33YydfLong2 = rows.size();
        }
        else if(csvNum == 3){
            total3 = rows.size();
            parseByProductive();
            productive3 = rows.size();
            parseByD33();
            prodD333 = rows.size();
            findCDR3sWithYYDF();
            prodD33Yydf3 = rows.size();
            filterBySize();
            prodD33YydfLong3 = rows.size();
        }
    }


    public static void addCSV(String fileName) throws IOException{
        CSVReader reader = new CSVReader(new FileReader(fileName), ',');
        ArrayList<org.example.Row> newData = new ArrayList<org.example.Row>();
        String[] record = null;
        while ((record = reader.readNext()) != null) {
            org.example.Row row = new org.example.Row();
            row.setSeq_id(record[0]);
            //row.setUid(record[1]);
            row.setChain(record[2]);
            row.setProductive(record[3]);
            row.setV_full(record[4]);
            row.setV_gene(record[5]);
            row.setD_full(record[6]);
            row.setD_gene(record[7]);
            row.setJ_full(record[8]);
            row.setJ_gene(record[9]);
            row.setCdr3_length(record[10]);
            row.setCdr3_nt(record[11]);
            row.setCdr3_aa(record[12]);
            row.setV_start(record[13]);
            row.setVdj_nt(record[14]);
            row.setVj_aa(record[15]);
            row.setVar_muts_nt(record[16]);
            row.setVar_muts_aa(record[17]);
            row.setVar_identity_nt(record[18]);
            row.setVar_identity_aa(record[19]);
            row.setVar_mut_count_nt(record[20]);
            row.setVar_mut_count_aa(record[21]);
            row.setVar_ins(record[22]);
            row.setVar_del(record[23]);
            row.setIsotype(record[24]);
            row.setRaw_input(record[25]);
            newData.add(row);
        }
        reader.close();

        // gets rid of the title row
        newData.remove(0);
        for(int i = 0; i < newData.size(); i++){
            rows.add(newData.get(i));
        }
    }

    public static void filterBySize() throws IOException{
        for(int i = rows.size() - 1; i > -1; i--) {
            int cdr3Length = 0;
            if(!rows.get(i).getCdr3_length().equals("cdr3_length")){
                cdr3Length = Integer.valueOf(rows.get(i).getCdr3_length());
            }
            if (!(cdr3Length >= 24 || (rows.get(i).getCdr3_length().equals("cdr3_length")))) {
                rows.remove(i);
            }
        }
    }






}




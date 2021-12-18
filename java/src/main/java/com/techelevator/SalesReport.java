//package com.techelevator;
//
//import java.io.File;
//import java.io.FileNotFoundException;
//import java.io.FileOutputStream;
//import java.io.PrintWriter;
//import java.util.Scanner;
//
//public class SalesReport {
//
//
//    public void SalesReportWriter(String userInput) throws FileNotFoundException {
//        String path = "SalesReport.txt";
//        File SalesReportFile = new File(path);
//        Scanner fileScan = new Scanner(SalesReportFile);
//        try (PrintWriter salesReportWriter = new PrintWriter(new FileOutputStream(SalesReportFile.getAbsoluteFile(), true))) {
//            while (fileScan.hasNextLine()) {
//                String line = fileScan.nextLine();
//                String[] parts = line.split("[|]");
//                String productName = parts[0];
//                int count = Integer.parseInt(parts[1]);
//                if(productName.equals(userInput)) {
//                    salesReportWriter.println(parts[0] + "|" + (count + 1));
//                }
//            }
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//    }
//}

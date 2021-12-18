package com.techelevator;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogWriter {



    //    private BigDecimal amount;
//    private BigDecimal balance;
//    private String transactionType;


    public void LogWrite(String text) {


    String path = "Log.txt";
    File logFile = new File(path);
    try (PrintWriter logWriter = new PrintWriter(new FileOutputStream(logFile.getAbsoluteFile(), true))) {

        // date and time to return in log
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy hh:mm:ss a");
        LocalDateTime timeStamp = LocalDateTime.now();
        String dateTime = dateTimeFormatter.format(timeStamp);
//        String transactionType1 = transactionType.toString();
//        String amount1 = amount.toString();
//        String balance1 = balance.toString();
//        String logEntry = dateTime + transactionType1 +" "+ amount1 + balance1 +"\n";

        logWriter.println(dateTime + text);

        // machine function to return in log

        // initial balance

        // remaining balance
    }catch(Exception e){
    }


    }
}
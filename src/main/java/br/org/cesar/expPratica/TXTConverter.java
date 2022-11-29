package br.org.cesar.expPratica;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class TXTConverter {

    public static void technicalReportToResource (TechnicalReport technicalReport) throws IOException {

        String reportAsString = technicalReport.toString();

        File targetFile = new File("technical_report.txt");
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(reportAsString.getBytes());
    }
}

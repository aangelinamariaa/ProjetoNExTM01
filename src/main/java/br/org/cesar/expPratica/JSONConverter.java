package br.org.cesar.expPratica;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.*;

public class JSONConverter {
    public static void technicalReportToResource(TechnicalReport technicalReport) throws IOException {

        Writer printWriter = new StringWriter();

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(printWriter, technicalReport);

        File targetFile = new File("technical_report.json");
        OutputStream outStream = new FileOutputStream(targetFile);
        outStream.write(printWriter.toString().getBytes());
    }
}

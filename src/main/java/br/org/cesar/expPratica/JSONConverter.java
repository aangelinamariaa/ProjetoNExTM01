package br.org.cesar.expPratica;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.*;

public class JSONConverter {
    public ResponseEntity<byte[]> technicalReportToResource(TechnicalReport technicalReport) throws IOException {

        StringWriter outString= new StringWriter();
        ByteArrayOutputStream byteStream = new ByteArrayOutputStream();

        Writer printWriter = new PrintWriter(byteStream);

        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.writeValue(printWriter, technicalReport);

        String filename = "TechnicalReport.json";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/json"))
                .body(byteStream.toByteArray());
    }
}

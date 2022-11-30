package br.org.cesar.expPratica;

import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
public class TXTConverter {
    public ResponseEntity<InputStreamResource>  technicalReportToResource (TechnicalReport technicalReport){
        String reportAsString = technicalReport.toString();
        InputStream targetStream = new ByteArrayInputStream(reportAsString.getBytes());

        InputStreamResource inputStreamResource = new InputStreamResource(targetStream);
        String filename = "TechnicalReport.txt";

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=" + filename)
                .contentType(MediaType.parseMediaType("application/txt"))
                .body(inputStreamResource);
    }
}

package tn.tech.horizon.health_care.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.tech.horizon.health_care.services.impl.FileDataServiceImpl;

import java.io.IOException;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class FileController {

    private FileDataServiceImpl service;

    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadFileToFIleSystem(
            @RequestParam("idOwner") Long idOwner,
            @RequestParam("image")MultipartFile file)
            throws IOException {
        String uploadImage = service.uploadFileToFileSystem(idOwner, file);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/download-img/{idOwner}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable Long idOwner) throws IOException {
        byte[] imageData=service.downloadFileFromFileSystem(idOwner);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    @GetMapping("/download-pdf/{idOwner}")
    public ResponseEntity<?> downloadPdfFromFileSystem(@PathVariable Long idOwner) throws IOException {
        byte[] pdfData = service.downloadFileFromFileSystem(idOwner);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfData);
    }


}

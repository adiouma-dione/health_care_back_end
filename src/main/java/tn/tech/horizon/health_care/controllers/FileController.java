package tn.tech.horizon.health_care.controllers;


import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.tech.horizon.health_care.services.impl.FileDataServiceImpl;

import java.io.IOException;
import java.util.Arrays;

@RestController
@RequestMapping("/api")
@AllArgsConstructor
public class FileController {

    private FileDataServiceImpl service;

    @PostMapping("/upload-file")
    public ResponseEntity<?> uploadFileToFIleSystem(
            @RequestParam("idFilesOwner") Long idFilesOwner,
            @RequestParam("image")MultipartFile file)
            throws IOException {
        String uploadImage = service.uploadFileToFileSystem(idFilesOwner, file);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(uploadImage);
    }

    @GetMapping("/download/img/{idFilesOwner}")
    public ResponseEntity<?> downloadImageFromFileSystem(@PathVariable Long idFilesOwner) throws IOException {
        byte[] imageData=service.downloadFileFromFileSystem(idFilesOwner);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.valueOf("image/png"))
                .body(imageData);
    }

    @GetMapping("/download/pdf/{idFilesOwner}")
    public ResponseEntity<?> downloadPdfFromFileSystem(@PathVariable Long idFilesOwner) throws IOException {
        byte[] pdfData = service.downloadFileFromFileSystem(idFilesOwner);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .body(pdfData);
    }

    @GetMapping("/download/{idFilesOwner}")
    public ResponseEntity<?> downloadFileFromSystem(@PathVariable Long idFilesOwner) throws IOException {
        byte[] fileData = service.downloadFileFromFileSystem(idFilesOwner);
        return ResponseEntity
                .status(HttpStatus.OK)
                .contentType(MediaType.APPLICATION_PDF)
                .body(fileData);
    }


}

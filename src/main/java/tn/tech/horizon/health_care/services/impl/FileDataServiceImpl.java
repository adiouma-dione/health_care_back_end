package tn.tech.horizon.health_care.services.impl;

import jakarta.annotation.PostConstruct;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import tn.tech.horizon.health_care.entites.FileData;
import tn.tech.horizon.health_care.repositories.FileDataRepository;
import tn.tech.horizon.health_care.services.FileDataService;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.Optional;

@Service
@AllArgsConstructor
public class FileDataServiceImpl implements FileDataService {

    private FileDataRepository fileDataRepository;
    private final String uploadDirectory = "src" + File.separator + "main" + File.separator + "resources" + File.separator + "static";

    @PostConstruct
    public void init() {
        File directory = new File(uploadDirectory);
        if (!directory.exists()) {
            directory.mkdirs();
        }
    }

    public String uploadFileToFileSystem(Long idFilesOwner, MultipartFile file) throws IOException {
        Path uploadPath = Paths.get(uploadDirectory, "img");
        Files.createDirectories(uploadPath);
        String fileName = file.getOriginalFilename();
        Path destinationPath = uploadPath.resolve(fileName);
        Files.copy(file.getInputStream(), destinationPath, StandardCopyOption.REPLACE_EXISTING);
        fileDataRepository.save(
            FileData.builder()
                .idFilesOwner(idFilesOwner)
                .name(fileName)
                .type(file.getContentType())
                .filePath("/img/" + fileName)
                .build()
        );

        return "File uploaded successfully: " + fileName;
    }

    public byte[] downloadFileFromFileSystem(Long idFilesOwner) throws IOException {
        Optional<FileData> optionalFileData = fileDataRepository.findByIdFilesOwner(idFilesOwner);

        if (optionalFileData.isPresent()) {
            FileData fileData = optionalFileData.get();
            String filePath = fileData.getFilePath();
            Path fullPath = Paths.get(uploadDirectory, filePath);
            return Files.readAllBytes(fullPath);
        } else {
            throw new FileNotFoundException("File not found: " + idFilesOwner);
        }
    }

}

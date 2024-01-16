package tn.tech.horizon.health_care.services;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public interface FileDataService {

    public void init();

    public String uploadFileToFileSystem(Long idOwner, MultipartFile file) throws IOException;

    public byte[] downloadFileFromFileSystem(Long idOwner) throws IOException;

}

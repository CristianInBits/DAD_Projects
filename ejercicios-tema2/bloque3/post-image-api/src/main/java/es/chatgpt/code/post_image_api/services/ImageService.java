package es.chatgpt.code.post_image_api.services;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.*;

import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImageService {

    private static final Path FILES_FOLDER = Paths.get(new File(".").getAbsolutePath(), "post-image-api", "images");

    private Path createFilePath(long id, Path folder) {
        return folder.resolve("image-" + id + ".jpg");
    }

    public void saveImage(String folderName, long id, MultipartFile imageFile) throws IOException {
        Path folder = FILES_FOLDER.resolve(folderName);
        Files.createDirectories(folder);
        Path newFile = createFilePath(id, folder);
        imageFile.transferTo(newFile);
    }

    public ResponseEntity<Object> createResponseFromImage(String folderName, long id) throws MalformedURLException {
        Path folder = FILES_FOLDER.resolve(folderName);
        Path path = createFilePath(id, folder);
        Resource file = new UrlResource(path.toUri());

        if (!Files.exists(path)) {
            return ResponseEntity.notFound().build();
        } else {
            return ResponseEntity.ok().header(HttpHeaders.CONTENT_TYPE, "image/jpeg").body(file);
        }
    }

    public void deleteImage(String folderName, long id) throws IOException {
        Path folder = FILES_FOLDER.resolve(folderName);
        Path file = createFilePath(id, folder);
        Files.deleteIfExists(file);
    }
}
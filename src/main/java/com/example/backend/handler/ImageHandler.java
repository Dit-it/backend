package com.example.backend.handler;

import jakarta.servlet.ServletContext;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.util.UUID;

@Component
@RequiredArgsConstructor
public class ImageHandler {

    @Value("${file.path.img}")
    private String imgSaveRootPath;
    private final ServletContext servletContext;

    /**
     * save image to save path
     * @param image : image file
     * @return : saved image path
     */
    public String saveImage(MultipartFile image) throws IOException {
        // make full file path
        String todayDateSubPath = imgSaveRootPath + getTodayDateSubPath();
        // make sub path directories if they didn't exist
        boolean result = makeSubDirectories(todayDateSubPath);
        if (!result) {
            throw new IOException("Failed to create subdirectories");
        }
        String fileFullPath = todayDateSubPath + "/" + getHashFileName() + "." + getExtension(image);
        image.transferTo(new File(fileFullPath));
        return fileFullPath;
    }

    private boolean makeSubDirectories(String dateSubPath) {
        File subDirectories = new File(dateSubPath);
        if (!subDirectories.exists()) {
            return subDirectories.mkdirs();
        }
        return true;
    }

    private String getTodayDateSubPath() {
        LocalDate today = LocalDate.now();
        int year = today.getYear();
        int month = today.getMonthValue();
        int day = today.getDayOfMonth();
        return "/" + year + "/" + month + "/" + day;
    }

    private String getHashFileName() {
        return UUID.randomUUID().toString();
    }

    private String getExtension(MultipartFile image) {
        return StringUtils.getFilenameExtension(image.getOriginalFilename());
    }
}

package com.edu.eduwise.service;

import com.edu.eduwise.model.Image;
import com.edu.eduwise.util.ImageUploadResponse;
import com.edu.eduwise.repo.ImageRepo;
import com.edu.eduwise.util.ImageUtil;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.Optional;

@Service
public class ImageService {


    private final ImageRepo imageRepo;

    public ImageService(ImageRepo imageRepo) {
        this.imageRepo = imageRepo;
    }

    public ImageUploadResponse uploadImage(MultipartFile file) throws IOException {

        imageRepo.save(Image.builder()
                .name(file.getOriginalFilename())
                .type(file.getContentType())
                .imageData(ImageUtil.compressImage(file.getBytes())).build());
            return new ImageUploadResponse("Image uploaded successfully: "+ file.getOriginalFilename() ,
                    HttpStatus.OK ,
                    LocalDateTime.now()
            );



    }

    @Transactional
    public Image getInfoByImageByName(String name) {
        Optional<Image> dbImage = imageRepo.findByName(name);

        return Image.builder()
                .name(dbImage.get().getName())
                .type(dbImage.get().getType())
                .imageData(ImageUtil.decompressImage(dbImage.get().getImageData())).build();

    }

    @Transactional
    public byte[] getImage(String name) {
        Optional<Image> dbImage = imageRepo.findByName(name);
        byte[] image = ImageUtil.decompressImage(dbImage.get().getImageData());
        return image;
    }


}

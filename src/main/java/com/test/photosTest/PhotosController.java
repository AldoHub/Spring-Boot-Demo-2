package com.test.photosTest;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.server.ResponseStatusException;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "api/v1/photos")
public class PhotosController {

    private final PhotoService photoService;

    @Autowired
    public PhotosController(PhotoService photoService) { this.photoService = photoService; }

    //dummy list
    private final List<Photo> photoList =  List.of(new Photo(1L, "test_file.jpeg", "jpeg"));

    @GetMapping
    public List<Photo> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @GetMapping("/{id}")
    public Optional<Photo> getPhotoById(@PathVariable Long id) {
        return photoService.getPhotoById(id);
    }

    @PostMapping("/add")
    public Photo addPhoto(@RequestPart("data") MultipartFile file) throws IOException {
        return photoService.addPhoto(file);
    }

    @DeleteMapping("/{id}")
    public Photo DeletePhotoById(@PathVariable Long id) {

        Photo photo = photoList.remove(0);
        if(photo == null){
            //return an exception
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }

        return photo;

    }

}

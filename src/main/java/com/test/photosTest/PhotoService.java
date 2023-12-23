package com.test.photosTest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Service
public class PhotoService {

    private final PhotoRepository photoRepository;

    @Autowired
    public PhotoService(PhotoRepository photoRepository) { this.photoRepository = photoRepository; }


    public List<Photo> getAllPhotos(){
        /*
        *
        Photo photo = photoList.get(0);
            if(photo == null){
                //return an exception
                throw new ResponseStatusException(HttpStatus.NOT_FOUND);
            }

        return photo;
        *
        *
        * */

        return photoRepository.findAll();
    }

    public Optional<Photo> getPhotoById(Long id){
        return photoRepository.findById(String.valueOf(id));
    }

    public Photo addPhoto(MultipartFile file) throws IOException {
        //create a new photo obj
        Photo newphoto = new Photo();
        //random ID
        //newphoto.setId();
        newphoto.setFileName(file.getOriginalFilename());
        newphoto.setMimeType(file.getContentType());
        newphoto.setData(file.getBytes()); // needs to throw an IOException

        //photoList.add(photo);
        photoRepository.save(newphoto);
        return newphoto;

    }




}

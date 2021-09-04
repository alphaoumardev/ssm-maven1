package com.ssm.maven.core.dao;

import com.ssm.maven.core.entity.Picture;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface PictureDao
{
     List<Picture> findPictures(Map<String, Object> map);

     Long getTotalPictures(Map<String, Object> map);

     int insertPicture(Picture picture);

     int updPicture(Picture picture);

     int delPicture(String id);

     Picture findPictureById(String id);
}

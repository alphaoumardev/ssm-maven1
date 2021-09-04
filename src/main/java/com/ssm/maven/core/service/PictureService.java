package com.ssm.maven.core.service;

import com.ssm.maven.core.entity.Picture;

import java.util.List;
import java.util.Map;

public interface PictureService
{
	 List<Picture> findPicture(Map<String, Object> map);

	 Long getTotalPicture(Map<String, Object> map);

	 int addPicture(Picture picture);

	 int updatePicture(Picture picture);

	 int deletePicture(String id);

	 Picture findById(String id);
}

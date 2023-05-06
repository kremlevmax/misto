package com.maxfromeverett.misto.dto;

import com.maxfromeverett.misto.entity.Image;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.SuperBuilder;
import org.springframework.web.multipart.MultipartFile;

@Data
@AllArgsConstructor
@SuperBuilder
public class ImageDto {
  private Long id;
  private MultipartFile imageFile;


  public static ImageDto fromImage(Image image) {
    return null;
  }
}

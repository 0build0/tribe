package com.cq.tribe.common;

import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

@Data
public class Media {
    private MultipartFile file;
    private String mediaDesc;
    private Integer cqId;
}

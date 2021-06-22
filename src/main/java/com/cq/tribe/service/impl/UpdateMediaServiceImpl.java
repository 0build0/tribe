package com.cq.tribe.service.impl;

import com.cq.tribe.service.UpdateMediaService;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.util.Auth;
import org.springframework.stereotype.Service;

import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

@Service
public class UpdateMediaServiceImpl implements UpdateMediaService {
    @Override
    public boolean updateMedia(InputStream inputStream,String name) {

        boolean result = true;

        Configuration config = new Configuration(Region.region1());
        UploadManager uploadManager = new UploadManager(config);
        String accessKey = "cp0ycHI57QxC0LrjHx6yR_E6hfZkEwfF585thf2Y";
        String secretKey = "8MnWaPV00mWOtMnbzJCOVxOJ0wmV7ZR9guiFwDB_";
        String bucket = "cqtribe";
        Auth auth = Auth.create(accessKey,secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(inputStream, name, upToken, null, null);
            System.out.println(response.bodyString());
        }catch (Exception e) {
            result = false;
            e.printStackTrace();
        }
        return result;

    }

    public void urlGenerate() throws UnsupportedEncodingException {
        String accessKey = "cp0ycHI57QxC0LrjHx6yR_E6hfZkEwfF585thf2Y";
        String secretKey = "8MnWaPV00mWOtMnbzJCOVxOJ0wmV7ZR9guiFwDB_";
        String bucket = "cqtribe";
        String fileName = "001";
        String domain = "http://quwnj69of.hb-bkt.clouddn.com";
        StringBuilder sb = new StringBuilder();
        sb.append(domain);
        sb.append("/");
        sb.append(URLEncoder.encode(fileName,"utf-8").replace("+","%20"));
        Auth auth = Auth.create(accessKey, secretKey);
        long expireInSeconds = 3600;
        String downloadUrl = auth.privateDownloadUrl(sb.toString(),expireInSeconds);
        System.out.println(downloadUrl);


    }

    public static void main(String[] args) {
        UpdateMediaServiceImpl a = new UpdateMediaServiceImpl();
       // a.updateMedia();
        try {
            a.urlGenerate();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}

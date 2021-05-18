package com.example.myphotoapp.service;

import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;


@Service
public class FileService {

    public boolean upload(MultipartFile file) throws IOException {

        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAUUJ5BQMZZOOABJ5Z", "D6bNftZyaWU6GZ+W9meNwzxhwSPxkAwC2y+hpsI/");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();
        try {
            ObjectMetadata metaData = new ObjectMetadata();
            metaData.setContentLength(file.getSize());
            metaData.setContentType(file.getContentType());
            s3.putObject("awsbackend2", file.getOriginalFilename(), file.getInputStream(), metaData);
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public S3Object getFile(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAUUJ5BQMZZOOABJ5Z", "D6bNftZyaWU6GZ+W9meNwzxhwSPxkAwC2y+hpsI/");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();

        return s3.getObject("awsbackend2", key);

    }

    public void deleteObject(String key){
        BasicAWSCredentials credentials = new BasicAWSCredentials("AKIAUUJ5BQMZZOOABJ5Z", "D6bNftZyaWU6GZ+W9meNwzxhwSPxkAwC2y+hpsI/");

        final AmazonS3 s3 = AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(credentials)).withRegion(Regions.CA_CENTRAL_1).build();

        System.out.println("Deleted the object "+s3);
        s3.deleteObject("awsbackend2",key);

    }

}


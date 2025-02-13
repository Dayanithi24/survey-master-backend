package com.example.surveymaster.question;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

import java.util.List;

@Data
public class FileUploadQuestion extends Question {

    private List<String> fileFormats;
    private int maximumNumberOfFiles;
    private String maximumFileSize;

    public List<String> getFileFormats() {
        return fileFormats;
    }

    public void setFileFormats(List<String> fileFormats) {
        this.fileFormats = fileFormats;
    }

    public int getMaximumNumberOfFiles() {
        return maximumNumberOfFiles;
    }

    public void setMaximumNumberOfFiles(int maximumNumberOfFiles) {
        this.maximumNumberOfFiles = maximumNumberOfFiles;
    }

    public String getMaximumFileSize() {
        return maximumFileSize;
    }

    public void setMaximumFileSize(String maximumFileSize) {
        this.maximumFileSize = maximumFileSize;
    }

    public FileUploadQuestion(List<String> fileFormats, int maximumNumberOfFiles, String maximumFileSize) {
        this.fileFormats = fileFormats;
        this.maximumNumberOfFiles = maximumNumberOfFiles;
        this.maximumFileSize = maximumFileSize;
    }

    @Override
    public String toString() {
        return "FileUploadQuestion{" +
                "fileFormats=" + fileFormats +
                ", maximumNumberOfFiles=" + maximumNumberOfFiles +
                ", maximumFileSize='" + maximumFileSize + '\'' +
                '}';
    }
}

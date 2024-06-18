package kp.cmsc.cmsc99.svc;

import java.util.Map;

import org.springframework.web.multipart.MultipartFile;

public interface Cmsc99010000Svc {
    public Map<String, String> uploadFile(MultipartFile multipartFile) throws Exception;
    public Map<String, String> download(String fileId) throws Exception;
}
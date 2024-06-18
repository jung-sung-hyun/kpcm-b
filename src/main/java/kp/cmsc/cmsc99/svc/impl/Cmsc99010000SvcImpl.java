package kp.cmsc.cmsc99.svc.impl;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import kp.cmsc.cmsc99.svc.Cmsc99010000Svc;

@Service
public class Cmsc99010000SvcImpl implements Cmsc99010000Svc {

    private String uploadPath = "C:\\Temp\\"; // TODO 설정 파일로 옮겨야함

    /**
     * @param : Cmsc98010000Vo vo
     * @throws Exception
     * @Discription 1. 개요
     * 메소드에 대한 간단한 개요 기능등을 기술한다.
     * 2. 주요처리로직
     * 메소드에 대한 주요 처리 로직등을 기술 한다.
     * 3. 예외처리
     * 예외처리시 전처리 후처리등의 내용을 기술 한다.
     * @Author: 홍길동
     * @Date : 2024-01-07.13
     * @return: ModelAndView
     */
    @Override
    public Map<String, String> uploadFile(MultipartFile multipartFile) throws Exception {
        Map<String, String> resultMap = new HashMap<String, String>();

        // 2. 서버에 파일 저장 & DB에 파일 정보(fileinfo) 저장
        // - 동일 파일명을 피하기 위해 random값 사용
        String originalFilename = multipartFile.getOriginalFilename();

        String saveFileExt = originalFilename.substring(originalFilename.lastIndexOf(".") + 1);
        String uuid = UUID.randomUUID().toString();
        String saveFileName = uuid + "." + saveFileExt;

        String saveFileFullPath = uploadPath + saveFileName;

        //log.debug("originalFilename::{}", originalFilename);
        //log.debug("saveFileName    ::{}", saveFileName);

        // 2-1.서버에 파일 저장
        multipartFile.transferTo(new File(saveFileFullPath));

        // 2-2. DB에 정보 저장
        // TODO 공통파일 업로드 다운로드 기능 구현후 작성
//        String contentType = multipartFile.getContentType();
//
//        FileInfoRegister fileInfoRegister = FileInfoRegister.builder()
//                .fileName(originalFilename)
//                .saveFileName(saveFileName)
//                .contentType(contentType)
//                .deleteFlag(notDeleted).build();
//
//        String fileInfoId = fileInfoDao.insert(fileInfoRegister);

        //log.debug("saveFileName::"+saveFileName);
        String fileId = saveFileName; //saveFileName.substring(0, saveFileName.indexOf(".")); // TODO : 공통파일 업로드 다운로드 기능 구현후 재작성
        //log.debug("fileId::"+fileInfoId);

        resultMap.put("fileId", fileId);

        return resultMap;
    }

    @Override
    public Map<String, String> download(String fileId) throws Exception {
        Map<String, String> resultMap = new HashMap<String, String>();

        resultMap.put("saveFileName", fileId); // TODO : 공통파일 업로드 다운로드 기능 구현후 재작성
        resultMap.put("originalFileName", fileId); // TODO : 공통파일 업로드 다운로드 기능 구현후 재작성

        return resultMap;
    }

}
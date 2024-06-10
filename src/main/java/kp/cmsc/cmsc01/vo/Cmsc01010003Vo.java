package kp.cmsc.cmsc01.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "cmsc01010003Vo")
public class Cmsc01010003Vo {
    private int    id      ;// 그리드 리스트 ID 반드시필요
    private String userCode;// 사용자코드
    private String userName;// 사용자명
    private int    idx     ;// 게시글인텍스
    private String title   ;// 게시글제목
    private String contents;// 게시글내용
    private String updDt   ;// 수정일자
}
package kp.cmsc.cmsc01.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "cmsc01010001Vo")
public class Cmsc01010001Vo {
    private String title   ;// 게시글제목
    private String contents;// 게시글내용
}
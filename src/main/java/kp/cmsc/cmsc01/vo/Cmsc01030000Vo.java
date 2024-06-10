package kp.cmsc.cmsc01.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

@Data
@Alias(value = "cmsc01030000Vo")
public class Cmsc01030000Vo {
    // 메뉴관리
    private String menuNms  ;// 들여쓰기 메뉴명
    private int levels      ;// 함수레벨표시
    private String menuId   ;// 메뉴아이디
    private String sysSeCd  ;// 시스템구분코드
    private String upMenuId ;// 상위메뉴아이디
    private String menuNm   ;// 메뉴명
    private int menuSeq     ;// 메뉴순번
    private String menuExpln;// 메뉴설명
    private String menuLvl  ;// 메뉴레벨
    private String prgrmId  ;// 프로그램아이디
    private String prgrmPath;// 프로그램경로명
    private String urlAddr  ;// URL주소
    private String useYn    ;// 사용여부
    private String connectHash    ;// connect hash code

}
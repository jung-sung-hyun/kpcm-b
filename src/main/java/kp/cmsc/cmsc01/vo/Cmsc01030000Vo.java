package kp.cmsc.cmsc01.vo;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Alias(value = "cmsc01030000Vo")
public class Cmsc01030000Vo {
    // 메뉴관리
    @Schema(description = "회원 인증정보-OUT")
    private String connectHash;// connect hash code
    @Schema(description = "들여쓰기 메뉴명-OUT")
    private String menuNms    ; // 들여쓰기 메뉴명
    @Schema(description = "함수레벨표시-OUT")
    private int    levels     ; // 함수레벨표시
    @Schema(description = "메뉴아이디-OUT")
    private String menuId     ; // 메뉴아이디
    @Schema(description = "시스템구분코드-OUT")
    private String sysSeCd    ; // 시스템구분코드
    @Schema(description = "상위메뉴아이디-OUT")
    private String upMenuId   ; // 상위메뉴아이디
    @Schema(description = "함수레벨표시-OUT")
    private String menuNm     ; // 메뉴명
    @Schema(description = "메뉴순번-OUT")
    private int    menuSeq    ; // 메뉴순번
    @Schema(description = "메뉴설명-OUT")
    private String menuExpln  ; // 메뉴설명
    @Schema(description = "메뉴레벨-OUT")
    private String menuLvl    ; // 메뉴레벨
    @Schema(description = "프로그램아이디-OUT")
    private String prgrmId    ; // 프로그램아이디
    @Schema(description = "프로그램경로명-OUT")
    private String prgrmPath  ; // 프로그램경로명
    @Schema(description = "URL주소-OUT")
    private String urlAddr    ; // URL주소
    @Schema(description = "사용여부-OUT")
    private String useYn      ; // 사용여부
    @Schema(description = "로그인오류건수-OUT")
    private int    lgnErrNocs ; // 로그인오류건수

}
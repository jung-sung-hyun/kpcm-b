package kp.cmsc.cmsc01.vo;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Alias(value = "cmsc01020000Vo")
public class Cmsc01020000Vo {
    private String mbrId              ;// 회원아이디

    @Schema(description = "회원명")
    @NotNull(message = "........")
    private String mbrNm              ;// 회원명
    private String mblTelno           ;// 휴대전화번호
    // 회원정보
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    @Schema(description = "회원아이디", nullable = false, example = "ssjung99@gmail.com")
    private String mbrEmlAddr         ;// 회원이메일주소
    // 회원정보
    @NotNull(message = "Name cannot be null")
    @Size(min = 2, message = "Name not be less than two characters")
    @Schema(description = "비밀번호", nullable = false)
    private String userPswd           ;// 비밀번호
    private String ciVl               ;// CI값
    private String joinDt             ;// 가입일시
    private String mbrSttsCd          ;// 회원상태코드
    private String prvcClctAgreYn     ;// 개인정보수집동의여부
    private String pltfUtztnTrmsAgreYn;// 플랫폼이용약관동의여부
    private String mngrYn             ;// 관리자여부
    private String acntClsgYn         ;// 계정폐쇄여부
    private String rgtrId             ;// 등록자아이디
    private String regDt              ;// 등록일시
    private String rgtrIpAddr         ;// 등록자IP주소
    private String mdfrId             ;// 수정자아이디
    private String mdfcnDt            ;// 수정일시
    private String mdfrIpAddr         ;// 수정자IP주소
    private String bzmnSeCd           ;// 사업자구분코드
    private String authrtIdS          ;// 회원의 권한정보들
    private String loginYn            ;// 로그인가능여부
    private int    lgnerrNocs         ;// 로그인오류건수
    private String rejTimeYn          ;// 로그인 가능시간 여부
    private String connectHash        ;// connect hash code
    private String message            ;// 화면에 메세지 전달


}
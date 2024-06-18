package kp.cmsc.cmsc01.vo;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import kp.cmsc.cmsc00.vo.Cmsc00000000Vo;
import lombok.Data;
@Tag(
        name        = "관리자 로그인 Value Object[cmsc01020000Vo]",
        description = "설명: 사용자의 로그인정보의 데이터 인터페이스 관리한다."
)
@Data
@Alias(value = "cmsc01020000Vo")
public class Cmsc01020000Vo extends Cmsc00000000Vo{
    // 회원정보
    @Schema(description = "회원 이메일-OUT")
    private String mbrEmlAddr         ;// 회원이메일주소
    @Schema(description = "비밀번호-OUT")
    private String userPswd           ;// 비밀번호
    @Schema(description = "회원 ID-OUT")
    private String mbrId              ;// 회원아이디
    @Schema(description = "회원명-OUT")
    private String mbrNm              ;// 회원명
    @Schema(description = "휴대전화번호-OUT")
    private String mblTelno           ;// 휴대전화번호
    @Schema(description = "CI값-OUT")
    private String ciVl               ;// CI값
    @Schema(description = "가입일시-OUT")
    private String joinDt             ;// 가입일시
    @Schema(description = "회원상태코드-OUT")
    private String mbrSttsCd          ;// 회원상태코드
    @Schema(description = "개인정보수집동의여부-OUT")
    private String prvcClctAgreYn     ;// 개인정보수집동의여부
    @Schema(description = "플랫폼이용약관동의여부-OUT")
    private String pltfUtztnTrmsAgreYn;// 플랫폼이용약관동의여부
    @Schema(description = "관리자여부-OUT")
    private String mngrYn             ;// 관리자여부
    @Schema(description = "계정폐쇄여부-OUT")
    private String acntClsgYn         ;// 계정폐쇄여부
    @Schema(description = "등록자아이디-OUT")
    private String rgtrId             ;// 등록자아이디
    @Schema(description = "등록일시-OUT")
    private String regDt              ;// 등록일시
    @Schema(description = "등록자IP주소-OUT")
    private String rgtrIpAddr         ;// 등록자IP주소
    @Schema(description = "수정자아이디-OUT")
    private String mdfrId             ;// 수정자아이디
    @Schema(description = "수정일시-OUT")
    private String mdfcnDt            ;// 수정일시
    @Schema(description = "수정자IP주소-OUT")
    private String mdfrIpAddr         ;// 수정자IP주소
    @Schema(description = "사업자구분코드-OUT")
    private String bzmnSeCd           ;// 사업자구분코드
    @Schema(description = "회원의 권한정보들-OUT")
    private String authrtIdS          ;// 회원의 권한정보들
    @Schema(description = "로그인가능여부-OUT")
    private String loginYn            ;// 로그인가능여부
    @Schema(description = "로그인오류건수-OUT")
    private int    lgnerrNocs         ;// 로그인오류건수
    @Schema(description = "로그인 가능시간 여부-OUT")
    private String rejTimeYn          ;// 로그인 가능시간 여부
    @Schema(description = "사용자인증키-OUT")
    private String connectHash        ;// connect hash code
    @Schema(description = "화면에 메세지 전달-OUT")
    private String message            ;// 화면에 메세지 전달
    @Schema(description = "세션IP-OUT")
    public String sessionIp;//세션IP

}
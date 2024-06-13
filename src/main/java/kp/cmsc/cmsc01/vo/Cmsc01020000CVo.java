package kp.cmsc.cmsc01.vo;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Alias(value = "cmsc01020000CVo")
public class Cmsc01020000CVo {
    @Schema(description = "회원 ID-IN")
    private String mbrEmlAddr         ;// 회원이메일주소
    @Schema(description = "비밀번호-IN")
    private Cmsc01020000Vo cmsc01020000Vo;
}
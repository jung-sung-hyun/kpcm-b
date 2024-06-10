package kp.cmsc.cmsc98.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias(value = "cmsc98010000VO")
public class Cmsc98010000Vo {
    // input
    private String codeCd;

    // output
    private String grpCd;
    private String codeNm;
}
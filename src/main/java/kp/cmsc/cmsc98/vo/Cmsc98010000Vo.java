package kp.cmsc.cmsc98.vo;

import org.apache.ibatis.type.Alias;

import lombok.Data;

import java.util.List;

@Data
@Alias(value = "cmsc98010000VO")
public class Cmsc98010000Vo {
    // output
    private String msgCd; // input, output
    private String msgCn;
    private String msgTypeCd;
    private String useYn;
    private String rnum;
    private List<Cmsc98010000Vo> list;
    private String regStatus;
}
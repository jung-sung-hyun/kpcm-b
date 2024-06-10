package kp.cmsc.cmsc00.vo;
import org.apache.ibatis.type.Alias;

import lombok.Data;
@Data
@Alias(value = "cmsc00000000VO")
public class Cmsc00000000Vo{
    private String message;//화면에 메세지 전달
}
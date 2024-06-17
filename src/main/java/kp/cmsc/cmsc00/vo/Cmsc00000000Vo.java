package kp.cmsc.cmsc00.vo;
import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
@Data
@Alias(value = "cmsc00000000VO")
public class Cmsc00000000Vo{
    @Schema(description = "화면에 메세지 전달-OUT")
    private String message;//화면에 메세지 전달
    @Schema(description = "사용자권한-OUT")
    private String authrtId;//사용자권한ID
    @Schema(description = "사용자인증Hash-OUT")
    private String connectHash;//사용자인증Hash
    @Schema(description = "버튼명칭-OUT")
    private String btnNm;//버튼명칭
    @Schema(description = "버튼코드-OUT")
    private String btnCd;//버튼코드
    @Schema(description = "메뉴-OUT")
    private String menuId;//메뉴ID




}
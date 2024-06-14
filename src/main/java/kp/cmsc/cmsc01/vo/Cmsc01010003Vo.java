package kp.cmsc.cmsc01.vo;

import org.apache.ibatis.type.Alias;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

@Data
@Alias(value = "cmsc01010003Vo")
public class Cmsc01010003Vo {
    @Schema(description = "그리드 리스트 ID 반드시필요-OUT")
    private int    id      ;// 그리드 리스트 ID 반드시필요
    @Schema(description = "사용자코드-OUT")
    private String userCode;// 사용자코드
    @Schema(description = "사용자명-OUT")
    private String userName;// 사용자명
    @Schema(description = "게시글인텍스-OUT")
    private int    idx     ;// 게시글인텍스
    @Schema(description = "게시글제목-OUT")
    private String title   ;// 게시글제목
    @Schema(description = "게시글내용-OUT")
    private String contents;// 게시글내용
    @Schema(description = "수정일자-OUT")
    private String updDt   ;// 수정일자
}
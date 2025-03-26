
package miniproject.DTO;

import org.springframework.stereotype.Repository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Repository("Weak_infoDTO")
public class Weak_infoDTO {
    int tidx;             // 자동 증가값
    String t_name;        // 이름
    String t_adress;      // 주소
    String t_type;        // 타입 (char)
    String t_rentype;     // 임대 유형 (enum)
    String t_saledate;    // 분양일
    String t_indate;      // 입주일
    String t_img;         // 이미지 (파일명)
    String t_hs;          // 분양정보
    String t_hstr;        // 히스토리
    String t_unit;        // 유닛
    String t_ctrcomp;     // 건설사
    String t_current;     // 현재 상태 (enum)
}
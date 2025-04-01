package miniproject.DTO;


import org.springframework.stereotype.Repository;


import lombok.Getter;
import lombok.Setter;


@Repository("ReservationDTO")
@Getter
@Setter
public class ReservationDTO {
    public Integer wvidx;
    public String wvt_name;
    public Long wtidx;
    public String wv_date;  // DATETIME을 LocalDateTime으로 매핑
    public String wv_time;  // TIME을 LocalTime으로 매핑
    public String wv_name;
    public String wv_number;
    public String wv_people;  // ENUM('1', '2')는 String으로 처리
	
}

package miniproject.DAO;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import miniproject.DTO.ReservationDTO;
import miniproject.Mapper.Reservation_mapper;


@Repository("Reservation_DAO")
public class Reservation_DAO implements Reservation_mapper {
	
	@Resource(name="template")
	public SqlSessionTemplate reserv_st;

	@Override
	public int apply_reservation(ReservationDTO resdto) {
		
		int result = this.reserv_st.insert("apply_reservation",resdto);
				
		return result;
	}
	@Override
	public List<ReservationDTO> check_visit(Map<Object, Object> check_visit) {	//인덱스에서 weektails 접속시 예약여부 확인

		List<ReservationDTO> check_result = this.reserv_st.selectList("check_visit",check_visit);
		return check_result;
	}
	
	@Override
	public List<ReservationDTO> select_result(Map<Object, Object> tidxAndwv_name) {
		
		 List<ReservationDTO> check_reserv = this.reserv_st.selectList("check_reserv",tidxAndwv_name);
		return check_reserv;
	}
}

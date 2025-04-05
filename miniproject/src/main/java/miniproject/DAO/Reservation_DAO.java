package miniproject.DAO;

import java.util.HashMap;
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

	
	//방문예약 취소
	@Override
	public int cancel_reslist(ReservationDTO resdto) {
		int cancel_result = this.reserv_st.delete("cancel_reslist",resdto);
		
		return cancel_result;
	}
	
	
	@Override	//reservation_list(방문예약) 출력
		public List<ReservationDTO> selet_resAll(Map<String, String> login_info) {
		List<ReservationDTO> all_resList = this.reserv_st.selectList("selet_resAll",login_info);
		return all_resList;
		}	
	
	
	//방문 예약 등록 페이지
	@Override
	public int apply_reservation(ReservationDTO resdto) {
		
		int result = this.reserv_st.insert("apply_reservation",resdto);
				
		return result;
	}
	
	//weektails 접속시 예약여부 확인
	@Override
	public List<ReservationDTO> check_visit(Map<Object, Object> check_visit) {	//인덱스에서 weektails 접속시 예약여부 확인

		List<ReservationDTO> check_result = this.reserv_st.selectList("check_visit",check_visit);
		return check_result;
	}
	
	//방문 예약 정보 확인
	@Override
	public List<ReservationDTO> select_result(Map<Object, Object> tidxAndwv_name) {
		
		 List<ReservationDTO> check_reserv = this.reserv_st.selectList("check_reserv",tidxAndwv_name);
		return check_reserv;
	}
}

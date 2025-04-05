package miniproject.Mapper;



import java.util.List;
import java.util.Map;

import miniproject.DTO.ReservationDTO;

public interface Reservation_mapper {
		
		public int apply_reservation(ReservationDTO resdto);
		public List<ReservationDTO> select_result(Map<Object, Object> tidxAndwv_name);
		public List<ReservationDTO> check_visit(Map<Object, Object> check_vlist);
		public List<ReservationDTO> selet_resAll(Map<String, String> login_info);
		public int cancel_reslist(ReservationDTO resdto);
	
}

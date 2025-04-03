package miniproject.DAO;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

import miniproject.DTO.Md_boardDTO;
import miniproject.Mapper.Md_board_mapper;

@Repository("Md_boardDAO")
public class Md_boardDAO implements Md_board_mapper {

	@Resource(name = "template")
	private SqlSessionTemplate mdb_st;

	//검색된 게시물
	@Override
	public List<Md_boardDTO> search_mbpaged(String m_search, Integer startIndex, Integer pageSize) {
		
		Map<Object, Object> params = new HashMap<>();
		params.put("m_search", m_search);
		params.put("startIndex", startIndex);	
		params.put("pageSize", pageSize);	
		
		List<Md_boardDTO> mdboard_result = this.mdb_st.selectList("search_mbpaged",params);
		
		return mdboard_result;
	}
	
	//검색된 게시물 총 갯수
	@Override
	public int searchTotal(String m_search) {
		
		int totalCount = this.mdb_st.selectOne("searchTotal",m_search);
		return totalCount;
	}
	
	//추천분양 정보 게시판 리스트
	@Override			
	public List<Md_boardDTO> select_mboard(int startIndex, int pageSize) {
		Map<Object, Object> params = new HashMap<>();
		params.put("startIndex", startIndex);	//시작값
		params.put("pageSize", pageSize);		//페이지당 게시물 갯수 -> 현재 10개씩 
		List<Md_boardDTO> mb_result = this.mdb_st.selectList("select_mboard", params);
		return mb_result;
	}
	
	
	
	//게시물 총 갯수 select
	@Override
	public int getTotalCount() { 
		return this.mdb_st.selectOne("getTotalCount");
	}
	
	//게시물 조회수 증가
	@Override
	public void increaseViews(Long midx) { 
		this.mdb_st.update("increaseViews" , midx);
	}
	
	//상세 게시물 정보 가져오는 함수
	@Override
	public List<Md_boardDTO> getPost(Long midx) { 
		List<Md_boardDTO> post = this.mdb_st.selectList("getPost",midx);
	
		return post;
	}
	

}
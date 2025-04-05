package miniproject.Mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import miniproject.DTO.Md_boardDTO;

@Mapper
public interface Md_board_mapper {
	public List<Md_boardDTO> select_mboard(int startIndex, int pageSize);
	
	 // 전체 게시물 개수 조회
    public int getTotalCount();
	
    // 조회수 증가
    public void increaseViews(Long midx);
    
    // 게시물 정보 가져오기
    public List<Md_boardDTO> getPost(Long midx);
    
    
    //검색된 게시물 페이지
    public List<Md_boardDTO> search_mbpaged(String m_search, Integer startIndex, Integer pageSize); 
	
	//검색 게시물 총 갯수
    public int searchTotal(String m_search);

    public int Insert_mdwrite(Md_boardDTO mdbw_dto);


}

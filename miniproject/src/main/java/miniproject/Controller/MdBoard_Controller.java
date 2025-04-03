package miniproject.Controller;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import miniproject.DAO.Md_boardDAO;
import miniproject.DTO.Md_boardDTO;

@Controller
public class MdBoard_Controller {

    // DAO 객체 주입 (데이터베이스와 연결된 DAO 사용)
    @Resource(name="Md_boardDAO")
    private Md_boardDAO mboardDAO;

    // 부동산 게시판 페이지 요청을 처리하는 메서드 & 검색기능
    @GetMapping("/realty/md_board.do")
    public String md_board(
            Model model,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "m_search", required = false, defaultValue = "") String m_search) { 
        
        // 한 페이지에 표시할 게시글 개수 설정
        Integer pageSize = 10;  
        Integer startIndex = (page - 1) * pageSize;  
        Integer totalCount;

        List<Md_boardDTO> mdboard_result;
        
        //m_search의 null 여부 확인
        boolean isSearch = (m_search != null && !m_search.trim().isEmpty());
        
        if (isSearch) {
            // 검색된 게시글 가져오기 (페이징 적용)
            mdboard_result = mboardDAO.search_mbpaged(m_search, startIndex, pageSize);
            totalCount = mboardDAO.searchTotal(m_search); // 검색된 게시글 개수
            
        } else {
            // 전체 게시글 가져오기
            mdboard_result = mboardDAO.select_mboard(startIndex, pageSize);
            totalCount = mboardDAO.getTotalCount(); // 전체 게시글 개수
        }

        // 총 페이지 수 계산
        int totalPages = (int) Math.ceil((double) totalCount / pageSize);

        // JSP에서 사용할 데이터를 Model 객체에 저장
        model.addAttribute("mdboard", mdboard_result); // 게시글 목록
        model.addAttribute("search_check", isSearch ? "yesdata" : "nodata"); // 검색 여부
        model.addAttribute("m_check", mdboard_result.isEmpty() ? "nodata" : "yesdata"); // 데이터 존재 여부
        model.addAttribute("currentPage", page); // 현재 페이지 번호
        model.addAttribute("totalCount", totalCount); // 전체 게시물 개수
        model.addAttribute("totalPages", totalPages); // 총 페이지 개수
        model.addAttribute("pageSize", pageSize); // 페이지당 게시물 개수
        model.addAttribute("m_search", m_search); // 검색어 유지

        return null;  
    }
    
    
    //부동산 게시판 상세 뷰 함수
    @GetMapping("/realty/md_board_view.do")
    public String md_board_view(@RequestParam("midx") Long midx, Model mbv_model) {
        // 조회수 증가
        mboardDAO.increaseViews(midx);
        
        // 게시물 정보 가져오기
        List<Md_boardDTO> post = mboardDAO.getPost(midx);
        
        // 모델에 추가하여 뷰에서 사용 가능하게 함
        mbv_model.addAttribute("post", post);

        return null; // 상세 페이지로 이동
    }
    
}

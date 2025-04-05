package miniproject.Controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.File;
import java.io.PrintWriter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;



import Model.File_rename;
import miniproject.DAO.Md_boardDAO;
import miniproject.DTO.Md_boardDTO;

@MultipartConfig
@Controller
public class MdBoard_Controller {

    // DAO 객체 주입 (데이터베이스와 연결된 DAO 사용)
    @Resource(name="Md_boardDAO")
    private Md_boardDAO mboardDAO;
    
    @Resource(name="File_rename")
	File_rename fname;	//파일명을 개발자가 원하는 형태로 변경
    
    PrintWriter pw = null;	// 필드 생성 !
	
    
    @PostMapping("/realty/md_board_writeok.do")
    public String md_board_writeok(
    		Md_boardDTO mdw_dto,
    		@RequestParam("mdb_image") MultipartFile mdb_image,
    		HttpServletRequest req, 
    		HttpServletResponse res
    		) {
    	
    	res.setContentType("text/html;charsert=utf-8");
    	
    	String file_new = null;
	    if(mdb_image.getSize() > 0) {
	    	
	    	try {
	    		file_new = this.fname.rename(mdb_image.getOriginalFilename());
	    		//웹 디렉토리 생성한 파일명으로 저장하는 코드
	    		String url = req.getServletContext().getRealPath("/mini_mdw_upload/");
	    		
	    		FileCopyUtils.copy(mdb_image.getBytes(),new File(url + file_new));
	    		mdw_dto.setM_file_url("/upload/" + file_new); //웹디렉토리 경로 및 파일명
	    		mdw_dto.setM_file_new(file_new);		//중복 방지 위해 파일명 변경값
	    		mdw_dto.setM_file_ori(mdb_image.getOriginalFilename());	//사용자가 적용한 파일명
	    		
	    		int mdwrite_result = this.mboardDAO.Insert_mdwrite(mdw_dto);
	    		
	    		this.pw = res.getWriter();
	    		if(mdwrite_result > 0) {
	    			this.pw.print("<script>"
	    					+ "alert('정상적으로 게시물이 등록 되었습니다.');"
	    					+ "location.href='./md_board.do';"
	    					+ "</script>");
	    		}
	    		else {
	    			this.pw.print("<script>"
	    					+ "alert('게시물 등록에 실패했습니다. 입력 내용을 확인하고 다시 시도해주세요.');"
	    					+ "history.go(-1);"
	    					+ "</script>");
	    		}
				
			}
	    	catch(Exception e) {
				System.out.println("추천 게시물 등록 오류발생" + e);
			}
	    	finally {
				this.pw.close();
			}
	    }
		
	
    	return null;
    }
    
    
    
    //(시작) 부동산 게시판 페이지 요청을 처리하는 메서드 & 검색기능///////////////////////////
    @GetMapping("/realty/md_board.do")
    public String md_board(
            Model model,
            @RequestParam(value = "page", required = false, defaultValue = "1") int page,
            @RequestParam(value = "m_search", required = false, defaultValue = "") String m_search) { 

        try {
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

        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("error", "게시판 정보를 가져오는 중 오류가 발생했습니다.");
        }

        return null;  
    }

    //(끝) 부동산 게시판 페이지 요청을 처리하는 메서드 & 검색기능///////////////////////////
    
    
    //부동산 게시판 상세 뷰 함수
    @GetMapping("/realty/md_board_view.do")
    public String md_board_view(@RequestParam("midx") Long midx, Model mbv_model) {
    	  try {
    	        // 조회수 증가
    	        mboardDAO.increaseViews(midx);
    	        
    	        // 게시물 정보 가져오기
    	        List<Md_boardDTO> post = mboardDAO.getPost(midx);
    	        
    	        // 모델에 추가하여 뷰에서 사용 가능하게 함
    	        mbv_model.addAttribute("post", post);
    	        
    	    } catch (Exception e) {
    	        e.printStackTrace();
    	        mbv_model.addAttribute("error", "게시물 상세 정보를 불러오는 중 오류가 발생했습니다.");
    	    }

    	    return null; // 상세 페이지로 이동
    }
    
}

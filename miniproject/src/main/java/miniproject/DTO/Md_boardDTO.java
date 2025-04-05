package miniproject.DTO;

import lombok.Data;

@Data
public class Md_boardDTO {
  
	//DTO
   public long midx;          	  // 게시글 고유 ID
   public String m_title;     	  // 게시글 제목
   public String m_writer;    	  // 작성자 이름
   public String m_content;    	 // 게시글 내용
   public long m_views;          // 조회수
   public String m_created_at; 	// 게시글 작성일
   
   //VO
   public String m_file_ori;	//사용자가 적용한 파일명
   public String m_file_new;	//중복 방지 위해 파일명 변경값
   public String m_file_url;	//웹디렉토리 경로 및 파일명

}

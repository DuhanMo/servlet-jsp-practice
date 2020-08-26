package com.kh.jsp.board.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

import com.kh.jsp.board.model.service.BoardService;
import com.kh.jsp.board.model.vo.Board;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

/**
 * Servlet implementation class BoardUpdateServlet
 */
@WebServlet("/bUpdate.bo")
public class BoardUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 1. 전송할 최대 크기 설정
		int maxSize = 1024*1024*10; // 10MB
		// 2. multipart/form-data 형식으로 전송되었는지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			request.setAttribute("msg", "multipart를 통한 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		// 3. 웹 상의 루트 경로 찾기
		String root = request.getServletContext().getRealPath("/");
		String savePath = root+"resources/boardUploadFiles";
		// 4. 실제 담아온 파일 기타 정보를 활용해서 MultipartRequest 생성
		MultipartRequest mrequest = new MultipartRequest(request
													, savePath
													, maxSize
													,"UTF-8"
													,new DefaultFileRenamePolicy());
		
		// 5. 기본 전송값 처리하기
		String title = mrequest.getParameter("title");
		String content = mrequest.getParameter("content");
		int bno = Integer.parseInt(mrequest.getParameter("bno"));
		
		// 6. 전송된 파일 vo에 담기
		Board b = new Board();
		b.setBno(bno);
		b.setBtitle(title);
		b.setBcontent(content);
		b.setBoardfile(mrequest.getFilesystemName("file"));
		
		int result = new BoardService().updateBoard(b);
		
		if(result>0) {
			response.sendRedirect("selectOne.bo?bno="+bno);
		}else {
			request.setAttribute("msg", "게시글 수정 실패!");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

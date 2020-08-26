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
 * Servlet implementation class BoardInsertServlet
 */
@WebServlet("/bInsert.bo")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// http://www.servlets.com/cos/ --> 사이트에서 cos.jar파일을 WEB-INF 밑에 lib폴더에 추가
		// 1. 전송할 최대 크기 설정하기
		// 10MB ->  Byte크기로 변환하기
		// 1024 Byte-> 1KB / 1024KB ->1MB
		// 1024 * 1024 * 10
		int maxSize = 1024*1024*10; // 10MB
		
		// 2. multipart/form-data형식으로 전송되었는지 확인
		if(!ServletFileUpload.isMultipartContent(request)) {
			// 만약 올바른 multipart/form-data로 전송되지 않았을 경우
			// 에러페이지로 이동 시킨다.
			request.setAttribute("msg", "multipart를 통한 전송이 아닙니다.");
			request.getRequestDispatcher("views/common/errorPage.jsp").forward(request, response);
		}
		
		// 3. 웹 상의 루트(최상위 경로)경로를 활용하여 저장할 폴더의 위치 지정하기
		String root = request.getServletContext().getRealPath("/"); // D:\H_PM\webWorkspace\firstWebProject\web\
		System.out.println("최상위 경로 : " + root);
		// 게시판의 첨부파일을 저장할 폴더 이름 지정
		String savePath  = root + "resources/boardUploadFiles";
		
		// 4. 실제 담아온 파일 기타정보들을 활용하여 request->MulipartRequest
		//    MultipartRequest 생성하기
		MultipartRequest mrequest = new MultipartRequest(
											request, // 변경하기 위한 원본 객체
											savePath,// 파일 저장경로
											maxSize, // 저장할 파일의 최대 크기
											"UTF-8", // 저장할 문자셋 설정
											new DefaultFileRenamePolicy()
											// 동일한 이름의 파일을 저장했을 경우
											// 기존의 파일과 구분하기 위해 
											// 새로운 파일명 뒤에 숫자를 붙이도록 규칙만들었다.
											);
		// 파일 업로드 로직 실시
		// 5-1. 기본 전송값 처리하기
		String title= mrequest.getParameter("title");
		String content= mrequest.getParameter("content");
		String writer = mrequest.getParameter("userId");
		
		// 5-2. 전송된 파일 처리하기
		// 
		String fileName = mrequest.getFilesystemName("file");
		
		// 6. 전송된 파일 VO에 담아 서비스로 전달
		Board b = new Board();
		b.setBtitle(title);
		b.setBcontent(content);
		b.setBwriter(writer);
		b.setBoardfile(fileName);
		
		// 7. 서비스 결과 처리
		int result = new BoardService().insertBoard(b);
	
		if(result > 0) {
			response.sendRedirect("selectList.bo");
		}else {
			request.setAttribute("msg", "게시글 작성 실패");
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

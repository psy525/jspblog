package blog;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.ibatis.session.SqlSession;

import file.FileDTO;


@WebServlet("/register")
@MultipartConfig(maxFileSize = 10485760)
public class BlogRegisterServlet extends HttpServlet {
	private static final String FILE_PATH = "c:\\Users\\pc25\\upload\\";
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getRequestDispatcher("/WEB-INF/views/blog/register.jsp").forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		String writer = req.getParameter("writer");

		Part filesPart = req.getPart("files");
		
		//파일 정보 넣어주기
		List<FileDTO> fileList=new ArrayList<FileDTO>();
		
		//첨부파일이 있을 경우
		if(filesPart !=null && filesPart.getSize()>0 ) {
			// 실제 데이터베이스에 저장될 내용
			long fileSize = filesPart.getSize();//첨부파일의 용량(크기) 
			String originalName = filesPart.getSubmittedFileName();//첨부파일이름 
			String contentType = filesPart.getContentType();//첨부파일의 컨텐츠 타입
			System.out.println("업로드된 파일 크기: " +fileSize);
			System.out.println("업로드된 파일 이름: " +originalName);
			System.out.println("업로드된 파일 컨텐츠 타입: " +contentType);
			String fileName = UUID.randomUUID().toString();
			filesPart.write(FILE_PATH + fileName);
			fileList.add(new FileDTO(FILE_PATH, fileName, originalName, fileSize));
			
		}
		
		
		BlogDTO board = new BlogDTO(writer, title, content);	
		board.setFileList(fileList);
		
		ServletContext context = req.getServletContext();
		SqlSession session=(SqlSession) context.getAttribute("sqlSession");
		BlogService service=BlogService.getInstance(session);
		
		int registBoard = service.registerBoard(board);
		if (registBoard > 0) {
			resp.sendRedirect(req.getContextPath() +"/list");
		} else {
			req.setAttribute("msg", "게시글 등록 실패!");
			req.getRequestDispatcher("/WEB-INF/views/log/register.jsp").forward(req, resp);
		}
	}
}

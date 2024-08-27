package blog;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import file.FileDTO;

public class BlogService {
	private static BlogService instance=new BlogService();
	private static BlogMapper mapper;
	
	public BlogService() {
		
	}
	
	public static BlogService getInstance(SqlSession session) {
		mapper=session.getMapper(BlogMapper.class);
		return instance;
	}
	
	public List<BlogDTO> selectBoards(){
		List<BlogDTO> boards=mapper.selectBoards();
		
		for(BlogDTO board: boards) {
			if(board.getGrade()==0) {
				board.setGradeName("새싹");
			} else if (board.getGrade()==1) {
				board.setGradeName("뚱이");
			} else if(board.getGrade()==2) {
				board.setGradeName("스폰지밥");
			}
		}
		return boards;
	}
	
	BlogDTO selectBoard(int id) {
		return mapper.selectBoard(id);
	}
	
	int registerBoard(BlogDTO board) {
		int result=mapper.registerBoard(board);
		if(result>0) {
			String userId=board.getUserId();
			updateUserGrade(userId);
		}
		int boardId=board.getId(); //user가 가입할 당시 자동채번된 id
		List<FileDTO> fileList=board.getFileList();
		if(fileList!=null && !fileList.isEmpty()) {
			for(FileDTO file: fileList) {
				file.setBoardNo(boardId); //boardId가 BoardNo가 됨
			}
			return mapper.insertFile(fileList);	
		}
		return 1; //첨부파일이 없을경우 
	}
	
	int modifyBoard(BlogDTO board) {
		return mapper.modifyBoard(board);
	}
	
	int removeBoard(int id) {
		return mapper.removeBoard(id);
	}
	
	public void updateUserGrade(String userId) {
		int postCount=mapper.selectCommentCount(userId);
		int commentCount=mapper.selectPostCount(userId);
		
		int newGrade=0; //기본 등급
		if( postCount >=22 && commentCount >=5) {
			newGrade=2;
		} else if(postCount>=1&& commentCount>=2) {
			newGrade=1;
		}
		mapper.updateUserGrade(userId, newGrade);
	}
}

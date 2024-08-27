package comment;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

public class CommentService {
	private static CommentService instance=new CommentService();
	private static CommentMapper mapper;
	
	public CommentService() {
		
	}
	public static CommentService getInstance(SqlSession session) {
		mapper=session.getMapper(CommentMapper.class);
		return instance;
	}

	public List<CommentDTO> selectComments(int boardNo){
		return mapper.selectComments(boardNo);
	}
	
	public CommentDTO selectComment(int id) {
		return mapper.selectComment(id);
	}
	
	public CommentDTO registerComment(CommentDTO comment) {
		mapper.registerComment(comment);
		return mapper.selectComment(comment.getId());
	}
	
	public int modifyComment(CommentDTO comment) {
		return mapper.modifyComment(comment);
	}
	
	public int removeComment(int id) {
		return mapper.removeComment(id);
	}
}

package comment;

import java.time.LocalDateTime;

public class CommentDTO {
	private int id;
	private String content;
	private String writer;
	private LocalDateTime registerDate;
	private LocalDateTime modifiedDate;
	private int boardNo;
	
	public CommentDTO(){
		
	}

	public CommentDTO(String content, String writer) {
		super();
		this.content = content;
		this.writer = writer;
	}

	public CommentDTO(String content, String writer, int boardNo) {
		super();
		this.content = content;
		this.writer = writer;
		this.boardNo = boardNo;
	}

	public CommentDTO(int id, String content, String writer, LocalDateTime registerDate, LocalDateTime modifiedDate,
			int boardNo) {
		super();
		this.id = id;
		this.content = content;
		this.writer = writer;
		this.registerDate = registerDate;
		this.modifiedDate = modifiedDate;
		this.boardNo = boardNo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getWriter() {
		return writer;
	}

	public void setWriter(String writer) {
		this.writer = writer;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	public LocalDateTime getModifiedDate() {
		return modifiedDate;
	}

	public void setModifiedDate(LocalDateTime modifiedDate) {
		this.modifiedDate = modifiedDate;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	@Override
	public String toString() {
		return "CommentDTO [id=" + id + ", content=" + content + ", writer=" + writer + ", registerDate=" + registerDate
				+ ", modifiedDate=" + modifiedDate + ", boardNo=" + boardNo + "]";
	}
	
}

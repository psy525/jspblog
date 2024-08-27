package file;

import java.time.LocalDateTime;


public class FileDTO {
	private int id;
	private int boardNo;
	private String filePath;
	private String fileName;
	private String originalName;
	private long fileSize;
	private LocalDateTime registerDate;
	
	public FileDTO() {
	}

	public FileDTO(String filePath, String fileName, String originalName, long fileSize) {
		super();
		this.filePath = filePath;
		this.fileName = fileName;
		this.originalName = originalName;
		this.fileSize = fileSize;
	}

	public FileDTO(int id, int boardNo, String filePath, String fileName, String originalName, long fileSize,
			LocalDateTime registerDate) {
		super();
		this.id = id;
		this.boardNo = boardNo;
		this.filePath = filePath;
		this.fileName = fileName;
		this.originalName = originalName;
		this.fileSize = fileSize;
		this.registerDate = registerDate;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getOriginalName() {
		return originalName;
	}

	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	public long getFileSize() {
		return fileSize;
	}

	public void setFileSize(long fileSize) {
		this.fileSize = fileSize;
	}

	public LocalDateTime getRegisterDate() {
		return registerDate;
	}

	public void setRegisterDate(LocalDateTime registerDate) {
		this.registerDate = registerDate;
	}

	@Override
	public String toString() {
		return "FileDTO [id=" + id + ", boardNo=" + boardNo + ", filePath=" + filePath + ", fileName=" + fileName
				+ ", originalName=" + originalName + ", fileSize=" + fileSize + ", registerDate=" + registerDate + "]";
	}
	
}

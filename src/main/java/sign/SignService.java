package sign;

import org.apache.ibatis.session.SqlSession;

public class SignService {
	public static SignMapper mapper;
	private static SignService instance = new SignService();
	private SignService(){
	}

	public static SignService getInstance(SqlSession session) {
		mapper = session.getMapper(SignMapper.class);
		return instance;
	}
	
	SignDTO checkId(String userId) {
		return mapper.checkId(userId);
		}
	SignDTO checkEmail(String email) {
		return mapper.checkEmail(email);
	}
	
	 public SignDTO insertUser(SignDTO user) {
		 mapper.insertUser(user);  // 사용자를 DB에 추가
	       return user;
	    }
}

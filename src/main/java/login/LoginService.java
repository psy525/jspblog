package login;

import org.apache.ibatis.session.SqlSession;

import sign.SignDTO;

public class LoginService {
	private static LoginMapper mapper;
	private static LoginService instance=new LoginService();
	
	private LoginService() {
		
	}
	
	public static LoginService getInstance(SqlSession session) {
		mapper=session.getMapper(LoginMapper.class);
		return instance;
	}
	
	public SignDTO findUserById(String id, String password) {
		SignDTO user=mapper.findUserById(id);
		if(user.getPassword().equals(password)) {
			return user;
		}
		return null;
	}
}

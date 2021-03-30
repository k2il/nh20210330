package kikim.test01.user.service;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import kikim.test01.common.CommandMap;

public interface UserService {
	
	public List<Map<String,Object>> selectUserList(Map<String,Object> map) throws Exception;
	
	public int selectListTotCnt(Map<String,Object> map) throws Exception;
	
	void insertUser(Map<String, Object> map, HttpServletRequest request) throws Exception;
	
	Map<String, Object> selectUserDetail(Map<String, Object> map) throws Exception;
	
	void updateUser(Map<String, Object> map) throws Exception;
	
	void deleteUser(Map<String, Object> map) throws Exception;

	

}

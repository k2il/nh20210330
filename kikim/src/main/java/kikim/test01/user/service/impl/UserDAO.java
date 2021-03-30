package kikim.test01.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import kikim.test01.common.dao.AbstractDAO;

@Repository("userDAO")
public class UserDAO extends AbstractDAO {
	
	public List<Map<String, Object>> selectUserList(Map<String, Object> map) throws Exception {
		return (List<Map<String, Object>>) selectList("users.selectUserList", map);
	}
	
	public int selectListTotCnt(Map<String, Object> map) {
		// TODO Auto-generated method stub
		return (int) selectOne("users.selectListTotCnt", map);
	}
	
	public void insertUser(Map<String, Object> map) throws Exception {
		insert("users.insertUser", map);
	}

	
	public void updateHitCnt(Map<String, Object> map) throws Exception{
	    update("users.updateHitCnt", map);
	}
	
	public Map<String, Object> selectUserDetail(Map<String, Object> map) {
		return (Map<String, Object>) selectOne("users.selectUserDetail", map);
	}

	public void updateUser(Map<String, Object> map) {
		update("users.updateUser", map);
		
	}
	
	public void deleteUser(Map<String, Object> map) {
		update("users.deleteUser", map);
		
	}

	public void insertFile(Map<String, Object> map) {
		insert("users-file.insertFile", map);
		
	}


}

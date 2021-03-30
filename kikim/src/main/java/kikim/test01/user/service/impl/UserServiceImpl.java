package kikim.test01.user.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import kikim.test01.common.util.FileUtils;
import kikim.test01.user.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="fileUtils")
    private FileUtils fileUtils;
	
	@Resource(name="userDAO")
	private UserDAO userDAO;
	
	public List<Map<String, Object>> selectUserList(Map<String, Object> map) throws Exception {
		return userDAO.selectUserList(map);
	}
	
	public int selectListTotCnt(Map<String, Object> map) throws Exception {
		
		return userDAO.selectListTotCnt(map);
	}
	
	
	
	
	public void insertUser(Map<String, Object> map, HttpServletRequest request) throws Exception {
		userDAO.insertUser(map);
		
		List<Map<String,Object>> list = fileUtils.parseInsertFileInfo(map, request);
        for(int i=0, size=list.size(); i<size; i++){
        	userDAO.insertFile(list.get(i));
        }
		
		
	}
	
	
	public Map<String, Object> selectUserDetail(Map<String, Object> map) throws Exception {
		userDAO.updateHitCnt(map);
	    Map<String, Object> resultMap = userDAO.selectUserDetail(map);
	    return resultMap;
	}
	
	
	public void updateUser(Map<String, Object> map) throws Exception {
		userDAO.updateUser(map);
	}
	
	
	public void deleteUser(Map<String, Object> map) throws Exception {
		userDAO.deleteUser(map);
	}
	
	
	

}

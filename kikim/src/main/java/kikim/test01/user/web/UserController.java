package kikim.test01.user.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import kikim.test01.common.CommandMap;
import kikim.test01.common.util.PageUtil;
import kikim.test01.user.service.UserService;

@Controller
public class UserController {
	
	Logger log = Logger.getLogger(this.getClass());
	
	@Resource(name="userService")
	private UserService userService;
	
	@RequestMapping(value={"/user/userList.do" , "/user/openUserList.do"})
	public String userList(ModelMap model, CommandMap commandMap) throws Exception {
		
		//페이징 처리 시작
		int records = userService.selectListTotCnt(commandMap.getMap());
		PageUtil.getPage(records, commandMap.getMap(), model);
		
		List<Map<String,Object>> list = userService.selectUserList(commandMap.getMap());
		model.addAttribute("userList", list);
		model.addAttribute("param", commandMap.getMap());
    	
    	return "/user/userList";
		
	}
	
	
	@RequestMapping(value="/sample/testMapArgumentResolver.do")
	public ModelAndView testMapArgumentResolver(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("");
	     
	    if(commandMap.isEmpty() == false){
	        Iterator<Entry<String,Object>> iterator = commandMap.getMap().entrySet().iterator();
	        Entry<String,Object> entry = null;
	        while(iterator.hasNext()){
	            entry = iterator.next();
	            log.debug("key : "+entry.getKey()+", value : "+entry.getValue());
	        }
	    }
	    return mv;
	}
	
	
	@RequestMapping(value="/user/openUserWrite.do")
	public ModelAndView openUserWrite(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/user/userWrite");
	     
	    return mv;
	}
	
	
	@RequestMapping(value="/user/insertUser.do")
	public ModelAndView insertUser(CommandMap commandMap, HttpServletRequest request) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/user/userList.do");
	     
	    userService.insertUser(commandMap.getMap(), request);
	     
	    return mv;
	}
	
	
	@RequestMapping(value="/user/openUserDetail.do")
	public ModelAndView openUserDetail(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/user/userDetail");
	     
	    Map<String,Object> map = userService.selectUserDetail(commandMap.getMap());
	    
	    mv.addObject("map", map);
	    
	    return mv;
	}
	
	
	@RequestMapping(value="/user/openUserUpdate.do")
	public ModelAndView openUserUpdate(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("/user/userUpdate");
	     
	    Map<String,Object> map = userService.selectUserDetail(commandMap.getMap());
	    mv.addObject("map", map);
	     
	    return mv;
	}
	 
	@RequestMapping(value="/user/updateUser.do")
	public ModelAndView updateUser(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/user/openUserDetail.do");
	     
	    userService.updateUser(commandMap.getMap());
	     
	    mv.addObject("IDX", commandMap.get("IDX"));
	    return mv;
	}
	
	@RequestMapping(value="/user/deleteUser.do")
	public ModelAndView deleteUser(CommandMap commandMap) throws Exception{
	    ModelAndView mv = new ModelAndView("redirect:/user/userList.do");
	     
	    userService.deleteUser(commandMap.getMap());
	    return mv;
	}
	
	
	
	
	
	

}

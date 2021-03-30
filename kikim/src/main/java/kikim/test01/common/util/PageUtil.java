package kikim.test01.common.util;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;

import kikim.test01.common.pagenation.PaginationInfo;

public class PageUtil {
	
	@Autowired
	private int pageUnit = 10;
	private int pageSize = 10;
	
	public String setFirstPage(PaginationInfo page) throws Exception {
		String result = "";
		
		if ("0".equals(page.getFirstRecordIndex())){
			result = String.valueOf(page.getFirstRecordIndex());
		} else {
			result = String.valueOf(page.getFirstRecordIndex()+1);
		}
		
		return result;
	}
	
	@SuppressWarnings("unchecked")
	public Map setPageInfo(Map paramMap, PaginationInfo page) throws Exception {		
		if ((String)paramMap.get("pageIndex") == null || "".equals((String)paramMap.get("pageIndex"))){
			paramMap.put("pageIndex", "1");
		}
		
		page.setCurrentPageNo(Integer.parseInt((String)paramMap.get("pageIndex")));
		
		if (paramMap.get("pageUnit") != null){
			if (!"".equals((String)paramMap.get("pageUnit"))){
				pageUnit = Integer.valueOf((String)paramMap.get("pageUnit"));
			}
		}
		
		page.setRecordCountPerPage(pageUnit);
		page.setPageSize(pageSize);
		
		paramMap.put("firstIndex", setFirstPage(page));
		paramMap.put("lastIndex", String.valueOf(page.getLastRecordIndex()));
		paramMap.put("recordCountPerPage", String.valueOf(page.getRecordCountPerPage()));
		
		return paramMap;
	}
	
	public Map getPageInfo(Map paramMap, PaginationInfo page) throws Exception {		
		paramMap = setPageInfo(paramMap, page);
		
		return paramMap;
	}
	
	public void setTotalCount(Map paramMap, PaginationInfo page) throws Exception {
		page.setTotalRecordCount((Integer)paramMap.get("CNT"));
		paramMap.put("lastPage", String.valueOf(page.getTotalPageCount()));
	}
	
	public void setTotalCount(int cnt, PaginationInfo page) throws Exception {
		page.setTotalRecordCount(cnt);
//		paramMap.put("lastPage", String.valueOf(page.getTotalPageCount()));
	}
	
	public static void getPage(int totCnt, Map reqMap, ModelMap model) throws Exception {
		
		int index = 1;
		int listCnt = 10;
		int pageCnt = 10;
		
//		if ( reqMap.get("page_list_cnt") != null) {
//			listCnt = reqMap.get("page_list_cnt");
//		}
	    
	    if(reqMap.containsKey("pageIndex") && !"".equals((String)reqMap.get("pageIndex"))) 
			index = Integer.valueOf( (String)reqMap.get("pageIndex") );
	    if(reqMap.containsKey("pageCnt") && !"".equals((String)reqMap.get("pageCnt")))
	    	listCnt = Integer.valueOf( (String)reqMap.get("pageCnt") );
	    PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo( index );
		paginationInfo.setRecordCountPerPage(listCnt);
		paginationInfo.setPageSize(pageCnt);
		
		reqMap.put("firstIndex",         paginationInfo.getFirstRecordIndex()   );
		reqMap.put("lastIndex",          paginationInfo.getLastRecordIndex()    );
		reqMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage() );
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("paginationInfo", paginationInfo);
	}
	
	/**
	 * 모바일 전용 페이지유틸 적용
	 * @param totCnt
	 * @param reqMap
	 * @param model
	 * @param listCnt
	 * @param pageCnt
	 * @throws Exception
	 */
	public static void getPageMobile(int totCnt, Map reqMap, ModelMap model, int listCnt, int pageCnt ) throws Exception {
		
		int index = 1;
//		int listCnt = 5;
//		int pageCnt = 1;
		
	    if(reqMap.containsKey("pageIndex") && !"".equals((String)reqMap.get("pageIndex"))) 
			index = Integer.valueOf( (String)reqMap.get("pageIndex") );
	    
	    PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo( index );
		paginationInfo.setRecordCountPerPage(listCnt);
		paginationInfo.setPageSize(pageCnt);
		
		reqMap.put("firstIndex",         paginationInfo.getFirstRecordIndex()   );
		reqMap.put("lastIndex",          paginationInfo.getLastRecordIndex()    );
		reqMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage() );
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("paginationInfo", paginationInfo);
	}
	
	/**
	 * 페이지 적용
	 * @param totCnt
	 * @param reqMap
	 * @param model
	 * @param listCnt
	 * @param pageCnt
	 * @throws Exception
	 */
	public static void getPageBoard(int totCnt, Map reqMap, ModelMap model, int listCnt, int pageCnt ) throws Exception {
		
		int index = 1;
//		int listCnt = 5;
//		int pageCnt = 1;
		
	    if(reqMap.containsKey("pageIndex") && !"".equals((String)reqMap.get("pageIndex"))) 
			index = Integer.valueOf( (String)reqMap.get("pageIndex") );
	    
	    PaginationInfo paginationInfo = new PaginationInfo();
		paginationInfo.setCurrentPageNo( index );
		paginationInfo.setRecordCountPerPage(listCnt);
		paginationInfo.setPageSize(pageCnt);
		
		reqMap.put("firstIndex",         paginationInfo.getFirstRecordIndex()   );
		reqMap.put("lastIndex",          paginationInfo.getLastRecordIndex()    );
		reqMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage() );
		
		paginationInfo.setTotalRecordCount(totCnt);
		
		model.addAttribute("paginationInfo", paginationInfo);
	}

	public static void getJqGridJsonValPage(int records, Map paramMap, ModelMap model) throws Exception {
		
		PaginationInfo paginationInfo = new PaginationInfo();
		
		paginationInfo.setCurrentPageNo(Integer.parseInt((String)paramMap.get("page")));
		paginationInfo.setRecordCountPerPage(Integer.parseInt((String)paramMap.get("rows")));
		paginationInfo.setPageSize(Integer.parseInt((String)paramMap.get("rows")));
		
		paramMap.put("firstIndex", paginationInfo.getFirstRecordIndex());
		paramMap.put("lastIndex", paginationInfo.getLastRecordIndex());
		paramMap.put("recordCountPerPage", paginationInfo.getRecordCountPerPage());
		
		int rownum = (Integer.parseInt((String)paramMap.get("rows")));
    	
    	int total_add = 0;
    	if((records % rownum) > 0)
    		total_add = 1;
    	
    	int total = (records / rownum) + total_add;
    	
    	model.put("page", paramMap.get("page"));
    	model.put("total", total);
    	model.put("records", records);
	}
}


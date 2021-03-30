package kikim.test01.common.pagenation;

import javax.servlet.ServletContext;

import org.springframework.web.context.ServletContextAware;
/**
 * ImagePaginationRenderer.java 클래스
 * 
 * @author 서준식
 * @since 2011. 9. 16.
 * @version 1.0
 * @see
 *
 * <pre>
 * << 개정이력(Modification Information) >>
 *   
 *   수정일      수정자           수정내용
 *  -------    -------------    ----------------------
 *   2011. 9. 16.   서준식       이미지 경로에 ContextPath추가
 * </pre>
 */
public class ImagePaginationRenderer extends AbstractPaginationRenderer implements ServletContextAware{

	private ServletContext servletContext;
	
	public ImagePaginationRenderer() {
	
	}
	
	public void initVariables(){
		firstPageLabel    = " <a href=\"?pageIndex={1}\" class=\"dipolyion prevv\" onclick=\"{0}({1});return false; \">처음</a> ";
        previousPageLabel = " <a href=\"?pageIndex={1}\" class=\"dipolyion prev\"  onclick=\"{0}({1});return false; \">이전</a> ";
        currentPageLabel  = " <strong>{0}</strong> ";
        otherPageLabel    = " <a href=\"?pageIndex={1}\"  onclick=\"{0}({1});return false; \">{2}</a> ";
        nextPageLabel     = " <a href=\"?pageIndex={1}\" class=\"dipolyion next\"  onclick=\"{0}({1});return false; \">다음</a> ";
        lastPageLabel     = " <a href=\"?pageIndex={1}\" class=\"dipolyion nextt\" onclick=\"{0}({1});return false; \">끝</a> ";
		
        
		
		
		
//		  firstPageLabel    = "<li>&#160;</li><li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath() +  "/images/egovframework/com/cmm/mod/icon/icon_prevend.gif\" alt=\"처음\"   border=\"0\"/></a></li>";
//        previousPageLabel = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath() +  "/images/egovframework/com/cmm/mod/icon/icon_prev.gif\"    alt=\"이전\"   border=\"0\"/></a></li>";
//        currentPageLabel  = "<li><strong>{0}</strong></li>";
//        otherPageLabel    = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \">{2}</a></li>";
//        nextPageLabel     = "<li>&#160;<a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath() +  "/images/egovframework/com/cmm/mod/icon/icon_next.gif\"    alt=\"다음\"   border=\"0\"/></a></li>";
//        lastPageLabel     = "<li><a href=\"?pageIndex={1}\" onclick=\"{0}({1});return false; \"><img src=\"" + servletContext.getContextPath() +  "/images/egovframework/com/cmm/mod/icon/icon_nextend.gif\" alt=\"마지막\" border=\"0\"/></a></li>";
	}

	

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
		initVariables();
	}

}

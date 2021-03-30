<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"   %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<%@ include file="/WEB-INF/views/include/include-header.jsp" %>
</head>
<body>

<script type="text/javascript">
//pagiNation
function fnPage(val) {
	
	var myForm = document.listForm;
	myForm.pageIndex.value = val;
	myForm.action = "${ctx}/user/userList.do";
	myForm.submit();
}
</script>

<table class="board_view">
<tr>
	<th>No.</th>
	<th>id</th>
	<th>name</th>
	<th>hitCnt</th>
</tr>

<c:choose>
<c:when test="${fn:length(userList) > 0 }">
	<c:forEach items="${userList }" var="userList" varStatus="row">
	<tr>
		<td>${userList.IDX }</td>
		<td>
			<a href="#this" name="title"  >${userList.user_id }</a>
			<input type="hidden" id="IDX" value="${userList.IDX }" />
		</td>
		<td>${userList.user_name }</td>
		<td>${userList.hit_cnt }</td>
	</tr>
	</c:forEach>
</c:when>
<c:otherwise>
	<tr>
		<td colspan="3">데이터가 없습니다.</td>
	</tr>
</c:otherwise>
	
</c:choose>
</table>
<!--  페이지 네비게이션 -->
		<div class="paginate_box">
			<div class="paginate_complex">
		  	<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fnPage" />
			<input type="hidden" name="pageIndex" value="${param.pageIndex}"/>
			</div>
		</div>
<!--  //페이지 네비게이션 -->

<a href="#this" class="btn" id="write">등록하기</a>
<%@ include file="/WEB-INF/views/include/include-body.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#write").on("click", function(e){ //글쓰기 버튼
                e.preventDefault();
                fn_openUserWrite();
            }); 
             
            $("a[name='title']").on("click", function(e){ //제목 
                e.preventDefault();
                fn_openUserDetail($(this));
            });
        });
         
         
        function fn_openUserWrite(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("${ctx}/user/openUserWrite.do");
            comSubmit.submit();
        }
         
        function fn_openUserDetail(obj){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("${ctx}/user/openUserDetail.do");
            comSubmit.addParam("IDX", obj.parent().find("#IDX").val());
            comSubmit.submit();
        }
    </script>




</body>
</html>
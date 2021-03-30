<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/views/include/include-header.jsp" %>
</head>
<body>
    <table class="board_view">
        <colgroup>
            <col width="15%"/>
            <col width="35%"/>
            <col width="15%"/>
            <col width="35%"/>
        </colgroup>
        <caption>게시글 상세</caption>
        <tbody>
            <tr>
                <th scope="row">id</th>
                <td>${map.user_id }</td>
                <th scope="row">조회수</th>
                <td>${map.hit_cnt }</td>
            </tr>
            <tr>
                <th scope="row">name</th>
                <td colspan="3">${map.user_name }</td>
            </tr>
        </tbody>
    </table>
     
    <a href="#this" class="btn" id="list">목록으로</a>
    <a href="#this" class="btn" id="update">수정하기</a>
     
    <%@ include file="/WEB-INF/views/include/include-body.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#list").on("click", function(e){ //목록으로 버튼
                e.preventDefault();
                fn_openUserList();
            });
             
            $("#update").on("click", function(e){
                e.preventDefault();
                fn_openUserUpdate();
            });
        });
         
        function fn_openUserList(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("${ctx}/user/openUserList.do");
            comSubmit.submit();
        }
         
        function fn_openUserUpdate(){
            var idx = "${map.user_id}";
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("${ctx}/user/openUserUpdate.do");
            comSubmit.addParam("IDX", idx);
            comSubmit.submit();
        }
    </script>
</body>
</html>
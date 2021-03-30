
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/views/include/include-header.jsp" %>
</head>
<body>
    <form id="frm">
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
                    <th scope="row">ID</th>
                    <td>
                        ${map.IDX }
                        <input type="hidden" id="IDX" name="IDX" value="${map.IDX }">
                    </td>
                    <th scope="row">조회수</th>
                    <td>${map.hit_cnt }</td>
                </tr>
                <tr>
                    <th scope="row">id</th>
                    <td colspan="3"><input type="text" id="userId" name="userId" value="${map.user_id }"></td>
                </tr>
                <tr>
                    <th scope="row">name</th>
                    <td colspan="3"><input type="text" id="userName" name="userName" class="wdp_90" value="${map.user_name }"/></td>
                </tr>
            </tbody>
        </table>
    </form>
     
    <a href="#this" class="btn" id="list">목록으로</a>
    <a href="#this" class="btn" id="update">저장하기</a>
    <a href="#this" class="btn" id="delete">삭제하기</a>
     
    <%@ include file="/WEB-INF/views/include/include-body.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
            $("#list").on("click", function(e){ //목록으로 버튼
                e.preventDefault();
                fn_openUserList();
            });
             
            $("#update").on("click", function(e){ //저장하기 버튼
                e.preventDefault();
                fn_updateUser();
            });
             
            $("#delete").on("click", function(e){ //삭제하기 버튼
                e.preventDefault();
                fn_deleteUser();
            });
        });
         
        function fn_openUserList(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("${ctx}/user/openUserList.do");
            comSubmit.submit();
        }
         
        function fn_updateUser(){
            var comSubmit = new ComSubmit("frm");
            comSubmit.setUrl("${ctx}/user/updateUser.do");
            comSubmit.submit();
        }
         
        function fn_deleteUser(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("${ctx}/user/deleteUser.do");
            comSubmit.addParam("IDX", $("#IDX").val());
            comSubmit.submit();
             
        }
    </script>
</body>
</html>
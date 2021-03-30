<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
<%@ include file="/WEB-INF/views/include/include-header.jsp" %>
</head>
<body>
    <form id="frm" name="frm" enctype="multipart/form-data">
        <table class="board_view">
            <colgroup>
                <col width="10%">
                <col width="*"/>
            </colgroup>
            <caption>등록</caption>
            <tbody>
                <tr>
                    <th scope="row">id</th>
                    <td><input type="text" id="userId" name="userId" class="wdp_90"></input></td>
                </tr>
                <tr>
                    <td colspan="2" class="view_text">
                        <textarea rows="20" cols="100" title="userName" id="userName" name="userName"></textarea>
                    </td>
                </tr>
                <tr>
                    <th scope="row">password</th>
                    <td><input type="password" id="userPwd" name="userPwd" class="wdp_90"></input></td>
                </tr>
            </tbody>
        </table>
        
        <input type="file" name="file">
        <br/><br/>
         
        <a href="#this" class="btn" id="write" >등록하기</a>
        <a href="#this" class="btn" id="list" >목록으로</a>
    </form>
     
    <%@ include file="/WEB-INF/views/include/include-body.jsp" %>
    <script type="text/javascript">
        $(document).ready(function(){
        	$("#list").on("click", function(e){
                e.preventDefault();
                fn_openBoardList();
            });
        	
        	$("#write").on("click", function(e){ //작성하기 버튼
                e.preventDefault();
                fn_insertBoard();
            });
        });
        
        function fn_openBoardList(){
            var comSubmit = new ComSubmit();
            comSubmit.setUrl("${ctx }/user/openUserList.do");
            comSubmit.submit();
        }
        
        function fn_insertBoard(){
            var comSubmit = new ComSubmit("frm");
            comSubmit.setUrl("${ctx }/user/insertUser.do");
            comSubmit.submit();
        }
        
    </script>
</body>
</html>
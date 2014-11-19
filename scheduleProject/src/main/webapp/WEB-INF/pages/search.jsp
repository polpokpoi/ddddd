<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	String result = (String)request.getAttribute("searchResult");
	if (result == null) result ="";
%>
<!DOCTYPE html>
<html>
 <head>
  <title>Homework4</title>
  <link href='/schedule/fullcalendar-1.6.4/fullcalendar/fullcalendar.css' rel='stylesheet' />
	<link href='/schedule/fullcalendar-1.6.4/fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
	<script src='/schedule/fullcalendar-1.6.4/lib/jquery.min.js'></script>
	<script src='/schedule/fullcalendar-1.6.4/lib/jquery-ui.custom.min.js'></script>
	<script src='/schedule/fullcalendar-1.6.4/fullcalendar/fullcalendar.min.js'></script>

	<script>

	$(document).ready(function() {
	
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		var calendar = $('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			selectable: true,
			selectHelper: true,
			select: function(start, end, allDay) {
				var title = prompt('Event Title:');
				if (title) {
					calendar.fullCalendar('renderEvent',
						{
							title: title,
							start: start,
							end: end,
							allDay: allDay
						},
						true // make the event "stick"
					);
				}
				calendar.fullCalendar('unselect');
			},
			editable: true
	
		});
	});

</script>













  
 </head>
 
<style  type="text/css">


  body {
		width:1325px; height:690px; 

		text-align: center;
		font-size: 14px;
		font-family: "Lucida Grande",Helvetica,Arial,Verdana,sans-serif;
		  }

  #top { width:1305px; height:130px; margin-left:15px; margin-bottom:10px; background:#FDED5E; } 
  #outleft { display:inline; float:left; width:234px; height:660px; margin-left:18px;  }
  #calendar {float:left; width:817px; height:660px; margin-left:10px; }
  #outright { float:left; width:234px; height:660px; margin-left:10px; }
  #font{font-size: 30pt;}



  div #table1 {
	background-color: #eee;
	border-collapse: collapse;
}
	
  
div td{
	border-style: solid;
	border-width: 1px;
	border-color: white;
	height: 30px;	font-size: 10pt;
	padding: 2px;
}

  div #table1 td{
		border-width: 0px 0px 0px 0px;
		}

  div #table1 div {
	margin-left: 5px;
	float: left;
	}
  
.dark{
	color: #444;
	background-color: #e0e0e0;
}



*{margin: 0px; padding: 0px; color:#333;}
 div#login {line-height: 2em; width: 228px; margin: 0; padding: 0;}
 #login{border: 3px solid #ddd; background-color: #efefef;}
 #login #header {background-color: #333; font-weight: bold;}
 #login #header p {padding-left: 5px; color: #fff;}
 #login #input {width:228px; overflow: hidden; padding-left: 0px;}
 #login #id_line, #login #pwd_line {padding-top: 10px;}
 #login #footer {padding: 15px 0; font-size: 0.85em; text_align: center;}
 #login .in {border: 1px solid #ddd; width: 120px; height: 20px;}
 #login #footer a:link, #login #footer a:visited {text-decoration: none;}
 #login #footer a:hover{text-decoration: underline; color: #000;}
 #login label {display: none;}
 #login #a {padding-left:0.5px;}












 </style>
 
<body>
       <div id="top"><span id="font">top</span></div>
      
	  <div id="outleft">
	  <div id="login"><div id="header">
	  <p>Login</p>
	  </div>
	  <div id="input"><div id="id_line">
	  <label for="uid">ID</label>
	  <input type="text" id="uid" name="uid" class="in" maxlength="10" value="���̵�"/>&nbsp;	 
	  <input type="checkbox" name="id_save" id="id_save"/>ID����
	  <label for="id_save">ID����</label>
	  </div>

	  <div id="pwd_line">
	  <label for="upwd">PWD</label> 
	  <input type="password" id="upwd" name="upwd" class="in" maxlength="10" value="��й�ȣ"/>&nbsp;
	  <input type="submit" name="login" value="�α���"/>
	  </div>
	  </div>
	  <div id="footer">
	  <p> | <a href="register2.html">ȸ����</a> |
	  </p>
	  </div>
	  </div>
	  </div>


      <div id="calendar"></div>





      <div id="outright">
	 
					<table id="table1">
						<colgroup>
							<col width="190"/>
						</colgroup>
						<tbody>
							<tr><td class="dark" align="center"><h4>ģ�����</h4></td></tr>
							<tr><td class="dark" align="left"><input type="checkbox">����</td></tr>
							<tr><td class="dark" align="left"><input type="checkbox">��ö</td></tr>
							<tr><td class="dark" align="left"><input type="checkbox">�ڽ�</td></tr>
							<tr><td class="dark" align="left"><input type="checkbox">�Ѹ�</td></tr>
							<tr><td class="dark" align="left"><input type="checkbox">¯��</td></tr>
							<tr><td class="dark" align="left"><input type="checkbox">���Ϸ���</td></tr>
							<tr><td class="dark" align="left"><input type="checkbox">������</td></tr>
							<tr><td class="dark" align="left"><input type="checkbox">���丮</td></tr>
							<tr><td class="dark" align="left"><input type="checkbox">�ظ�����</td></tr>
							<tr><td class="dark" align="center"><input type="submit" value="���"></td></tr>
							

						</tbody>		
					</table>
				<a href="jh.html">����</a>

      </div>
      
    
 </body>
 
</html>
 

<!--
<!DOCTYPE html>
<html lang="ko">
<head>
	<meta charset="utf-8"/>
	<title>책 검색</title>
	<style>
		body { font-size: 12px; }
		.book-title { font-weight: bold; }
		table.t_ex2 { background:#E2F2D3; width:90%; margin:0; text-align:left }
		.t_ex2 td { border:1px solid #33904E; padding:10px }
	</style>
	<script language="JavaScript">
	function searchBook() {
		document.bookForm.submit();
	}
	</script>
	<script language="JavaScript" src="/books/js/lib/jquery-1.10.2.min.js"></script>
</head>
<body>
	<h1>책 검색</h1>
	<form name="bookForm" method="get" action="/books/search.mju">
	키워드 : <input type="text" name="keyword" value="${param.keyword}"/>
	<input type="button" value="검색" onClick="searchBook()"/>
	
	<c:if test="${resultBooks != null}">
	<br/>[검색결과]<br/>
	<table class="t_ex2">
	<c:forEach var="resultBook" items="${resultBooks.items}">
	<tr>
		<td rowspan="2">
		<img src="${resultBook.volumeInfo.smallImageLink}" width="100" border="0"/>
		</td>
		<td>
		<li class="book-title">${resultBook.volumeInfo.title}<br/>
		<li>${resultBook.volumeInfo.authors}<br/>
		</td>
	</tr>
	<tr>
		<td><div class="item">${resultBook.volumeInfo.description}</div></td>
	</tr>
	</c:forEach>
	</table>
	</c:if>
	
	
	<script>
		$(function(){ /* 아래 스크립트는 페이지 로딩 후 실행 */
			$('.item').each(function(event){ /* class 명이 item을 가지는 모든 div */
				var max_length = 100; /* Read More 링크가 추가되기 전에 최대 컨텐치 길이 */
				if($(this).html().length > max_length){ /* 해당 컨텐츠의 길이 체크(100 보다 큰 경우에만 실행) */
					var short_content 	= $(this).html().substr(0,max_length); /* 컨텐츠를 두개의 부분으로 분리 */
					var long_content	= $(this).html().substr(max_length);
					$(this).html(short_content+
						 '<a href="#" class="read_more"><br/>Read More</a>'+
						 '<span class="more_text" style="display:none;">'+long_content+
						 '<a href="#" class="shorten_less"><br/>Shorten</a></span>'); /* Read More 기능으로 더 읽을 HTML을 변경 */
					$(this).find('a.read_more').click(function(event){ /* 새로운 HTML내에서 a.read_more 요소를 찾고 다음 코드를 바인딩 */
						event.preventDefault(); /* a 태그에서 URL 변경을 막음 */
						$(this).hide(); /* Read More 버튼 숨기기 */
						$(this).parents('.item').find('.more_text').show(); /* .more_text span 보이기 */
					});
					
					$(this).find('a.shorten_less').click(function(event) {
						event.preventDefault(); /* a 태그에서 URL 변경을 막음 */
						$(this).parent('.more_text').hide();
						$(this).parents('.item').find('.read_more').show();
					});
				}
			});
		});
		</script>
	</form>
</body>
</html>

-->
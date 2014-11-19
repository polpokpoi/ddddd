<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
 <head>
  <title>Homework4</title>
  <link href='/schedule/fullcalendar-1.6.4/fullcalendar/fullcalendar.css' rel='stylesheet' />
	<link href='/schedule/fullcalendar-1.6.4/fullcalendar/fullcalendar.print.css' rel='stylesheet' media='print' />
	<script  type="text/javascript" src='/schedule/fullcalendar-1.6.4/lib/jquery.min.js'></script>
	<script  type="text/javascript" src='/schedule/fullcalendar-1.6.4/lib/jquery-ui.custom.min.js'></script>
	<script  type="text/javascript" src='/schedule/fullcalendar-1.6.4/fullcalendar/fullcalendar.min.js'></script>
    
    <script>
      
     
      function addEventsGet(){
       $.ajax({
     url: '${pageContext.request.contextPath}/addPlan/${user.id}.mju',
     type: "GET",
    
     error: function () {
       alert("error occured!!!");
     }
   
   });
      
      } 
     
       
     function addEvents(start,end,title){
		  
		  
		  	var id= ${user.id};
          var start = $.fullCalendar.formatDate(start, "yyyy-MM-dd");
          var end = $.fullCalendar.formatDate(end, "yyyy-MM-dd");
   
    url = '${pageContext.request.contextPath}/addPlan.mju';
       
            	
          
          
         
   // create JSON
   var dayPlan = {
    "title": title,
    "start": start,
    "end": end
     };

  var jdayPlan = JSON.stringify(dayPlan);
          
          
          
          
   $.ajax({
     url: url,
     type: "post",
     dataType: "json",
     contentType: "application/json",
     data: jdayPlan,
     error: function () {
       alert("error occured!!!");
     },
     success: function () {
       alert("saved!");
     }
   });
 
		 
    
		}
    
    
    
	$(document).ready(function() {
	
	    // document.getElementById("list").innerHTML= document.getElementById("list").innerHTML + "<p>"+name+"</p>" ;
	   $("button").click(function(){
    $(".listButton").remove();
      });
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		var calendar = $('#calendar').fullCalendar({
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month'
			},
			
			selectable: true,
			selectHelper: true,
			//이벤트 옴길때, 
			
			
			//선택했을 때 이벤트. 
			select: function(start, end, allDay) {
		 
			
				var title = prompt('Event Title:');
				if (title) {
					calendar.fullCalendar('renderEvent',
						{   id: 'id',
							title: title,
							start: start,
							end: end,
							allDay: allDay
						},
						true // make the event "stick"
					);
					
					addEventsGet();
					addEvents(start,end,title);
				}
				calendar.fullCalendar('unselect');
			},
			
			
			
			editable: false,
			
			

			
			
			
			 eventSources: [{
         // your event source
             url: '${pageContext.request.contextPath}/getPlan/${user.id}.mju', 
             type: 'GET',
             
             data: {
                 id: 'id',
                 title: 'title',
                 start: 'start',
                 end: 'end',
                 url: 'url',
                 color: 'color'
                
                   
             },
             error: function () {
                 alert('there was an error while fetching events!');
             },
             color: 'yellow',
             textColor: 'black',
             dataType: 'json'
         }],
         
         	eventClick: function(calEvent, jsEvent, view){
    
           if(confirm("Really delete event " + calEvent.title + " ?")){
        
          calendar.fullCalendar('removeEvents', calEvent.id);
                    var title = calEvent.title;
                    //var start = calEvent.start;
                    //var end = calEvent.end;
                    var start = $.fullCalendar.formatDate(calEvent.start, "yyyy-MM-dd");
                    var end = $.fullCalendar.formatDate(calEvent.end, "yyyy-MM-dd");
   
                    
                    
          $.ajax({
          type: "GET",
          url: '${pageContext.request.contextPath}/deletePlan.mju',
          data: "title="+ title +"&start="+ start +"&end="+ end,
          success: function(response){
          alert(response);
          },
          error: function(e){
            alert('Error:'+e);
          }
          
          }); 
      
         
      
        
           }                                                 }
         
         
         
			
		
		});
	});

	
  	 var users= new Array();
	  
	     
		
	function onList(name, id){
	 
	 
	 
	var user = new Array();
     
          for( var i = 0 ; i < users.length ; i++){
       if(users[i][0] == id){
          alert("already existed!");
          return;   
       }
     
     }  
     
        user[0] =  id;
	    user[1] = name;
		users.push(user);
	 
	    
	  //later escape name duplicate  
	  document.getElementById("list").innerHTML= document.getElementById("list").innerHTML + 
	  											"<p  id= "+ id +"  ondblclick='deleteName()' >"+name+
	  							"<input type='button' value='delete'  onclick='deleteName("+id+");' /> </p>" ;
	  
	
	}
	
function removeElement(id) {
   
   var elem = document.getElementById(id);
   
   elem.parentNode.removeChild(elem);
}
	
	
	function deleteName(id){
	    
	   
	     
	  for(var i = 0; i < users.length ; i++){
	  
		 if(users[i][0] == id){
	        
	      
	     users.splice(i,1);
	       removeElement(id);
	     
	     alert(id + '  deleted!');
	     
	     }
	  } 
	  
	 } 
	

	
	
	
	
	function insertEvents(){
	 

       var JsonArray = new Array();
	   
	   for (var i = 0 ; i < users.length ; i++){
	       JsonArray[i] = {
		       id : users[i][0],
			   name : users[i][1]
		   
		   }
		   
		}	   
		   
		
		
		  var json = JSON.stringify(JsonArray);
		  
	   $.ajax({
     url: '${pageContext.request.contextPath}/insertUsersEvents.mju',
     type: "post",
     dataType: "json",
     contentType: "application/json",
     data: json,
     error: function () {
       alert("error occured!!!");
     },
     success: function (json) {
	     alert("fetching"+json);
	         $('#calendar').fullCalendar('removeEvents');
            $('#calendar').fullCalendar('addEventSource', json );
            // $('#calendar').fullCalendar('rerenderEvents', json);
          //  $('#calendar').fullCalendar('removeEventSource', json );
        //    $('#calendar').fullCalendar('removeEvents');
	  // $('#calendar').fullCalendar('refetchEvents');
	  
     }
      });
	
	  
	}

	
	
	
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
 div#list {line-height: 2em; width: 228px; margin: 0; padding: 0;}
 #list{border: 3px solid #ddd; background-color: #efefef;}
 #list #header {background-color: #333; font-weight: bold;}
 #list #header p {padding-left: 5px; color: #fff;}
 #list #input {width:228px; overflow: hidden; padding-left: 0px;}
 #list #id_line, #list #pwd_line {padding-top: 10px;}
 #list #footer {padding: 15px 0; font-size: 0.85em; text_align: center;}
 #list .in {border: 1px solid #ddd; width: 120px; height: 20px;}
 #list #footer a:link, #list #footer a:visited {text-decoration: none;}
 #list #footer a:hover{text-decoration: underline; color: #000;}
 #list label {display: none;}
 #list #a {padding-left:0.5px;}












 </style>
 
<body>
       <body>
       <div id="top"><span id="font">ScheduleSharing</span></div>
      
	  <div id="outleft">
	  <div id="list">
	    <div>  <input type="button" value='insertEvents' onclick="insertEvents();" /> </div>
 	  </div>                                                   
	  </div>


      <div id="calendar"></div>





      <div id="outright">
	               
	               <h1> ${user.name} </h1>
	               
					<table id="table1">
					
					<!--<button onclick="copyText()">Copy Text</button> onclick="openLog('${log.name}');" -->
						<colgroup>
							<col width="190"/>
						</colgroup>
						
						         <tr>
								
							        <c:if test="${user.type == false}">
								 
							           <td> <c:out value="${user.name}" /></td>
								  
								    </c:if>
								
							       <c:if test="${user.type == true}">
								   
							          <td onclick="onList('${user.name}',${user.id} );"><b><c:out value="${user.name}" /></b></td>
								    
								    </c:if>
								
								<td><img src='https://graph.facebook.com/<c:out value="${user.id}"/>/picture' />
								
								</td>
								</tr>
						
						
						
								<c:forEach  items="${friendsList}" var="user">
								
						          <tr>
								
							        <c:if test="${user.type == false}">
								 
							           <td> <c:out value="${user.name}" /></td>
								  
								    </c:if>
								
							       <c:if test="${user.type == true}">
								   
							          <td onclick="onList('${user.name}',${user.id} );"><b><c:out value="${user.name}" /></b></td>
								    
								    </c:if>
								
								<td><img src='https://graph.facebook.com/<c:out value="${user.id}"/>/picture' />
								
								</td>
								</tr>
								
								</c:forEach>
								
								<td><input type="submit" value="Add" /></td>
					</table>

      </div>
      
    
 </body>
      
    
 </body>
 
</html>
 

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
	$(document).ready(function() {
	
		var date = new Date();
		var d = date.getDate();
		var m = date.getMonth();
		var y = date.getFullYear();
		
		
		
		    
		
		
		
		
		
		function addEvents(start,end,title){
		
		//  var id = event.id.toString();
    var start = $.fullCalendar.formatDate(start, "yyyy-MM-dd");
    url = 'updateevent.php?id='+'&startDate='+start+'';
    alert (url);
    

    
    
    /*
    $.ajax({
          type: "POST",
          url: url,
          success: function(){
        $('#calendar').fullCalendar( 'refetchEvents' );
        alert( "Success!" );
            },
          error: function(){
        $('#calendar').fullCalendar( 'refetchEvents' );
        alert( "Failed!" );
            }

          }); 
		*/ 
		 
		}
		
		
		var calendar = $('#calendar').fullCalendar({
		   
		    
		
		
			header: {
				left: 'prev,next today',
				center: 'title',
				right: 'month,agendaWeek,agendaDay'
			},
			
			selectable: true,
			selectHelper: true,
			
			
			
			
	
        
        
        
        
        
        
         

			
			
			
			//선택했을 때 이벤트. 
			select: function(start, end, allDay) {
				var title = prompt('Event Title:');
				if (title) {
				    
	             var startd = $.fullCalendar.formatDate(event.start, "yyyy-MM-dd");
	          
		                alert(startd);
					calendar.fullCalendar('renderEvent',
						{
							title: title,
							start: start,
							end: end,
							allDay: allDay
						},
						true// make the event "stick",
						
						
						
					);
					
					addEvents(start,end,title);
		        
				}
				calendar.fullCalendar('unselect');
			},
			
			
			
			editable: true,


			
			 eventSources: [{
         // your event source
             url: '${pageContext.request.contextPath}/getPlan.mju', 
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
    
           if(confirm("Really delete event " + calEvent.id + " ?")){
        calendar.fullCalendar('removeEvents', calEvent.id);

}}
         
         
         
         
         
         
			
			
		
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
       <div id="top"><span id="font">top</span>
          
         
       </div>
      
	
         

      
      <div id="calendar"  >
        <div class="fc-content"> </div>
      </div>


  


      
    
 </body>
 
</html>
 

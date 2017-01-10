<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<script>
	$.jgrid.defaults.width = 780;
</script>
<script type="text/javascript">
var jqgridTable = 
{
	init : function() {
		
       	jQuery("#gridList").jqGrid({        
       	   	url:'jqgridTable2.do',
       		datatype: "local",
       		styleUI : 'Bootstrap',
       		//postData 	: {"param" : JSON.stringify(jsonObj)},
       	   	colNames:['아이디','이름','전화번호','주소','기타'],
       	   	colModel:[
       	   		{name:'id',index:'id', width:55, key:true},
       	   		{name:'name',index:'name', width:100, editable:true},
       	   		{name:'phone',index:'phone', width:100},
       	   		{name:'address',index:'address', width:100},
       	   		{name:'etcc',index:'etcc', width:100}
       	   	],
       	   	height: 280,
       	   	rowNum:10,
       	   	rowList:[10,20,30],
       	   	regional : 'kr',
       	   	pager: '#pager',
       	   	cellEdit : true,
       	   	cellurl : 'jqgridEdit.do',
       	   	beforeSubmitCell:function(rowid, cellName, value) {
       	   		
       	   		return{"id":rowid, "cellName":cellName, "cellValue":value}
       	   	},
       	    viewrecords: true,
       	    sortorder: "desc",
       	    caption:"Simple data manipulation"
       	});
	},
	
	goFn : function() {
		
		var jsonObj = {};

		if($("#selectId").val() != "C") {
			
			jsonObj.serviceImplYn = $("#selectId").val();
		}
		
		$("#gridList").setGridParam({
	        datatype : "json",
	        postData : {"param" : JSON.stringify(jsonObj)},
	        loadComplete: function(data){
	        	$.each(data, function (i, item) { 

					if(i == "rows") {
						
						if(item < 1) {
							
							alert("데이터가 없습니다.");
						}
					}
	        	});
            }
	    }).trigger("reloadGrid");  
	}
}

$(document).ready(function(){	

	var param1 = '${param.param1}';
	
	//alert(param1);
	//alert($("#param2").val());
	
	jqgridTable.init()
});
</script>
<div class="row">
	<input type="hidden" id="param2" name="param2" value="${param.param2}"/>
	
	<ul>
		<c:forEach items="${jstlList}" var="resultList" varStatus="status" >
			<c:choose>
				<c:when test="${param.param3 eq 'A'}">
					<li>${resultList.name}</li>
				</c:when>
				<c:when test="${param.param3 eq 'B'}">
					<li>${resultList.address}</li>
				</c:when>
				<c:otherwise>
					<li>${resultList.etcc}</li>
				</c:otherwise>
			</c:choose>
		</c:forEach>
	</ul>
	<div>
		<select id="selectId">
			<option value="A">임플A</option>
			<option value="B">임플B</option>
			<option value="C">임플C</option>
			<option value="D">임플D</option>
		</select>
	</div>
	<div>
		<span><a href="#" onclick="javascript:jqgridTable.goFn()">조회</a></span>
	</div>			
	<div>
		<table id="gridList" ></table>
		<div id="pager"></div>
	</div>	
</div>
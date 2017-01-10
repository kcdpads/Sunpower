<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="ui" uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="css/jqgrid/ui.jqgrid.css" />
<link rel="stylesheet" type="text/css" href="css/jqgrid/ui.jqgrid-bootstrap-ui.css" />

<script type="text/javascript" src="js/jqgrid/jquery-1.11.0.min.js"></script>  
<script type="text/javascript" src="js/json2.js"></script>
<script type="text/javascript" src="js/jqgrid/i18n/grid.locale-kr.js"></script>
<script type="text/javascript" src="js/jqgrid/jquery.jqGrid.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>

<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/css/bootstrap.min.css"> 
<link rel="stylesheet" type="text/css" href="css/jqgrid/ui.jqgrid-bootstrap.css" />

<script>
	$.jgrid.defaults.width = 780;
</script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<style type="text/css">
	.gridLine {
	
		text-decoration:underline;
		cursor:pointer;
	}
</style>
<script type="text/javascript">

var jqgridTable = 
{
	goFn : function() {
				
       	jQuery("#gridList").jqGrid({ 
       		
       	   	url:'jqgridTable.do',
       		datatype: "json",
       		styleUI : 'Bootstrap',
       	   	colNames:['아이디','이름','전화번호','주소','기타'],
       	   	colModel:[
       	   		{name:'id',		index:'id', 		width:55},
       	   		{name:'name',	index:'name', 		width:100, formatter:jqgridTable.fnLinkedLine},
       	   		{name:'phone',	index:'phone', 		width:100, align:"center"},
       	   		{name:'address',index:'address', 	width:100},
       	   		{name:'etcc',	index:'etcc', 		width:100}
       	   	],
       	   	height: 280,
       	   	rowNum:10,
       	   	rowList:[10,20,30],
       	   	regional : 'kr',
       	   	pager: '#pager',
       	    viewrecords: true,
       	    sortorder: "desc",
       	    caption:"jqgrid 2bu"
       	});
	},
	
	fnLinkedLine : function(cellValue, options, rowObject) {
		
		cellValue = "<span class='gridLine'>"+cellValue+"</span>";
		
		return cellValue;
	}
}

$(document).ready(function(){	

	var param1 = "${param.param1}";
	var cParam1 = "<c:out value="${param.param1}"/>";
	
	//alert(param1);
	//alert(cParam1);
	//alert($("#param2").val());
	
	
});
</script>
<title>2부 세미나</title>
</head>
<body>
<div>
여기는 탑
</div>

<input type="hidden" id="param2" name="param2" value="<c:out value="${param.param2}"/>"/>

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
	<span><a href="#" onclick="javascript:jqgridTable.goFn()">조회</a></span>
</div>			
<div>
	<table id="gridList" ></table>
	<div id="pager"></div>
</div>	
</body>
<div>
	여기는 바텀
</div>	
</html>
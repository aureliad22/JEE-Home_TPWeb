<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="./header.jspf"%>

<jsp:include page="${requestScope.titre}.jsp"></jsp:include>

<jsp:include page="${requestScope.navigation}.jsp"></jsp:include>

<jsp:include page="${requestScope.content}.jsp"></jsp:include>

<%@include file="./footer.jspf"%>
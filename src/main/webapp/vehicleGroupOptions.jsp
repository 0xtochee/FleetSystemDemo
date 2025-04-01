<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>vehicleGroupOptions</title>
</head>
<body>

	<s:select name="vehicleGroup" id="vehicleGroup"
    list="filteredVehicleGroups" listKey="id" listValue="model"
    headerKey="" headerValue="--Select--"
    style="min-width: 70px; max-width: 140px;" />
</body>
</html>
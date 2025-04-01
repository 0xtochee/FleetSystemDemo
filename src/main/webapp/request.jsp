<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>New Maintenance Request</title>
    <s:head />
</head>
<body>
    <h1>New Maintenance Request</h1>
    
    <s:form action="submitRequest" method="post">
    <s:actionerror />
        <s:select name="requestForm.officeId" list="officeList" listKey="id" listValue="name" label="Office" />
        <s:select name="requestForm.clientId" list="clientList" listKey="id" listValue="name" label="Client" />
        <s:select name="requestForm.vehicleCategory" list="vehicleCategoryList" listKey="id" listValue="name" label="Vehicle Category" />
	   	<s:select name="requestForm.vehicleGroup" list="vehicleGroupList" listKey="id" listValue="name" label="Vehicle Group" />
	   	<s:textfield name="requestForm.mileage" label="mileage" rows="4" cols="50"/>
	   	<s:select name="requestForm.personnelId" list="personnelList" listKey="id" listValue="name" label="Driver" />
        <s:textarea name="requestForm.faultType" label="Fault Description" rows="4" cols="50" />
        <s:textfield name="requestForm.workshop" label="Workshop" rows="4" cols="50" />
	   	<s:textarea name="requestForm.complaints" label="Complaints" rows="4" cols="50" />
	   	<s:select name="requestForm.status" list="statusList" listKey="id" listValue="name" label="Status" />
        <s:submit value="Submit Request" />
    </s:form>
</body>
</html>
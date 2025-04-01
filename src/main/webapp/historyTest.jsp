<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Maintenance Request History</title>
    <link rel="stylesheet" type="text/css" href="<s:url value='/css/style.css'/>">
    <style>
        table {
            width: 100%;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f2f2f2;
        }
        tr:nth-child(even) {
            background-color: #f9f9f9;
        }
    </style>
</head>
<body>
<div class="search-container">
	<div style="color: black; position: relative;" label="DETAILS SEARCH" showerror="true" parsecontent="true" class="search-container">
	<br>
	
	<fieldset>
		<s:form action="searchRequests" method="post">
		<table width="100%">
			<tbody>
				<tr>
					<td width="40%" nowrap class="texttitle" style="font-weight: bold">
						<s:textfield name="requestNo" label="Request No."/>
					</td>
					<td width="80%" nowrap class="TEXTETITLE" style="font-weight: bold">
						<s:select name="requestForm.office" list="officeList" headerKey="" headerValue="--Select Office--" label="Office" style="min-width: 250px"/>
					</td>
				</tr>
				<tr>
					<td width="40%" class="TEXTETITLE" style="font-weight: bold">
						<s:select name="requestForm.client" list="clientList" headerKey="" headerValue="--Select Client--" label="Client" style="min-width: 250px"/>
					</td>
					<td width="80%" class="TEXTETITLE" style="font-weight: bold">
						<s:select name="requestForm.vehicle" list="vehicleList" headerKey="" headerValue="--Select Vehicle--" label="Vehicle" style="min-width: 200px; max-width:300px"/>
					</td>
				</tr>
				<tr>
					<td width="40%" class="TEXTETITLE" style="font-weight: bold">
						<s:textfield type="date" label="Submitted Date" size="20" style="width: 9em; vertical-align: middle;" />
					</td>
					<td width="80%" class="TEXTETITLE" style="font-weight: bold">
						<s:select name="requestForm.workshop" list="workshopList" headerKey="" headerValue="--Select Workshop--" label="Workshop *" style="min-width: 150px"/>
					</td>
				</tr>
				<tr>
					<td>
						<s:checkboxlist name="status" list="statusList" label="Status"/>
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<s:submit value="Search"/>
						<s:submit value="Clear" action="viewHistory"/>
					</td>
				</tr>
			</tbody>
		</table>
		</s:form>
	</fieldset>
    </div>
</div>
	
	
	<div class="search-container" >
		<div style="color: black; position: relative;" label="DETAILS SEARCH" showerror="true" parsecontent="true" class="search-container">
			<br>
			
			<fieldset>
				<table width="100%">
					<tbody>
						<tr>
							<td width="10%" class="TEXTETITLE" style="font-weight: bold">Request No.</td>
							<td width="30%" nowrap>
								<s:textfield name="requestNo" label="Request No."/>
							</td>
							
							<td width="79" class="TEXTETITLE" style="font-weight: bold">Office</td>
							<td width="53%">
								<s:select name="requestForm.office" list="officeList" headerKey="" headerValue="--Select Office--" label="Office" style="min-width: 250px"/>
							</td>
						</tr>
							
						<tr>
							<td class="TEXTETITLE" style="font-weight: bold">Client</td>
							<td>
								<s:select name="requestForm.client" list="clientList" headerKey="" headerValue="--Select Client--" label="Client" style="min-width: 250px"/>
							</td>
							<td class="TEXTETITLE" style="font-weight: bold">Vehicle</td>
							<td>
								<div>
									<s:select name="requestForm.vehicle" list="vehicleList" headerKey="" headerValue="--Select Vehicle--" label="Vehicle" style="min-width: 200px; max-width:300px"/>
								</div>
							</td>
						</tr>
						<tr>
							<td class="TEXTETITLE" style="font-weight: bold">Submitted Date</td>
								<td>
									<s:textfield type="date" size="20" style="width: 9em; vertical-align: middle;" />
								</td>
							<td class="TEXTETITLE" style="font-weight: bold"> 
								Workshop
								<span class="textered">*</span>	
							</td>
							<td>
								<s:select name="requestForm.workshop" list="workshopList" headerKey="" headerValue="--Select Workshop--" label="Workshop *" style="min-width: 150px"/>
							</td>
						</tr>
						<tr>
							<td>
								<s:checkboxlist name="status" list="statusList" label="Status"/>
							</td>
						</tr>
						<tr>
							<td colspan="2">
								<s:submit value="Search"/>
								<s:submit value="Clear" action="viewHistory"/>
							</td>
						</tr>
					</tbody>
				</table>
			</fieldset>
		</div>
	</div>
</body>
</html>
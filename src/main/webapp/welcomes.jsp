<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSP Processing Check: <%= new java.util.Date() %> -->
<%@ taglib prefix="s" uri="/struts-tags" %> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome</title>
<link rel="stylesheet" href="styled.css">
<s:head/>
</head>
<body>
	<div class="tableContainer">
		<table>
			<tr>
				<td>
					<div style="text-align:left; margin-left: 25px; margin-top: 20px; margin-bottom: 20px">
                    	<a href="<s:url action='viewHistory'/>">LIST OF VEHICLE MAINTENANCE REQUEST</a>
                    </div>
                    
                    <s:form theme="simple" action="submitRequest" method="post">
                    	<div class="formContainer">
							<div class="tabContainer">
								<a class="tab active">DETAILS</a>
  								<a class="tab">FILES</a>
  								<a class="tab">PAST MAINTENANCE(S)</a>
 								<a class="tab" href="<s:url action='viewHistory'/>">HISTORY</a>
							</div>
							
							<div class="tabPaneWrapper">
								<div class="tabPane">
									<br/>
									<fieldset>
										<table style="width: 100%">
											<tbody>
												<tr>
													<td style="width: 7%; font-weight: bold" class="texttitle">
														Office 
														<span class="textered">*</span>
													</td>
													<td style="width: 30%">
													    <s:select name="requestForm.office" 
													              list="officeList" 
													              listKey="id" 
													              listValue="name" 
													              headerKey="" 
													              headerValue="--Select--"
													              style="min-width: 200px; max-width: 300px;" />
													</td>													
													<td style="width: 10%; font-weight: bold" class="texttitle">
														Client
													</td>
													<td style="width: 53%">
													    <select name="requestForm.client" style="min-width: 200px; max-width: 300px;">
													        <option value="">--Select--</option>
													        <s:iterator value="clientList" status="status">
													            <option value="<s:property value="id"/>"><s:property value="name"/></option>
													        </s:iterator>
													    </select>
													</td>
												</tr>
												
												<tr>
													<td style="font-weight: bold" class="texttitle">
														Vehicle 
														<span class="textered">*</span>
													</td>
													<td>
														<s:select name="requestForm.vehicleCategory" id="vehicleCategory"
														    list="vehicleCategoryList" listKey="name" listValue="name"
														    headerKey="" headerValue="--Select--"
														    onchange="updateVehicleGroups(this.value)"
														    style="min-width: 60px; max-width: 80px;" />
													     <s:select name="requestForm.vehicleGroup" id="vehicleGroup"
													            list="vehicleGroupList" listKey="id" listValue="model"
													            headerKey="" headerValue="--Select--"
													            style="min-width: 70px; max-width: 140px;" />
													</td>
													<td style="font-weight: bold" class="texttitle">
														Mileage/Date
													</td>
													<td>
														<div class="mileage-info">
															<s:textfield name="requestForm.mileage" type="text" style="min-width: 50px; max-width: 200px;" size="7"/> 
															<s:textfield type="date" size="20" style="width: 9em; vertical-align: middle;" /> 
															<s:textfield type="time" size="20" style="width: 9em; vertical-align: middle;" />
														</div>
													</td>
												</tr>
												
												<tr>
													<td class="texttitle" style="font-weight: bold">
														Driver
													</td>
													<td>
														<select name="requestForm.personnel" style="min-width: 180px; max-width: 400px;">
														    <option value="">--Select--</option>
														    <s:iterator value="personnelList" status="status">
														        <option value="<s:property value="id"/>"><s:property value="name"/></option>
														    </s:iterator>
														</select>
													</td>
													
													<td class="texttitle" style="font-weight: bold">
														Location
													</td>
													<td>
														<!-- style="width: 8em; vertical-align: middle;" -->
														<s:textfield name="requestForm.location" type="text" size="45" />
													</td>
												</tr>
												
												<tr>
													<!--  Try using style="width for the fault type"-->
													<td style="width: 8%; font-weight: bold" class="texttitle">
														Fault Type
														<span class="textered">*</span>
													</td>
													<td class="texte">
														<select name="requestForm.faultType" id="faultType" style="min-width: 160px; max-width: 200px;">
														    <option value="">--Select--</option>
														    <option value="accident">Accident</option>
														    <option value="breakdown">Breakdown</option>
														    <option value="corrective">Corrective</option>
														    <option value="routine service">Routine Service</option>
														    <option value="inspection">Inspection</option>
														    <option value="n/a">N/A</option>
														</select>												        
													</td>
													
													<td class="texttitle" style="font-weight: bold">
														Workshop
													</td>
													<td>
														<!-- style="width: 8em; vertical-align: middle;" -->
														<s:textfield name="requestForm.workshop" type="text" size="45" />
													</td>
												</tr>
												
												<tr>
													<td style="font-weight: bold" class="texttitle">
														Complaint
														<span class="textered">*</span>
													</td>
													<td colspan="3">
														<s:textarea name="requestForm.complaints" cols="60" rows="3" style="resize: none" />
													</td>
												</tr>
												
												<tr>
													<td style="font-weight: bold" class="texttitle">
														Status
														<span class="textered">*</span>
													</td>
													<td class="texte">
														<!-- name="Status" list="statusList" listKey="id" -->
														<select name="requestForm..status" id="status">
												            <option value="submitted">Submitted</option>
												        </select>
													</td>
												</tr>
											</tbody>
										</table>
									</fieldset>
									<br/>
								</div>
							</div>	
						</div>
                    	
                    	<table class="form-footer" style="width: 100%">
                    		<tbody>
                    			<tr>
                    				<td>
                    					<!-- <button type="button" onclick="updateVehicleGroups('TestCategory')">Test Update</button> -->
                    					<s:submit value="Submit" id="submit-btn" cssClass="button" /> 
										<input type="button" value="Create Maintenance" id="c-maintain" class="button" style="color: green; font-weight: bold; text-align: center;" />
										<span class="textered">*&nbsp;Compulsory fields</span>
									</td>
                    			</tr>
                    		</tbody>
                    	</table>	
                    </s:form>
				</td>
			</tr>
		</table>
	</div>

</body>
</html>
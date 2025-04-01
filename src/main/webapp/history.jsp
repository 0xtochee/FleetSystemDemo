<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html>
<html>
<head>
    <title>Maintenance Request History</title>
    <link rel="stylesheet" href="historystyle.css">
<s:head/>
</head>
<body>
    
    <!-- Search Form -->
    <div class="tableContainer">
    	<table>
    		<tr>
    			<td>
	    			<div style="text-align:left; margin-left: 25px; margin-top: 20px; margin-bottom: 20px">
	                 	<h3>LIST OF VEHICLE MAINTENANCE REQUESTS</h3><p>Click <a href="<s:url action='generateReport'/>">here</a> to generate a PDF report.</p> 	
	                </div>
    				
				    <s:form theme="simple" action="searchRequests" method="post">
						<div  class="tabPaneWrapper">
							<div  class="tabPane" style="color: black; position: relative;">
								<br/>
								<fieldset>
									<legend class="textetable">
							    		<table>
							    			<tbody>
							    				<tr>
							    					<td>Details Search</td>
							    				</tr>
							    			</tbody>
							    		</table>
							    	</legend>
									<table style="width: 100%; margin-bottom: 2px">
										<tbody>
											<tr>
												<td class="texttitle" style="width: 10%; font-weight: bold">Request No.</td>
												<td>	
													<s:textfield name="requestNo" style="width: 30%; font-weight: bold"/>
												</td>
												<td class="texttitle" style="width: 9%; padding-left: 6px; font-weight: bold">Office</td>
												<td style="width: 53%">
													<s:select name="requestForm.office" list="officeList" headerKey="" headerValue="--Select Office--" label="Office" style="min-width: 250px"/>
												</td>
											</tr>
											<tr>
												<td class="texttitle" style="font-weight: bold">Client</td>
												<td>
													<s:select name="requestForm.client" list="clientList" headerKey="" headerValue="--Select Client--" label="Client" style="min-width: 250px"/>
												</td>
												<td class="texttitle" style="font-weight: bold; padding-left: 6px">Vehicle</td>
												<td>
													<s:select name="requestForm.vehicle" list="vehicleList" headerKey="" headerValue="--Select Vehicle--" label="Vehicle" style="min-width: 200px; max-width:300px"/>
												</td>
											</tr>
											<tr>
												<td class="texttitle" style="font-weight: bold">Submitted Date</td>
												<td>
													<s:textfield type="date" label="Submitted Date" size="20" style="width: 9em; vertical-align: middle;" />
												</td>
												<td class="texttitle" style="width: 10%; font-weight: bold ; padding-left: 6px">
													Workshop
													<span class="textered">*</span></td>
												<td>
													<s:select name="requestForm.workshop" list="workshopList" headerKey="" headerValue="--Select Workshop--" label="Workshop *" style="min-width: 150px"/>
												</td>
											</tr>
											<tr>
												<td style="font-weight: bold" class="texttitle">Status</td>
												<td>
													<div style="width: 250%">
														<s:checkboxlist name="status" list="statusList" label="Status"/>
													</div>
												</td>
											</tr>
											<tr>
												<td>
													<div style="width: 250%; padding-top:10px">
														<s:submit value="Search"/>
														<s:submit value="Clear" action="viewHistory"/>
													</div>
												</td>
											</tr>
										</tbody>
									</table>
								</fieldset>
								<br/>
							</div>
						    
						    <br>
						    <fieldset>
						    	<legend class="textetable">
						    		<table>
						    			<tbody>
						    				<tr>
						    					<td>List</td>
						    				</tr>
						    			</tbody>
						    		</table>
						    	</legend>
						    	<div   class="tabPane" style="color: black; position: relative;">
						    		<br>
								    <!--  Results Table -->
								    <table id="search_form" style="width:100%">
								        <tbody>
								        	<tr>
										      <th>#</th>
										      <th>Date</th>
										      <th>Vehicle/Mileage</th>
										      <th>Workshop</th>
										      <th>Office/Client</th>
										      <th>Complaint</th>
										      <th>Status</th>
										    </tr>
										    <s:if test="requests != null && !requests.isEmpty()">
										       <s:iterator value="requests">
										           <tr>
										               <td><s:property value="id"/></td>
										               <td><s:date name="requestDate" format="dd/MM/yyyy HH:mm a"/></td>
										               <td><s:property value="vehicleName"/>/<s:property value="vehicleMileage"/></td>
										               <td><s:property value="workshop"/></td>
										               <td><s:property value="officeName"/>/<s:property value="clientName"/></td>
										               <td><s:property value="complaints"/></td>
										               <td><s:property value="status"/></td>
										           </tr>
										       </s:iterator>
										   </s:if>
									        <s:if test="searchResults != null && !searchResults.isEmpty()">
									            <s:iterator value="searchResults">
									                <tr>
									                    <td><s:property value="id"/></td>
									                    <td><s:date name="requestDate" format="dd/MM/yyyy HH:mm a"/></td>
									                    <td><s:property value="vehicle"/>/<s:property value="vehicleMileage"/></td>
									                    <td><s:property value="workshop"/></td>
									                    <td><s:property value="office"/>/<s:property value="client"/></td>
									                    <td><s:property value="complaints"/></td>
									                    <td><s:property value="status"/></td>
									                </tr>
									            </s:iterator>
									        </s:if>
								        </tbody>
								    </table>
						    	</div>
						    </fieldset>
						</div>
					</s:form>
				</td>
			</tr>
		</table>
	</div>
	
</body>
</html>
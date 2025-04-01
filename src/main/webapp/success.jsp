<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
    <title>Request Submitted Successfully</title>
<s:head/>
</head>
<body>
    
    
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
								<h1>Request was updated successfully</h1>
							    <p>Click <a href="<s:url action='viewHistory'/>">here</a> to go back to the request list.</p>
							    <p>Click <a href="<s:url action='generateReport'/>">here</a> to generate a PDF report.</p>
							</tr>
						</tbody>
					</table>
				</fieldset>
		</div>
	</div>
	</div>
</body>
</html>
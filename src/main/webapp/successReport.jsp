<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Report Success</title>
</head>
<body>
	<div class="tabPaneWrapper">
			<div class="tabPane">
				<br/>
					<fieldset>
						<table style="width: 100%">
							<tbody>
								<tr>
									<s:form action="generateReport" method="post">
									    <s:submit value="Generate Report" />
									</s:form>
									
									<s:if test="hasActionErrors()">
									    <div class="error">
									        <s:actionerror />
									    </div>
									</s:if>
									
									<s:if test="successMessage != null">
									    <div class="success">
									        <s:property value="successMessage" />
									    </div>
									</s:if>
								</tr>
							</tbody>
						</table>
					</fieldset>
			</div>
		</div>
</body>
</html>
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-textbox code="investor.yeah.form.label.text" path="text"/>
	
	<acme:form-return code="investor.investmentRound.form.button.return"/>
</acme:form>
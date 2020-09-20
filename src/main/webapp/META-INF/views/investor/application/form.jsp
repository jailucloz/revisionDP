
<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

 
<acme:form>

<jstl:if test="${ command == 'create'}">
	<acme:form-textbox code="investor.application.form.label.ticker" path="ticker"/>
	<acme:form-textbox code="investor.application.form.label.statement" path="statement"/>
	<acme:form-money code="investor.application.form.label.offer" path="offer" />
</jstl:if>

<jstl:if test="${ command == 'show'}">
	<acme:form-textbox code="investor.application.form.label.ticker" path="ticker" readonly="true"/>
	<acme:form-moment code="investor.application.form.label.creationMoment" path="creationMoment" readonly="true"/>
	<acme:form-textbox code="investor.application.form.label.statement" path="statement" readonly="true"/>
	<acme:form-money code="investor.application.form.label.offer" path="offer" readonly="true"/>
</jstl:if>

<jstl:if test="${ command == 'show'}">
	<acme:form-textbox code="investor.application.form.label.additionalInformation" path="additionalInformation"/>
	<acme:form-textbox code="investor.application.form.label.password" path="password"/>
</jstl:if>

<jstl:if test="${ command == 'update-offer'}">
	<acme:form-textbox code="investor.application.form.label.additionalInformation" path="additionalInformation"/>
	<acme:form-textbox code="investor.application.form.label.password" path="password"/>
</jstl:if>

	
	<acme:form-submit test="${command == 'create'}" code="investor.application.form.button.create"
		action="/investor/application/create?invId=${invId}" />
		
	<acme:form-submit test="${command == 'show'}" 
		code="investor.application.form.button.update"
		action="/investor/application/update-offer" />
	<acme:form-submit test="${command == 'update-offer'}" 
		code="investor.application.form.button.update"
		action="/investor/application/update-offer" />
	
	<acme:form-return code="investor.application.form.button.return"/>
</acme:form>
 
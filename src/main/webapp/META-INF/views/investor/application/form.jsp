<%--
- form.jsp
-
- Copyright (c) 2019 Rafael Corchuelo.
-
- In keeping with the traditional purpose of furthering education and research, it is
- the policy of the copyright owner to permit non-commercial use and redistribution of
- this software. It has been tested carefully, but it is not guaranteed for any particular
- purposes.  The copyright owner does not offer any warranties or representations, nor do
- they accept any liabilities with respect to them.
--%>

<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
<acme:form-hidden path="investId"/>
	<acme:form-textbox code="investor.application.form.label.ticker" path="ticker" readonly="true"/>
	<!--<acme:form-moment code="investor.application.form.label.creationMoment" path="creationMoment"/>-->
	<acme:form-textbox code="investor.application.form.label.statement" path="statement" readonly="true"/>
	<%-- <acme:form-money code="investor.application.form.label.offer" path="offer"/>
	 --%>
	<acme:form-money code="investor.application.form.label.offer" path="offer"  readonly="true"/>
	
<jstl:if test="${ command == 'show'}">
<jstl:if test="${ additionalInformation != null}">
	<acme:form-textbox code="investor.application.form.label.additionalInformation" path="additionalInformation"/>
	<acme:form-textbox code="investor.application.form.label.password" path="password"/>
	<acme:form-submit  code="authenticated.entrepreneur.form.button.update"
	 action="/investor/application/update-offer"/>	
</jstl:if>
</jstl:if>
	
	<acme:form-submit test="${command == 'create'}" code="investor.application.form.button.create"
		action="/investor/application/create?id=${investId}" />
		
	
	
	<acme:form-return code="investor.application.form.button.return"/>
</acme:form>

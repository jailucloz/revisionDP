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
<acme:form-hidden path="id"/>

	<acme:form-textbox code="investor.application.form.label.additionalInformation" path="additionalInformation" readonly="true"/>
	<acme:form-textbox code="investor.application.form.label.password" path="password" readonly="true"/>
	
	<acme:form-submit test="${command == 'update'}" code="investor.application.form.button.update"
		action="/investor/application/update?id=${id}" />
	
	<acme:form-return code="investor.application.form.button.return"/>
</acme:form>

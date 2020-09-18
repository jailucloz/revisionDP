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
	<acme:form-textbox code="administrator.inquires.form.label.title" path="title"/>
	<jstl:if test="${command != 'create'}">
		<acme:form-moment code="administrator.inquires.form.label.creationMoment" path="creationMoment" readonly="true"/>
	</jstl:if>
	<acme:form-moment code="administrator.inquires.form.label.deadline" path="deadline"/>
	<acme:form-textarea code="administrator.inquires.form.label.paragraphs" path="paragraphs"/>
	<acme:form-money code="administrator.inquires.form.label.minMoney" path="minMoney"/>
	<acme:form-money code="administrator.inquires.form.label.maxMoney" path="maxMoney"/>
	<acme:form-textbox code="administrator.inquires.form.label.email" path="email"/>
	
	<acme:form-submit test="${command == 'show'}" code="administrator.inquire.form.button.update" 
						action="/administrator/inquire/update"/>
	<acme:form-submit test="${command == 'show'}" code="administrator.inquire.form.button.delete" 
						action="/administrator/inquire/delete"/>
	<acme:form-submit test="${command == 'create'}" code="administrator.inquire.form.button.create" 
						action="/administrator/inquire/create"/>
	<acme:form-submit test="${command == 'update'}" code="administrator.inquire.form.button.update" 
						action="/administrator/inquire/update"/>
	<acme:form-submit test="${command == 'delete'}" code="administrator.inquire.form.button.delete" 
						action="/administrator/inquire/delete"/>
	
	<acme:form-return code="administrator.inquires.form.button.return"/>
</acme:form>

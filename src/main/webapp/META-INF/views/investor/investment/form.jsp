<%@page language="java"%>

<%@taglib prefix="jstl" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="acme" tagdir="/WEB-INF/tags"%>

<acme:form>
	<acme:form-url code="investor.investmentRound.form.label.ticker" path="ticker"/>
	<acme:form-url code="investor.investmentRound.form.label.moment" path="creationMoment"/>
	<acme:form-url code="investor.investmentRound.form.label.kindRound" path="roundKind"/>
	<acme:form-url code="investor.investmentRound.form.label.title" path="title"/>
	<acme:form-url code="investor.investmentRound.form.label.description" path="description"/>
	<acme:form-url code="investor.investmentRound.form.label.amountMoney" path="amount"/>
	<acme:form-url code="investor.investmentRound.form.label.link" path="additionalInformation"/>
	
	
	
		<a href=/acme-incubator/investor/romp/list?id=${id}><acme:message code="investor.investmentRound.romp.list" /></a>
    	<p></p>
	
		<acme:form-return code="investor.application.create" action="/investor/application/create?invId=${id}"/>
	
	
	
	<acme:form-return code="investor.investmentRound.form.button.return"/>
</acme:form>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="<c:url value='/resources/css/bootstrap.min.css' />" />
    <link rel="stylesheet" href="<c:url value='/resources/css/style.css' />" />
  </head>
  <body>
    <jsp:include page="navbar.jsp" />
    <section class="mainSection">
      <div class="container">
        <div class="row">
          <div class="col-md-12">
            <c:if test="${param.isConvertFromSelected eq false}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                  <spring:message code="warning.message.convert.from" text="Please select an option from 'Convert From'!" />
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
            </c:if>
            <c:if test="${param.isConvertToSelected eq false}">
                <div class="alert alert-warning alert-dismissible fade show" role="alert">
                  <spring:message code="warning.message.convert.to" text="Please select an option from 'Convert To'!" />
                  <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                  </button>
                </div>
            </c:if>
            <c:if test="${param.from ne null && param.to ne null && param.result ne null && param.rate ne null && param.amount ne null}">
                <input type="text" id="result" value="${param.from} (${param.amount}) => ${param.to} (@Rate: ${param.rate}) = ${param.result} ${param.to}" class="form-control mb-2" readonly />
            </c:if>
            <div class="form-div">
              <form action="/icc/convert" method="post">
                <div class="form-group">
                  <label for="convertFrom"><spring:message code="label.converted.from" text="Convert From" /> :</label>
                  <select
                    id="convertFrom"
                    name="convertFrom"
                    class="form-control"
                    required
                  >
                    <option selected disabled><spring:message code="label.select.from" text="Select from" /></option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="convertTo"><spring:message code="label.converted.to" text="Convert To" /> :</label>
                  <select
                    id="convertTo"
                    name="convertTo"
                    class="form-control"
                    required
                  >
                    <option selected disabled><spring:message code="label.select.to" text="Select To" /></option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="amount"><spring:message code="label.amount" text="Amount" /> :</label>
                  <input
                    type="text"
                    class="form-control"
                    name="amount"
                    id="amount"
                    inputmode="decimal"
                    pattern="[0-9]*[.]?[0-9]*"
                    required
                  />
                </div>
                <input type="submit" class="btn btn-primary" value="<spring:message code="label.convert" text="Convert" />" />
              </form>
            </div>
          </div>
        </div>
      </div>
    </section>

    <script src="<c:url value='/resources/js/jquery-3.7.0.min.js' />"></script>
    <script src="<c:url value='/resources/js/popper.min.js' />"></script>
    <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
    <script src="<c:url value='/resources/js/fetchData.js' />"></script>
  </body>
</html>
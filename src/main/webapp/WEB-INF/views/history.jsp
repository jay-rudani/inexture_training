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
                    <table id="historyTable" class="table table-striped table-bordered" style="width:100%">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th><spring:message code="table.source.currency" text="Source Currency" /></th>
                                <th><spring:message code="table.target.currency" text="Target Currency" /></th>
                                <th><spring:message code="table.amount" text="Amount" /></th>
                                <th><spring:message code="table.exchange.rate" text="Exchange Rate" /></th>
                                <th><spring:message code="table.converted.amount" text="Converted Amount" /></th>
                                <th><spring:message code="table.converted.at" text="Converted At" /></th>
                            </tr>
                        </thead>
                        <tbody>
                            <c:forEach items="${histories}" var="history">
                                <tr>
                                    <td>${history.id}</td>
                                    <td>${history.sourceCurrency}</td>
                                    <td>${history.targetCurrency}</td>
                                    <td>${history.amount}</td>
                                    <td>${history.exchangeRate}</td>
                                    <td>${history.convertedAmount}</td>
                                    <td>${history.convertedAt}</td>
                                </tr>
                            </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </div>
        </section>

        <script src="<c:url value='/resources/js/jquery-3.7.0.min.js' />"></script>
        <script src="<c:url value='/resources/js/popper.min.js' />"></script>
        <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
        <script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>
        <script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap4.min.js"></script>
        <script>
            $(function(){
                new DataTable('#historyTable', {
                    pageLength: 5,
                    search: {
                        return: true
                    },
                    lengthMenu: [[5, 10, 20, -1], [5, 10, 20, 'All']]
                });
            });
        </script>
    </body>
</html>
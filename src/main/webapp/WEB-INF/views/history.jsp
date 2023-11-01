<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
                    <table id="historyTable" class="table table-stripped table-responsive table-bordered">
                        <thead class="thead-dark">
                            <tr>
                                <th>#</th>
                                <th>Source Currency</th>
                                <th>Target Currency</th>
                                <th>Amount</th>
                                <th>Exchange Rate</th>
                                <th>Converted Amount</th>
                                <th>Converted At</th>
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
    </body>
</html>
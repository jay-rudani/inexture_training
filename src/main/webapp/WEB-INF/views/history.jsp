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
                <div class="col-md-12 mb-3">
                <c:if test="${param.entries eq 0 && not empty param.entries}">
                    <div class="alert alert-warning alert-dismissible fade show" role="alert">
                      <h6>Entries should be greater than or equal to 1</h6>
                      <button type="button" class="close" data-dismiss="alert" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                      </button>
                    </div>
                </c:if>
                    <form method="get" action="/icc/history">
                        <div class="d-flex justify-content-between">
                            <div class="form-group">
                                <label>Search :</label>
                                <input type="text" name="keyword" id="keyword" class="form-control" placeholder="Search Here..." />
                            </div>
                            <div class="form-group">
                                <label>Entries :</label>
                                <input type="number" name="entries" id="entries" class="form-control" placeholder="No. of Entries..." />
                            </div>
                            <input type="submit" class="d-none" />
                        </div>
                    </form>
                </div>
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
                    <div>
                        <c:if test="${totalPages > 1}">
                            <label>No of. Pages :</label>
                            <c:forEach begin="0" end="${totalPages - 1}" var="i">
                                <c:choose>
                                    <c:when test="${i == currentPage}">
                                        <span>${i + 1}</span>
                                    </c:when>
                                    <c:otherwise>
                                        <a href="?start=${i}&keyword=${param.keyword}&entries=${param.entries}" class="btn btn-sm btn-secondary">${i + 1}</a>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>
                        </c:if>
                    </div>
                </div>
            </div>
        </div>
        </section>

        <script src="<c:url value='/resources/js/jquery-3.7.0.min.js' />"></script>
        <script src="<c:url value='/resources/js/popper.min.js' />"></script>
        <script src="<c:url value='/resources/js/bootstrap.min.js' />"></script>
        <!--<script src="https://cdn.datatables.net/1.13.6/js/jquery.dataTables.min.js"></script>-->
        <!--<script src="https://cdn.datatables.net/1.13.6/js/dataTables.bootstrap4.min.js"></script>-->
        <!--<script>
            $(function(){
                console.log(${histories.size()});
                new DataTable('#historyTable', {
                    "searching" : false,
                    "lengthChange": false,
                    "pageLength" : ${pageLength}
                });
            });
        </script>-->
    </body>
</html>
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
            <c:if test="${param.from ne null && param.to ne null && param.result ne null}">
                <input type="text" id="result" value="${param.from} -> ${param.to} = ${param.result}" class="form-control mb-2" readonly />
            </c:if>
            <div class="form-div">
              <form action="/icc/convert" method="post">
                <div class="form-group">
                  <label for="convertFrom">Converted From :</label>
                  <select
                    id="convertFrom"
                    name="convertFrom"
                    class="form-control"
                    required
                  >
                    <option selected disabled>Select From</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="convertTo">Converted To :</label>
                  <select
                    id="convertTo"
                    name="convertTo"
                    class="form-control"
                    required
                  >
                    <option selected disabled>Select To</option>
                  </select>
                </div>
                <div class="form-group">
                  <label for="amount">Amount :</label>
                  <input
                    type="number"
                    class="form-control"
                    name="amount"
                    id="amount"
                    required
                  />
                </div>
                <input type="submit" class="btn btn-primary" value="Convert" />
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
<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<nav class="navbar navbar-expand-lg justify-content-between">
  <a class="navbar-brand btn btn-secondary" href="/icc/"><spring:message code="link.home" text="Home" /></a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
      <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="navbarSupportedContent">
      <ul class="navbar-nav mr-auto">
        <li class="nav-item active">
          <a class="nav-link text-dark" href="/icc/history"><spring:message code="link.history" text="History" /></a>
        </li>
      </ul>
      <form class="form-inline">
        <ul class="navbar-nav mr-auto">
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                  Choose Language
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdown">
                  <a class="dropdown-item" href="/icc/?language=en">English</a>
                  <a class="dropdown-item" href="/icc/?language=fr">French</a>
                  <a class="dropdown-item" href="/icc/?language=es">Spanish</a>
                </div>
            </li>
        </ul>
      </form>
  </div>
</nav>
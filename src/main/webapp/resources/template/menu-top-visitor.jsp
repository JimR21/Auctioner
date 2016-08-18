<link href=<c:url value="/resources/css/bootstrap.min.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/bootstrap-lumen.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/iconmoon.css" /> rel="stylesheet" type="text/css">
<link href=<c:url value="/resources/css/style.css" /> rel="stylesheet" type="text/css">


<!-- Navigation -->
<nav id="menu" class="navbar navbar-default navbar-fixed-top">
    <div class="container">

        <div class="navbar-header">
            <!-- Button when screen gets smaller -->
            <button class="btn navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse" type="button">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span> <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <div id="logo" >
                <a class="navbar-brand" href="home"><span class="icon-hammer2"></span> Auctioner</a>
            </div>
        </div>

        <div class="navbar-collapse collapse">
            <ul class="nav navbar-nav">
                <li><a href="showauctions">Auctions</a></li>
                <li><a href="about">About</a></li>
            </ul>

            <form id="signin" class="navbar-form navbar-right" role="form">
                <a class="btn btn-primary" href="login">Login</a>
                or
                <a class="btn btn-warning" href="registration">Sign up</a>
            </form>
        </div>
    </div>
</nav>

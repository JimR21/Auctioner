<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">

<head>

	<meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

    <link href=<c:url value="/resources/css/auction.css" /> rel="stylesheet" type="text/css">

    <title>Auctioner</title>

</head>

<body>

   	 <%@ include file="/resources/template/menu-top.jsp" %>


    <div class="container single-item-content">

        <div class="row">
            <div class="col-xs-5 single-content-left">
                <div id="main_area">
                        <!-- Slider -->
                        <div class="row">
                            <div class="col-xs-12" id="slider">
                                <!-- Top part of the slider -->
                                <div class="row">
                                    <div class="col-sm-12" id="carousel-bounding-box">
                                        <div class="carousel slide" id="myCarousel">
                                            <!-- Carousel items -->
                                            <div class="carousel-inner">
                                                <div class="active item single-item-img" data-slide-number="0">
                                                <img src="http://placehold.it/480x480&text=two"></div>

                                                <div class="item single-item-img" data-slide-number="1">
                                                <img src="http://placehold.it/480x480&text=two"></div>

                                                <div class="item single-item-img" data-slide-number="2">
                                                <img src="http://placehold.it/480x480&text=three"></div>

                                                <div class="item single-item-img" data-slide-number="3">
                                                <img src="http://placehold.it/480x480&text=four"></div>
                                            </div><!-- Carousel nav -->
                                            <a class="left carousel-control" href="#myCarousel" role="button" data-slide="prev">
                                                <span class="glyphicon glyphicon-chevron-left"></span>
                                            </a>
                                            <a class="right carousel-control" href="#myCarousel" role="button" data-slide="next">
                                                <span class="glyphicon glyphicon-chevron-right"></span>
                                            </a>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div><!--/Slider-->

                        <div class="row hidden-xs" id="slider-thumbs">
                                <!-- Bottom switcher of slider -->
                                <ul class="hide-bullets">
                                    <li class="col-sm-3">
                                        <a class="thumbnail" id="carousel-selector-0"><img src="http://placehold.it/200x200&text=two"></a>
                                    </li>

                                    <li class="col-sm-3">
                                        <a class="thumbnail" id="carousel-selector-1"><img src="http://placehold.it/200x200&text=two"></a>
                                    </li>

                                    <li class="col-sm-3">
                                        <a class="thumbnail" id="carousel-selector-2"><img src="http://placehold.it/200x200&text=three"></a>
                                    </li>

                                    <li class="col-sm-3">
                                        <a class="thumbnail" id="carousel-selector-3"><img src="http://placehold.it/200x200&text=four"></a>
                                    </li>

                                    <li class="col-sm-3">
                                        <a class="thumbnail" id="carousel-selector-3"><img src="http://placehold.it/200x200&text=four"></a>
                                    </li>

                                    <li class="col-sm-3">
                                        <a class="thumbnail" id="carousel-selector-3"><img src="http://placehold.it/200x200&text=four"></a>
                                    </li>
                                </ul>
                        </div>
                    </div>
            </div>
            <div class="col-xs-7 single-content-right" >
                <h2 class="text-uppercase">${auction.name}</h2>
                <br />
                <p>
                    ${auction.description}
                </p>
                <br />
                <br />
                <h3>Starting Price: ${auction.firstBid}</h3>
                <br />
                <c:if test="${auction.buyPrice != null}">
                    <div class="col-md-4">
                        <h3> Buy it now!</h3>
                        <button class="btn btn-default btn-block">${auction.buyPrice}</button>
                        <br />
                    </div>
                </c:if>
            </div>
            <div class="col-md-3">
                <h3>Current Price</h3>
                <h3 id="currentPrice"></h3>
                <h3>Auction Ends In</h3>
                <div class="panel panel-default"  data-placement="top">
                  <div class="panel-body" style="text-align: center;">
                    <div class="lead" id="clock"></div>
                  </div>
                </div>
                <h3>Place Bid</h3>
                <form id role="form">
                    <div class="col-md-6">
                        <div class="form-group">
                            <input type="text" class="form-control" id="bidInput" placeholder="Amount">
                        </div>
                    </div>
                    <div class="col-md-6" data-pg-collapsed>
                        <button id="bidButton" type="button" class="btn btn-default btn-block">Bid</button>
                    </div>
                </form>
            </div>
            <div class="col-md-4">
                <h3>Bids</h3>
                <div class="well bids-well">
                    <ul id="liveFeed" class="list-group">
                    </ul>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-sm-12">
                <ul class="nav nav-tabs">
                    <li class="active"><a href="#detailsTab" data-toggle="tab">DETAILS</a></li>
                    <li><a href="#locationTab" data-toggle="tab">LOCATION</a></li>
                    <li><a href="#auctioneerTab" data-toggle="tab">AUCTIONEER INFO</a></li>
                </ul>

                <div class="tab-content">
                    <div class="well tab-pane active" id="detailsTab">
                        <h4>Description</h4>
                        <p>
                            ${auction.description}
                        </p>
                    </div>
                    <div class="well tab-pane" id="locationTab">
                        <div class="container">
                            <div class="col-sm-4">
                                <p class="lead">
                                    Country: ${auction.country} <br />
                                    Location: ${auction.location.name}
                                </p>
                            </div>
                            <div class="col-sm-8">
                                GoogleMaps
                            </div>
                        </div>
                    </div>
                    <div class="well tab-pane" id="auctioneerTab">

                        <div class="container">
                            <h2>${auction.user.username}</h2>
                            <div class="col-sm-6">
                                <p class="lead">
                                    Name: ${auction.user.firstName} <br />
                                    Lastname: ${auction.user.lastName} <br />
                                    <span class="icon-phone"></span>: ${auction.user.phone} <br /><br />
                                    Country: ${auction.user.country} <br />
                                    City: ${auction.user.city}
                                </p>
                            </div>
                            <div class="col-sm-6">
                                <h3>User Rating</h3>
                            </div>
                            <div class="col-sm-11">
                                <a href="/Auctioner/profile/${auction.user.userid}" class="btn btn-default pull-right">View Profile</a>
                            </div>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <%-- Suggestions and New Auctions --%>
        <div class="row">
            <hr style="width: 100%; color: black; height: 1px; background-color:black;" />
            <div class="container">
                <div class="row">
                    <div class="row">
                        <div class="col-md-9">
                            <h3>
                                Suggestions</h3>
                        </div>
                        <div class="col-md-3">
                            <!-- Controls -->
                            <div class="controls pull-right hidden-xs">
                                <a class="left fa fa-chevron-left btn btn-success" href="#carousel-example"
                                    data-slide="prev"></a><a class="right fa fa-chevron-right btn btn-success" href="#carousel-example"
                                        data-slide="next"></a>
                            </div>
                        </div>
                    </div>
                    <div id="carousel-example" class="carousel slide hidden-xs" data-ride="carousel">
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Sample Product</h5>
                                                        <h5 class="price-text-color">
                                                            $199.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Product Example</h5>
                                                        <h5 class="price-text-color">
                                                            $249.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Next Sample Product</h5>
                                                        <h5 class="price-text-color">
                                                            $149.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Sample Product</h5>
                                                        <h5 class="price-text-color">
                                                            $199.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="row">
                                    <div class="col-sm-3">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Product with Variants</h5>
                                                        <h5 class="price-text-color">
                                                            $199.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Grouped Product</h5>
                                                        <h5 class="price-text-color">
                                                            $249.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Product with Variants</h5>
                                                        <h5 class="price-text-color">
                                                            $149.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-3">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Product with Variants</h5>
                                                        <h5 class="price-text-color">
                                                            $199.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="row">
                    <div class="row">
                        <div class="col-md-9">
                            <h3>
                                New Auctions</h3>
                        </div>
                        <div class="col-md-3">
                            <!-- Controls -->
                            <div class="controls pull-right hidden-xs">
                                <a class="left fa fa-chevron-left btn btn-primary" href="#carousel-example-generic"
                                    data-slide="prev"></a><a class="right fa fa-chevron-right btn btn-primary" href="#carousel-example-generic"
                                        data-slide="next"></a>
                            </div>
                        </div>
                    </div>
                    <div id="carousel-example-generic" class="carousel slide hidden-xs" data-ride="carousel">
                        <!-- Wrapper for slides -->
                        <div class="carousel-inner">
                            <div class="item active">
                                <div class="row">
                                    <div class="col-sm-4">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Sample Product</h5>
                                                        <h5 class="price-text-color">
                                                            $199.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Product Example</h5>
                                                        <h5 class="price-text-color">
                                                            $249.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Next Sample Product</h5>
                                                        <h5 class="price-text-color">
                                                            $149.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="item">
                                <div class="row">
                                    <div class="col-sm-4">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Product with Variants</h5>
                                                        <h5 class="price-text-color">
                                                            $199.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Grouped Product</h5>
                                                        <h5 class="price-text-color">
                                                            $249.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-sm-4">
                                        <div class="col-item">
                                            <div class="photo">
                                                <img src="http://placehold.it/350x260" class="img-responsive" alt="a" />
                                            </div>
                                            <div class="info">
                                                <div class="row">
                                                    <div class="price col-md-6">
                                                        <h5>
                                                            Product with Variants</h5>
                                                        <h5 class="price-text-color">
                                                            $149.99</h5>
                                                    </div>
                                                    <div class="rating hidden-sm col-md-6">
                                                        <i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="price-text-color fa fa-star"></i><i class="price-text-color fa fa-star">
                                                        </i><i class="fa fa-star"></i>
                                                    </div>
                                                </div>
                                                <div class="separator clear-left">
                                                    <p class="btn-add">
                                                        <i class="fa fa-shopping-cart"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">Add to cart</a></p>
                                                    <p class="btn-details">
                                                        <i class="fa fa-list"></i><a href="http://www.jquery2dotnet.com" class="hidden-sm">More details</a></p>
                                                </div>
                                                <div class="clearfix">
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

    </div>

    <%@ include file="/resources/template/footer.jsp" %>

    <script src=<c:url value="/resources/js/auction.js" />></script>
    <script src=<c:url value="/resources/js/jquery.countdown.min.js" />></script>
    <script src=<c:url value="/resources/js/auction-carousels.js" />></script>
    <script src=<c:url value="/resources/js/date.format.js" />></script>

    <script>

    auctionId = "${auction.auctionid}";

    ends = "${ends}";

    /* Asychronous check of Bids */
    numberofBids = 0;

    stopFlag = 0;

    function pollforBids(){

        if(stopFlag == 1)   // Recursive returns
            return;

        var url = "/Auctioner/checkBids/" + auctionId

        if (request) {
            request.abort();  // abort any pending request
        }

        var request = $.ajax({
            url: url,
            type: "GET",
            data: {numofBids : numberofBids},
            timeout:45000,
            success: function( data ) {

                if (data.info.numofBids == numberofBids)
                    console.log("No new bids")
                else {
                    console.log('New bids: ' + (data.info.numofBids - numberofBids));
                    console.log(data.bids);
                    numberofBids = data.info.numofBids;
                    updatePriceAndLiveFeed(data);
                }
                pollforBids();  // Recursion
            },
            error: function(data){
                console.log("pollforBids: ERROR: " + data.responseText);
                stopFlag = 1;
            }
        });
    }

    function updatePriceAndLiveFeed(data) {
        $('#currentPrice').text(data.info.latestBid);

        var bids = data.bids;
        var bid;
        var i;
        for(i = bids.length-1; i >= 00 ; i--) {
            bid = bids[i];
            console.log('Name: ' + bid.username);
            var time = new Date(bid.time);
            var formattedTime = time.format("isoTime");

            $('#liveFeed').prepend('<li class="list-group-item">'+ formattedTime + ' ' + bid.username + ' bidded '+ bid.amount + '</li>');
        }
    }

    window.addEventListener('load',
      function() {
        pollforBids();
    }, false);

    /* On button click call bidPost() */
    $('#bidButton').on('click', function(){
        console.log("bidButton clicked")
        bidPost();
    });

    /* Function to ajax post the bid */
    function bidPost() {

        var bidUrl = "/Auctioner/auction/bid/" + auctionId;

        var amount = $('#bidInput').val();
        console.log("Amount: " + amount);

        $.ajax({
            url: bidUrl,
            type: "POST",
            data: {bidAmount : amount},
            success: function( data ) {
                console.log("bidPost: " + data);
            },
            error: function(data){

                console.log("ERROR: " + data.responseText);
            }
        });
    }

    </script>

    <script src=<c:url value="/resources/js/auction.js" />></script>

</body>

</html>

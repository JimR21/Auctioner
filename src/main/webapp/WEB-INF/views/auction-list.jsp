
    <div class="well well-sm">
        <div class="pull-left">
            <p style="font-size: 16px" >Found ${filter.numberofItems} results<p>
        </div>
        <div class="btn-group">
            <a href="#" id="list" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th-list"></span>List</a>
            <a href="#" id="grid" class="btn btn-default btn-sm"><span class="glyphicon glyphicon-th"></span>Grid</a>
        </div>
        <div class="pull-right dropdown">
            <button class="btn btn-default btn-sm" data-toggle="dropdown">${filter.sortByOutput} <span class="caret"></span></button>
            <ul class="dropdown-menu" id="sortDropdown">
                <li><a href="/Auctioner/auctions?sortBy=ends">Ending Date</a></li>
                <li><a href="/Auctioner/auctions?sortBy=firstBid">Starting Price</a></li>
            </ul>
        </div>
    </div>
    <div id="products" class="row list-group">
        <c:forEach items="${auctions}" var="auction">
            <div class="item  col-xs-4 col-lg-4">
                <div class="thumbnail item-shadow">
                    <div class="auction-list-img-div">
                        <c:if test="${not empty auction.primaryImage}">
                            <a href="/Auctioner/auction/${auction.auctionid}"><img src="data:image/jpeg;base64,${auction.primaryImage}" alt="auction-image" /></a>
                        </c:if>
                        <c:if test="${empty auction.primaryImage}">
                            <a href="/Auctioner/auction/${auction.auctionid}"><img src="<c:url value="/resources/images/hammer1.png"/>" alt="hammer-image" /></a>
                        </c:if>
                    </div>
                    <div class="caption">
                        <div class="text-limit">
                            <h4 class="group inner list-group-item-heading">${auction.name}</h4>
                        </div>
                        <div class="row">
                            <div class="col-xs-12 col-md-6">
                                <p class="price-tag"><strong>&#36;${auction.firstBid}</strong></p>
                            </div>
                            <div class="col-xs-12 col-md-6">
                                <a class="btn btn-primary" href="/Auctioner/auction/${auction.auctionid}">View More</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </c:forEach>
    </div>

        <%-- <div class="item  col-xs-4 col-lg-4">
            <div class="thumbnail">
                <img class="group list-group-image" src="http://placehold.it/400x250/000/fff" alt="" />
                <div class="caption">
                    <h4 class="group inner list-group-item-heading">
                        Product title</h4>
                    <p class="group inner list-group-item-text">
                        Product description... Lorem ipsum dolor sit amet, consectetuer adipiscing elit,
                        sed diam nonummy nibh euismod tincidunt ut laoreet dolore magna aliquam erat volutpat.</p>
                    <div class="row">
                        <div class="col-xs-12 col-md-6">
                            <p class="lead">
                                $21.000</p>
                        </div>
                        <div class="col-xs-12 col-md-6">
                            <a class="btn btn-success" href="http://www.jquery2dotnet.com">Add to cart</a>
                        </div>
                    </div>
                </div>
            </div>
        </div> --%>

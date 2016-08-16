var users_visited = false;
var auctions_visited = false;

$('[data-toggle="pill"]').click(function(e) {
    var $this = $(this),
        loadurl = $this.attr('href'),
        targ = $this.attr('data-target');

    /* Load only once */
    if((users_visited == false && $this.attr('id') == "users_tab") || (auctions_visited == false && $this.attr('id') == "auctions_tab")) {
        $('#loading').addClass('opaque');                   // add opaque in background
        $('#loading').spin();                               // add spinner
        $(targ).load(loadurl, null, function() {
            $('#loading').spin();
            $('#loading').removeClass('opaque');
        });
    }

    /* Visited Pages = true if are load once */
    if($this.attr('id') == "users_tab") {
       users_visited = true;
    }
    if($this.attr('id') == "auctions_tab") {
       auctions_visited = true;
    }

    $this.tab('show');
       return false;
});

msg_notifications = 0;

function updateMsgBadge() {
    if(msg_notifications > 0) {
        $('#msg-badge').show(function() {
            $(this).text(msg_notifications);
        });
    }
    else {
        $('#msg-badge').hide();
    }
}

stopFlag = 0;

function chekforMessages(){

    if(stopFlag == 1)   // Recursive returns
        return;

    $.ajax({
        url: "/Auctioner/messaging/checkNewMessages",
        type: "GET",
        success: function( notification ) {
            //Check if any notifications are returned - if so then display alert
            msg_notifications = notification;
            console.log('checkforMessages: ' + notification);
            updateMsgBadge();
        },
        error: function(data){
            //handle any error
            console.log('checkforMessages: nothing');
             stopFlag = 1;
        }
    });
    if(stopFlag == 1)
        return;
    else
        setTimeout(chekforMessages, 30000);

}

function chekforMessagesOnce(){

    $.ajax({
        url: "/Auctioner/messaging/checkNewMessages",
        type: "GET",
        success: function( notification ) {
            //Check if any notifications are returned - if so then display alert
            msg_notifications = notification;
            console.log('checkforMessagesOnce: ' + notification);
            updateMsgBadge();
        },
        error: function(data){
            //handle any error
            console.log('checkforMessagesOnce: nothing');
            return;
        }
    });
}

window.addEventListener('load',
  function() {
    chekforMessages();
}, false);

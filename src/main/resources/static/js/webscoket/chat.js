/** webSocket对象 ***/
var webSocket = openWebSocket();
/**
 * WebSocket客户端
 *
 * 使用说明：
 * 1、WebSocket客户端通过回调函数来接收服务端消息。例如：webSocket.onmessage
 * 2、WebSocket客户端通过send方法来发送消息给服务端。例如：webSocket.send();
 */
function openWebSocket() {
    /**
     * WebSocket客户端 PS：URL开头表示WebSocket协议 中间是域名端口 结尾是服务端映射地址
     */
    /*
    * http下使用ws://xxx   https下使用wss://xxx
    * window.document.location.host = localhost:8080
    * ws/userId对应websocket服务的节点配置/ws/{userId}
    */
    var userId = $("#userId").text();
    var socketUrl = document.location.protocol === "https:" ?
        "wss://"+window.document.location.host+"/ws/"+userId : "ws://"+window.document.location.host+"/ws/"+userId;
    var webSocket = new WebSocket(socketUrl);
    /**
     * 当服务端打开连接
     */
    webSocket.onopen = function(event) {
        console.log('WebSocket打开连接');
    };
    /**
     * 当服务端发来消息：1.广播消息 2.更新在线人数
     */
    webSocket.onmessage = function(event) {
        console.log('WebSocket收到消息：%c' + event.data, 'color:green');
        //获取服务端消息
        var message = JSON.parse(event.data) || {};
        //发言
        if (message.type === 'SPEAK') {
            receiveMsgToChatView(message);
        }else if (message.type === 'ONLINE'){
            refreshList(message);
        }
    };
    /**
     * 关闭连接
     */
    webSocket.onclose = function(event) {
        console.log('WebSocket关闭连接');
    };
    /**
     * 通信失败
     */
    webSocket.onerror = function(event) {
        console.log('WebSocket发生异常');
    };
    return webSocket;
}
/**
 * 聊天界面添加接收的消息
 * @param message 消息对象
 */
function receiveMsgToChatView(message) {
    //显示发送人名称
    if(!message.receiveId){
        if($('#receiveId').val()){
            clearMsg();
        }
        $('#receiveId').val("");
        $('#receiveName').html("群发消息");
    }
    else if(message.userId !== $('#receiveId').val()){
        openNewChat(message.userId,message.userName);
    }
    //显示消息
    var item = document.createElement('div');
    item.className = 'item item-left';
    item.innerHTML = "<div class='avatar'><img src='/img/websocket/img1.jpg' /></div><div class='bubble bubble-left'>"+message.msg+"</div>";
    document.querySelector('.content').appendChild(item);
    document.querySelector('#textarea').value = '';
    document.querySelector('#textarea').focus();
    //滚动条置底
    var height = document.querySelector('.content').scrollHeight;
    document.querySelector(".content").scrollTop = height;
}
/**
 * 刷新好友列表
 * @param msgJson
 */
function refreshList(msgJson) {
    $('.friendList').empty();//清空列表
    $('#online').html(msgJson.userList.length - 1);//刷新在线人数
    for (var i=0; msgJson && msgJson.userList && i< msgJson.userList.length;i++) {
        var user = msgJson.userList[i];
        if(user.userId !== $("#userId").text()){
            var item = document.createElement('div');
            item.className = 'friendPhoto';
            item.innerHTML = "<div class='avatar'><img src='/img/websocket/img1.jpg' /></div> <div class='receiveId'>"+user.userId+"</div><div class='receiveName'>"+user.userName+"</div>";
            document.querySelector('.friendList').appendChild(item);
            //添加点击事件
            $('.friendPhoto').on("click",function () {
                var receiveId = $(this).children('.receiveId').text();
                var receiveName = $(this).children('.receiveName').text();
                openNewChat(receiveId,receiveName);
            });
        }
    }
}
/**
 * 打开新的聊天窗口
 * @param receiveId 接收人ID
 * @param receiveName 接收人名称
 */
function openNewChat(receiveId,receiveName) {
    $('#receiveId').val(receiveId);
    $('#receiveName').html(receiveName);
    clearMsg();
}
/**
 * 通过WebSocket对象发送消息给服务端
 * @param userId 发送人ID
 * @param userName 发送人名称
 * @param receiveId 接收人ID
 * @param receiveName 接收人名称
 */
function sendMsgToServer(userId,userName,receiveId,receiveName) {
    var text = document.querySelector('#textarea').value;
    if(!text){
        alert('请输入内容');
        return ;
    }
    webSocket.send(JSON.stringify({
        userId: userId,
        userName: userName,
        receiveId : receiveId,
        receiveName : receiveName,
        msg : text
    }));
    addMsgToChatView(text,receiveId,receiveName);
}
/**
 * 单独发送消息到指定人
 */
function sendMsgToOne(){
   var userId = $("#userId").text();
   var userName = $("#userName").text();
   var receiveId = $('#receiveId').val();
   var receiveName = $('#receiveName').html();
   sendMsgToServer(userId,userName,receiveId,receiveName);
}
/**
 * 群发消息
 */
function sendMsgToAll(){
    var userId = $("#userId").text();
    var userName = $("#userName").text();
    var receiveId = "";
    var receiveName = "群发消息";
    sendMsgToServer(userId,userName,receiveId,receiveName);
}
/**
 * 聊天界面添加发送的消息
 * @param msgText 消息
 * @param receiveId 接收人ID
 * @param receiveName 接收人名称
 */
function addMsgToChatView(msgText,receiveId,receiveName){
    //接收人ID不变则不清屏
    if (receiveId !== $('#receiveId').val()) {
        openNewChat(receiveId,receiveName);
    }
    if(!$('#receiveId').val()){
        $('#receiveName').html("群发消息");
    }
    var item = document.createElement('div');
    item.className = 'item item-right';
    item.innerHTML = "<div class='bubble bubble-left'>"+msgText+"</div><div class='avatar'><img src='/img/websocket/img2.jpg' /></div>";
    document.querySelector('.content').appendChild(item);
    document.querySelector('#textarea').value = '';
    document.querySelector('#textarea').focus();
    //滚动条置底
    var height = document.querySelector('.content').scrollHeight;
    document.querySelector(".content").scrollTop = height;
}
/**
 * 清屏
 */
function clearMsg() {
    $('.content').empty();
}
/**
 * 使用ENTER发送消息
 */
document.onkeydown = function(event) {
    var e = event || window.event
        || arguments.callee.caller.arguments[0];
    e.keyCode === 13 && sendMsgToOne();
};


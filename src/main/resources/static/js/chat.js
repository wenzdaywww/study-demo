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
            receiveMsgToChatView(message.msg);
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
 * 通过WebSocket对象发送消息给服务端
 */
function sendMsgToServer() {
    var text = document.querySelector('#textarea').value;
    if(!text){
        alert('请输入内容');
        return ;
    }
    webSocket.send(JSON.stringify({
        userId : $('#userId').text(),
        msg : text
    }));
    addMsgToChatView(text);
}
/**
 * 聊天界面添加发送的消息
 * @param msgText 消息
 */
function addMsgToChatView(msgText){
    var item = document.createElement('div');
    item.className = 'item item-right';
    item.innerHTML = "<div class='bubble bubble-left'>"+msgText+"</div><div class='avatar'><img src='/img/img2.jpg' /></div>";
    document.querySelector('.content').appendChild(item);
    document.querySelector('#textarea').value = '';
    document.querySelector('#textarea').focus();
    //滚动条置底
    var height = document.querySelector('.content').scrollHeight;
    document.querySelector(".content").scrollTop = height;
}

/**
 * 聊天界面添加接收的消息
 * @param msgText 消息
 */
function receiveMsgToChatView(msgText) {
    var item = document.createElement('div');
    item.className = 'item item-left';
    item.innerHTML = "<div class='avatar'><img src='/img/img1.jpg' /></div><div class='bubble bubble-left'>"+msgText+"</div>";
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

}
/**
 * 使用ENTER发送消息
 */
document.onkeydown = function(event) {
    var e = event || window.event
        || arguments.callee.caller.arguments[0];
    e.keyCode === 13 && sendMsgToServer();
};


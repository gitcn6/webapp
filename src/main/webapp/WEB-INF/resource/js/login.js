$(function(){
    //点击登陆操作
    $("#login").click(function(){
        var username = $("#username").val();
        var password = $("#password").val();
        /*$.ajax({
            url:""
        })
        Window.location.href =*/
    });
})
function addContent(url){
    $("#main_content").get(0).src = url;
}
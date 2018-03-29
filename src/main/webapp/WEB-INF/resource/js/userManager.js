$(function(){
    //初始化
    initUserData();

    $("#btn_sel").click(function(){

    });
    $("#btn_save").click(function(){
    	$.ajax({
    		url:"/webapp/frm/user/saveUser",
    		data:$("#user_form").serialize(),
    		dataType:"json",
    		type:"post",
    		success:function(msg){
    			alert(msg);
    		}
    	})
    });

    function initUserData() {
        var userName = $("#username").val();
        console.log("姓名:"+userName);
        $("#table").bootstrapTable({
            columns:[{checkbox:true},{
                field: 'id',
                title: '用户ID'
            }, {
                field: 'name',
                title: '姓名'
            }, {
                field: 'age',
                title: '年龄'
            },{
                field:'mailAddr',
                title:'邮箱'
            },{field:"opera",title:"操作",width:"20%"}],
            url:'/webapp/frm/user/getUsersByName?userName='+userName
            ,pagination:true
            ,pageNumber:1
            ,pageSize:5
            ,pageList:[5, 10, 25]
            ,showColumns:true
        });
    }
});
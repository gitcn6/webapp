$(function(){
    //初始化
    initUserData();

    $("#select").click(function(){

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
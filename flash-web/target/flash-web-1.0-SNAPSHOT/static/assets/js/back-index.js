$(function(){

    $.ajax({
        url : '../admin_getAdmin',
        type : 'get',
        success : function(result){
            if(result.code == 200){
                $('#adName').html(result.data.name);
                $('#adName2').html(result.data.name);
            }else{
                alert("no");
            }
        }
    });

    $('#aLogout').on('click',function () {
        $.ajax({
            url : '../admin_Logout',
            type : 'get',
            success : function(result){
                if(result.code == 200){
                    location.href = result.message;
                }else{
                    alert("no");
                }
            }
        });
    });
})
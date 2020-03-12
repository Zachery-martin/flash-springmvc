$(function () {

    $.ajax({
        url : '../customer_getCus',
        type : 'get',
        success : function(result){
            if(result.code == 200){
                $('#autName').html(result.data.name);
            }else{
                alert("no");
            }
        }
    });

    $('#auLogout').on('click',function () {
        $.ajax({
            url : '../customer_Logout',
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


});
$(function () {

    //新建
    $('#newAdd').on('click',function () {
        //使用FormData获取表单数据
        var formData = new FormData(document.getElementById('addUpLoadForm'));
        $.ajax({
            url : '../ReUpload_add',
            type : 'post',
            data : formData,
            processData : false, //告诉jquery不要去处理请求数据的格式
            contentType : false, //告诉jquery不要设置请求头的类型
            success : function(result){
                if(result.code == 200){
                    alert("新建成功成功!");
                    location.href = result.message;
                }else{
                    alert("no");
                }
            }
        });
    });

    $.ajax({
        url : '../author_getAuthor',
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
            url : '../author_Logout',
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
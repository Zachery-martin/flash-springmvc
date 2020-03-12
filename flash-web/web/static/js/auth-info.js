$(function () {

    $.ajax({
        url : '../author_getAuthor',
        type : 'get',
        success : function(result){
            if(result.code == 200){
                $('#autName').html(result.data.name);
                $('#inputlogId').val(result.data.autLogId);
                $('#inputName').val(result.data.name);
                $('#inputBirthday').val(result.data.birthday);
                $('#inputIdCard').val(result.data.idCard);
                $('#inputEmail').val(result.data.email);
                $('#inputPhone').val(result.data.phone);
                $('#inputAddress').val(result.data.address);
                $('#oldPwd').val(result.data.autLogPwd);
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

    //普通修改
    $('#ordinaryUpdate').on('click',function () {
        $.ajax({
            url : '../author_ordinary_update',
            data : $('#fOrdinary').serialize(),
            type : 'post',
            success : function(result){
                if(result.code == 200){
                    alert("修改成功!");
                    location.href = result.message;
                }else{
                    alert("no");
                }
            }
        });
    });


    //高级修改
    $('#seniorUpdate').on('click',function () {
        $.ajax({
            url : '../author_senior_update',
            data : $('#fSenior').serialize(),
            type : 'post',
            success : function(result){
                if(result.code == 200){
                    alert("修改成功!请重新登陆。");
                    location.href = result.message;
                }else{
                    alert("no");
                }
            }
        });
    });

    //修改密码
    $('#saveNewPwd').on('click',function () {
        if($('#orPwd').val() != $('#oldPwd').val()){
            alert("修改密码验证错误,请重新登陆账号");
            location.href = "auth-login.html";
        }
        else{
            $.ajax({
                url : '../author_pwd_update',
                data : $('#fPwd').serialize(),
                type : 'post',
                success : function(result){
                    if(result.code == 200){
                        alert("修改成功!请重新登陆。");
                        location.href = result.message;
                    }else{
                        alert("no");
                    }
                }
            });
        }
    });
});

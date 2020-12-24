
$(function () {

    $.ajax({
        url : '../customer_getCus',
        type : 'get',
        success : function(result){
            if(result.code == 200){
                $('#cusName').html(result.data.name);
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

    $.ajax({
        url : '../customer_getCus',
        type : 'get',
        success : function(result){
            if(result.code == 200){
                $('#cusName').html(result.data.name);
                $('#inputlogId').val(result.data.cusLogId);
                $('#inputName').val(result.data.name);
                $('#inputPhone').val(result.data.phone);
                $('#inputAddress').val(result.data.address);
                $('#inputAddress1').val(result.data.reAddress1);
                $('#inputAddress2').val(result.data.reAddress2);
                $('#inputAddress3').val(result.data.reAddress3);
                $('#oldPwd').val(result.data.cusLogPwd);
            }else{
                alert("no");
            }
        }
    });

    //普通设置
    $('#ordinaryUpdate').on('click',function () {
        $.ajax({
            url : '../customer_ordinary_update',
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


    //设置收货地址
    $('#seniorUpdate').on('click',function () {
        $.ajax({
            url : '../customer_address_update',
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
            location.href = "login.html";
        }
        else{
            $.ajax({
                url : '../customer_pwd_update',
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
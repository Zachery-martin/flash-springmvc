$(function () {
    $.ajax({
        url : '../customer_getCus',
        type : 'get',
        success : function(result){
            if(result.code == 200){
                $('#autName').html(result.data.name);
                $('#hidden').val(result.data.cusId);
                $.ajax({
                    url : '../cus_list_transaction',
                    type : 'get',
                    data : {'pageNum' : 1, 'pageSize' : 10, 'cusId' : $('#hidden').val()},
                    success : function(result){
                        if(result.code == 500){
                            alert(result.message);
                        }else{
                            //渲染表格
                            addTable(result.data);
                            //渲染分页
                            page(result.data);
                        }
                    }
                });
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


//渲染表格
function addTable(pageInfo){
    $('#tab tr:not(:first)').remove();
    $.each(pageInfo.list, function(index, obj){
        $('#tab').append(
            '<tr>' +
            '<td>'+obj.tid+'</td>'+
            '<td>'+obj.cid+'</td>'+
            '<td>'+obj.reAddress+'</td>'+
            '<td>'+obj.price+'</td>'+
            '<td>'+obj.payment+'</td>'+
            '<td>'+obj.camilo+'</td>'+
            '<td>'+obj.remarks+'</td>'+
            '</tr>'
        );
    });
}

//分页
function page(pageInfo){
    $("#page").pagination(pageInfo.total, { //第一个参数指定共多少条记录
        items_per_page:pageInfo.pageSize, // 每页显示多少条记录
        next_text:">", //下一页按钮图标
        prev_text:"<", //上一页按钮图标
        num_display_entries:5,//主体页数
        num_edge_entries: 2, //边缘页数
        callback: function(index){//定义一个回调函数，用于每次点击页码发起分页查询请求
            //index为当前页码，只不过下标是从0开始，因此需要+1操作
            var pageNum = ++index;
            $.ajax({
                url : '../cus_list_transaction',
                method : 'get',
                data : {'pageNum' : pageNum, 'pageSize' : 10, 'cusId' : $('#hidden').val()},
                success : function(result){
                    //渲染表格
                    addTable(result.data);
                }
            });
        }
    });
}


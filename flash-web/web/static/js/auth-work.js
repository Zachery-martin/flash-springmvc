$(function () {
    $.ajax({
        url : '../author_getAuthor',
        type : 'get',
        success : function(result){
            if(result.code == 200){
                $('#autName').html(result.data.name);
                $('#hidden').val(result.data.autId);
                $.ajax({
                    url : '../auth_list_ReUpload',
                    type : 'get',
                    data : {'pageNum' : 1, 'pageSize' : 10, 'autId' : $('#hidden').val()},
                    success : function(result){
                        if(result.code == 500){
                            alert(result.message);
                        }else{
                            //渲染表格
                            addTable(result.data);
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

    $('#btnUpdateWork').on('click',function () {
        $.ajax({
            url : '../ReUpload_update',
            method : 'post',
            data:$('#updateWorkModel').serialize(),
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
    $('#dataUl li:not(:first)').remove();
    $.each(pageInfo.list, function(index, obj){
        $('#dataUl').append(
            '<li>'+
            '<figure>'+
            '<a class="aa-product-img" href="#" id="'+obj.upLoadId+'" onclick="getWorkByUploadId(this);"><img src="../image/'+obj.imgUrl+'" alt="polo shirt img"></a>'+
            '<a class="aa-add-card-btn"href="#" id="'+obj.upLoadId+'" onclick="getWorkByUploadId(this);">' +
            '<span class="fa fa-search"></span>修改</a>'+
            '<figcaption>'+
            '<h4 class="aa-product-title"><a href="#">'+obj.workName+'</a></h4>'+
            '<span class="aa-product-price"></span><span class="aa-product-price">￥'+obj.price+'</span>'+
            '</figcaption>'+
            '<a href="#" id="'+obj.upLoadId+'" onclick="delWorkByUploadId(this);"><span class="aa-badge aa-hot">Del</span></a>'+
            '</li>'
        );
    });
}

//模态框获取当前点击的作品
function getWorkByUploadId(i){
    $(function(){
        var id=$(i).prop('id');
        $.ajax({
            url:'../getWorkByUploadId?upLoadId='+id,
            method:'get',
            success:function (result) {
                if(result.code==200){
                    $('#mymodal').modal('show');
                    $('#recipient-upLoadId').val(result.data.upLoadId);
                    $('#recipient-title').val(result.data.title);
                    $('#work-name').val(result.data.workName);
                    $('#work-introduce').val(result.data.introduce);
                    $('#work-remarks').val(result.data.remarks);
                    $('#work-price').val(result.data.price);
                }
            }
        })
    })
}

//删除当前点击的作品
function delWorkByUploadId(i){
    $(function(){
        var id=$(i).prop('id');
        $.ajax({
            url:'../ReUpload_del?upLoadId='+id,
            method:'post',
            success:function (result) {
                if(result.code==200){
                    location.href = result.message;
                }else{
                    alert("删除失败!");
                }
            }
        })
    })
}
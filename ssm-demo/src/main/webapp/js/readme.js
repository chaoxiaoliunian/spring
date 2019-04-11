/*
* 通常静态文件放到webapp目录下，而非WEB-INF目录下
* */
$(document).ready(
    function () {
        $('#myButton').bind('click', function () {
            console.log("发送ajax请求");
            //1.获取url；2.发送ajax请求；3.弹出返回结果;
            var url = $("#myUrl").val();
            $.ajax({
                'type': 'GET',
                'url': url,
                success: function (data) {
                    console.log(data);
                },
                error : function(XMLHttpRequest, textStatus, errorThrown) {
                    //请求的失败的返回的方法
                    alert("删除失败，请稍后再次尝试删除！");
                }
            });
        });
    }
);

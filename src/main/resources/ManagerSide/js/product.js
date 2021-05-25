$("#search_book_title").ready(function (){
    $("#product_list").empty();
    var title=$("#search_book_title").val();
    var binfo;
    $.ajax({
        url:"http://42.192.224.113:8080/ptj/job/",// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            binfo=data;
            $("#product_list").append('<tr>\n' +
                '    <th>商务编号</th>\n' +
                '    <th>名称</th>\n' +
                '    <th>内容</th>\n' +
                '    <th>报酬</th>\n' +
                '    <th>工作时间</th>\n' +
                '    <th>人数</th>\n' +
                '    <th>特殊要求</th>\n' +
                '    <th>操作</th>\n' +
                '   </tr>');
            for (var i=0;i<binfo.data.length;i++)
            {
                $("#product_list").append('<tr class="book" id="the_book'+i+'">\n' +
                    '    <td>\n' +
                    '     <span>\n' +
                    '     <i id="book_id">0</i>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_name">教材</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="td-name" >\n' +
                    '      <span class="ellipsis td-name block" id="book_body" style="word-break:break-all;white-space:normal;"></span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="salary">报酬</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_time">时间未定</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="nums">人数未定</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="requirement">000</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    //'     <a href="http://www.baidu.com/跳转至前台页面哦" title="查看" target="_blank"><img src="images/icon_view.gif"/></a>\n' +
                    '     <a href="edit_product.html" title="修改兼职" style="height:5px"><img src="images/icon_edit.gif"/></a>\n' +
                    '     <a href="order_detail.html" title="报名管理" style="height:5px"><img src="images/user_01.png"/></a>\n' +
                    '    </td>\n' +
                    '   </tr>');
                $("#the_book"+i+" #book_name").text(binfo.data[i].title);
                $("#the_book"+i+" #book_body").text(binfo.data[i].introduction);
                $("#the_book"+i+" #salary").text(binfo.data[i].salary);
                $("#the_book" + i + " #nums").text(binfo.data[i].nums);
                $("#the_book"+i+" #book_time").text(binfo.data[i].workDate);
                $("#the_book" + i + " #requirement").text(binfo.data[i].requirement);
                $("#the_book"+i+" #book_id").text(binfo.data[i].busid);
            }
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
});

$("#add_book").click(function (){
    alert("添加成功");
    $.ajax({
        url:"http://42.192.224.113:8080/ptj/bookinfo/addBook",// 发送请求的URL字符串。
        data:{// 发送到服务器的数据。
            title:$("#title").val(),
            author:$("#author").val(),
            body:$("#body").val(),
            Barcode:$("#Barcode").val(),
            Prize:$("#Prize").val(),
            Stock:$("#Stock").val(),
        },
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        type : "post", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("系统ajax交互错误: " + textStatus);
        }
    });
});

$("#search_product").click(function (){
    $("#product_list").empty();
    var title=$("#search_book_title").val();
    var binfo;
    $.ajax({
        url:"http://42.192.224.113:8080/ptj/job/search/"+title,// 发送请求的URL字符串。
        type : "get", //  请求方式 POST或GET
        dataType : "json", // 预期服务器返回的数据类型。
        async:  true , // 默认设置下，所有请求均为异步请求。如果设置为false，则发送同步请求
        // 请求成功后的回调函数。
        success :function(data){
            binfo=data;
            $("#product_list").append('<tr>\n' +
                '    <th>商务编号</th>\n' +
                '    <th>名称</th>\n' +
                '    <th>内容</th>\n' +
                '    <th>报酬</th>\n' +
                '    <th>工作时间</th>\n' +
                '    <th>人数</th>\n' +
                '    <th>特殊要求</th>\n' +
                '    <th>操作</th>\n' +
                '   </tr>');
            for (var i=0;i<binfo.data.length;i++)
            {
                $("#product_list").append('<tr class="book" id="the_book' + i + '">\n' +
                    '    <td>\n' +
                    '     <span>\n' +
                    '     <i id="book_id">0</i>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_name">教材</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="td-name" >\n' +
                    '      <span class="ellipsis td-name block" id="book_body" style="word-break:break-all;white-space:normal;"></span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="salary">报酬</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="book_time">时间未定</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="nums">人数未定</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    '     <span>\n' +
                    '      <em id="requirement">000</em>\n' +
                    '     </span>\n' +
                    '    </td>\n' +
                    '    <td class="center">\n' +
                    //'     <a href="http://www.baidu.com/跳转至前台页面哦" title="查看" target="_blank"><img src="images/icon_view.gif"/></a>\n' +
                    '     <a href="edit_product.html" title="修改兼职"><img src="images/icon_edit.gif"/></a>\n' +
                    '     <a href="order_detail.html" title="报名管理"><img src="images/user_01.png"/></a>\n' +
                    '    </td>\n' +
                    '   </tr>');
                $("#the_book" + i + " #book_name").text(binfo.data[i].title);
                $("#the_book" + i + " #book_body").text(binfo.data[i].introduction);
                $("#the_book" + i + " #salary").text(binfo.data[i].salary);
                $("#the_book" + i + " #nums").text(binfo.data[i].nums);
                $("#the_book" + i + " #book_time").text(binfo.data[i].workDate);
                $("#the_book" + i + " #requirement").text(binfo.data[i].requirement);
                $("#the_book" + i + " #book_id").text(binfo.data[i].busid);
            }
        },
        // 请求出错时调用的函数
        error : function(textStatus, errorThrown) {
            alert("错误");
        }
    });
})
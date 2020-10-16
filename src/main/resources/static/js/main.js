//var login_process = $('.ion-ios-locked-outline').on('click',function (){
//    var id = $('.login_id').val();
//    var password = $('.login_password').val();
//    $.ajax({
//        type: 'POST',
//        url: '/login',
//        dataType: 'json',
//        contentType:'application/json; charset=utf-8'
//    }).done(function() {
//        console.log(id+'님 환영합니다.');
//        window.location.href = '/user-join';
//    }).fail(function (error) {
//        alert(JSON.stringify(error));
//    });
//});

//var user = {
//    init : function (){
//        var _this = this;
//        $('#btn-userform').on('click',function(){
//            _this.save();
//        });
//    },
//    save : function (){
//        var id = $('.input_email').val();
//        var password = $('.input_password').val();
//        $.ajax({
//            type: 'POST',
//            url: '/user-join',
//            dataType: 'json',
//            contentType:'application/json; charset=utf-8'
//        }).done(function() {
//            console.log(id + "유저가 추가되었습니다.");
//            window.location.href = '/';
//        }).fail(function (error) {
//            alert(JSON.stringify(error));
//        });
//    },
//}

var project = {
    init : function(){
    var _this = this;
    $('.btn-project-save').on('click',function(){
        _this.save();
    });
    $('.btn_cancel').on('click',function(){
        window.location.href= '/';
    });
    },
    save : function(){
            var data = {
                title :  $('.project-save-title').val(),
                subTitle : $('.project-save-subTitle').val(),
                content : $('.project-save-content').val(),
            };
            $.ajax({
                type: 'POST',
                url: '/api/projects',
                dataType: 'json',
                contentType:'application/json; charset=utf-8',
                data : JSON.stringify(data)
            }).done(function() {
                alert("프로젝트가 추가되었습니다.");
                window.location.href = '/';
            }).fail(function (error) {
                alert(JSON.stringify(error));
            });
    },
}
var main = {
    init : function () {
//        login_process(); // 로그인 기능
//        user.init();
        project.init();
    },
}

main.init();


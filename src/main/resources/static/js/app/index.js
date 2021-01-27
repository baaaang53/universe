var main = {
    init : function () { // 다른 .js 파일에서 중복된 함수 이름을 쓰면 덮어질 수 있기 때문에 이렇게 각자 유효범위를 만들어서 사용
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
    },
    save : function () {
        var data = {
            title: $('#title').val(),
            author: $('#author').val(),
            content: $('#content').val()
        };

        $.ajax({
            type: 'POST',
            url: '/api/v1/posts', // 여기서 지금 PostsApiController의 postMapping을 작동시킨다.
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data)
        }).done(function() {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function(error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
var main = {
    init: function () { // 다른 .js 파일에서 중복된 함수 이름을 쓰면 덮어질 수 있기 때문에 이렇게 각자 유효범위를 만들어서 사용
        var _this = this;
        $('#btn-save').on('click', function () {
            _this.save();
        });
        $('#btn-update').on('click', function () { // 버튼이랑 연동할 거 있으면 여기서 한
            _this.update();
        });
        $('#btn-delete').on('click', function () {
            _this.delete();
        });
    },
    save: function () {
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
        }).done(function () {
            alert('글이 등록되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    update: function () {
        var data = {
            title: $('#title').val(),
            content: $('#content').val()
        };

        var id = $('#id').val();

        $.ajax({
            type: 'PUT', // 메소드 선택해서 호출할 수 있는 거
            url: '/api/v1/posts/' + id, // 어느 게시글을 수정할지
            dataType: 'json',
            contentType: 'application/json; charset=utf-8',
            data: JSON.stringify(data) // 이건 수정된 데이터가 있는 거
        }).done(function () {
            alert('글이 수정되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    },
    delete: function () {
        var id = $('#id').val();

        $.ajax({
            type: 'DELETE',
            url: '/api/v1/posts/' + id,
            dataType: 'json',
            contentType: 'application/json; charset=utf-8' // 얘는 따로 데이터는 필요 없
        }).done(function () {
            alert('글이 삭제되었습니다.');
            window.location.href = '/';
        }).fail(function (error) {
            alert(JSON.stringify(error));
        });
    }
};

main.init();
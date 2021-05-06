$(document).ready(function () {
    var persons = {};
    var url = "";
    var methodName = "";
    $("#addPerson").click(function (){
        persons.firstname = $('#firstname').val();
        persons.code = $('#code').val();
        persons.gender = $('#gender').val();
        persons.birth = $('#birth').val();
        persons.email = $('#email').val();
        persons.phone = $('#phone').val();
        persons.address = $('#address').val();
        var personId = $('#personId').val();

        if (personId){
            url = "http://localhost:8080/api/edit/"+personId;
            methodName = "PUT";
        }else {
            url = "http://localhost:8080/api/person";
            methodName = "POST";
        }
        var listPerson = JSON.stringify(persons);
        $.ajax({
            url : url,
            method : methodName,
            data : listPerson,
            contentType : 'application/json; charset=utf-8',
            success: function (){
                alert('Lưu thành công');
            },
            error: function (){
                alert("Chức năng thêm mới đang lỗi");
            }
        });
    });
});
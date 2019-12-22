function test () {


}

$(document).ready(function () {
    $.ajax({
        url: '/api/film/all',
                type: 'get',
                contentType: 'application/json; charset=utf-8',
                dataType: 'json',
                success: function (films) {
                console.log(films);
            for (let i = 0; i < films.length; i++) {
                $("#forAdd").before("<tr>" +
                    "<td>" + films[i].id + "</td>" +
                    "<td>" + films[i].title + "</td>" +
                    "<td>" + films[i].rating + "</td>" +
                    "<td>" + films[i].age + "</td>" +
                    "<td>" +
                    "<button class=\"btn btn-info\" data-toggle=\"modal\" data-target=\"#edit-modal\" onclick=\"fillModal(" + films[i].id + ")\">Edit</button>" +
                    "<a class=\"btn btn-danger\" href=\"/films/deleteFilm?id=" + films[i].id +"\">Delete</a>" +
                    "</td>" +
                    "</tr>")
            }

        },
        error: function (response) {
            alert('error');
        }
    });
});

function fillModal(id) {
   alert(id)

    $.ajax({
        method: "get",
        url: "/api/film/get?id=" + id,
        contentType: "application/json; charset=utf-8",
        success: function (films) {
            console.log(films);
            $("#id-edit").val(films.id);
            $("#title-edit").val(films.title);
            $("#rating-edit").val(films.rating);
            $("#age-edit").val(films.age);
        }
    })
}

function sendEditData() {
    var id = $("#id-edit").val();
    var title = $("#title-edit").val();
    var rating = $("#rating-edit").val();
    var age = $("#age-edit").val();

    var editedFilm = {
        'id' : id,
        'title' : title,
        'rating' : rating,
        'age' : age
    }
    $.ajax({
        method: "post",
        url: "/api/film/create",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(editedFilm),
        success: function() {
            window.location.replace("/film/all");
        },
        error: function (error) {

        }
    });
}
function DeleteFilmData() {
    $.ajax({
        method: "get",
        url: "/api/film/delete" + id,
        contentType: "application/json; charset=utf-8",
        success: function() {
            window.location.replace("/film/all");
        },
        error: function (error) {
            alert("errorrrrr");
        }
    });
}
function addFilm() {
    var title = $("#title").val();
    var rating = $("#rating").val();
    var age = $("#age").val();

    var newFilm = {
        'title' : title,
        'rating' : rating,
        'age' : age
    }
    $.ajax({
        method: "post",
        url: "/api/film/create",
        contentType: "application/json; charset=utf-8",
        data: JSON.stringify(newFilm),
        success: function() {
            window.location.replace("/film/all");
        },
        error: function (error) {

        }
    });
}
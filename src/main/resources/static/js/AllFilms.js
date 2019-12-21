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
                    "<a class=\"btn btn-info\" href=\"/films/editFilm?id=" + films[i].id+"\">Edit</a>" +
                    "<a class=\"btn btn-danger\" href=\"/films/deleteFilm?id=" + films[i].id+"\">Delete</a>" +
                    "</td>" +
                    "</tr>")
            }

        },
        error: function (response) {
            alert('error');
        }
    });
});
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
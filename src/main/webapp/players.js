$(document).ready(function() {


    getIdFromUrl();

    $.ajax({

        url: "/PlayerServlet",
        type: "GET",
        data: {"teamId" : getIdFromUrl()},
        success: function (data) {

            for(var i = 0; i < data.length; i++) {
                var id = data[i].id;
                var name = data[i].name;
                var age = data[i].age;
                var team = data[i].team;

                var htmlString = "Player: " + name +
                    "age: " + age;

                var p = document.createElement("p");
                var t = document.createTextNode(htmlString);
                p.id = id;
                p.appendChild(t);

                $("#players").append(p);
            }

        }
    });

    $("#add").click(function() {
        $.ajax({

            url: "/PlayerServlet",
            type: "POST",
            data: {"name": $("#name").val(), "age" : $("#age").val(), "team" : getIdFromUrl()},
            success: function(data) {
                    var id = data.id;
                    var name = data.name;
                    var age = data.age;
                    var team = data.team;

                    var htmlString = "Player: " + name +
                        "age: " + age;

                    var p = document.createElement("p");
                    var t = document.createTextNode(htmlString);
                    p.id = id;
                    p.appendChild(t);

                    $("#players").append(p);
                }
        })

    });


    function getIdFromUrl() {
        var idString = window.location.search.substring(4);
        console.log(idString);
        return idString;
    }


});

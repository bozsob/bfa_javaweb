$(document).ready(function() {

    $.ajax({
        url: "/teams",
        type: "GET",
        success: function (data) {

            for(var i = 0; i < data.length; i++) {
                var teamId = data[i].teamId;
                var teamName = data[i].teamName;
                var teamCountry = data[i].teamCountry;
                var teamCoach = data[i].teamCoach;
                var text = "Team: " + teamName + " - " +
                    "Country: " + teamCountry + " - " +
                        "Coach: " + teamCoach;

                var p = document.createElement("p");
                var t = document.createTextNode(text);
                p.appendChild(t);

                var a = document.createElement("a");
                var aText = document.createTextNode("Show Players");
                a.href = "players.html?id=" + teamId;
                a.appendChild(aText);

                p.id = teamId;
                p.appendChild(a);

                $("#teams").append(p);
            }
        }
    })
});

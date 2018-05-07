function showTable() {
    $.ajax({
        type:"post",
        url:"/testpage",
        success:function (result) {
            JSON.parse(result).forEach(function (id, description) {
                row =
                    "<tr>" +
                    "<td>" + id + "</td>" +
                    "<td>" + description + "</td>" +
                    "</tr>";
                $("#visitsTable").append(row);
            });

            result.id
        }

    });
}
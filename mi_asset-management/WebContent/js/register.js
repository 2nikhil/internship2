function get_final_details(asset_number) {
    $.ajax({
        type: "GET",
        cache: "false",
        url: "http://localhost:8080/mi_asset-management/rest/assets/" + asset_number,
        dataType: "xml",
        success: function(xml) {
            $(xml).find('assets_infoes').each(function() {
                $(this).find("Assets_info").each(function() {


                    $(this).find("_asset_number").each(function() {
                        name1 = $(this).text();

                    });



                    $(this).find("_color").each(function() {
                        name3 = $(this).text();


                    });

                    $(this).find("_allowed_upgrade").each(function() {
                        name4 = $(this).text();


                    });

                    $(this).find("_MDT_no").each(function() {
                        name5 = $(this).text();


                    });

                    $(this).find("_IMEI").each(function() {
                        name6 = $(this).text();


                    });

                    $(this).find("_department").each(function() {
                        name7 = $(this).text();


                    });

                    $(this).find("_device_type").each(function() {
                        name8 = $(this).text();


                    });

                    $(this).find("_is_head_quarters_device").each(function() {
                        name9 = $(this).text();


                    });

                    $(this).find("_is_rooted_or_jail_broken").each(function() {
                        name10 = $(this).text();


                    });


                    $(this).find("_manufacturer").each(function() {
                        name11 = $(this).text();


                    });

                    $(this).find("_comments").each(function() {
                        name12 = $(this).text();


                    });


                    $("#fill").append('<tr name="table_rows"><td>' + name1 + '</td>+<td>' + name3 + '</td>+<td>' + name4 + '</td>++<td>' + name5 + '</td>++<td>' + name6 + '</td>++<td>' + name7 + '</td>++<td>' + name8 + '</td>++<td>' + name9 + '</td>++<td>' + name10 + '</td>++<td>' + name11 + '</td>++<td>' + name12 + '</td></tr>');
                    name3 = name1 = name4 = name5 = name6 = name7 = name8 = name9 = name10 = name11 = name12 = "";


                });

            });



        }

    });
}


function get_manufacturers() {
    var name;

    $.ajax({
        type: "GET",
        cache: "false",
        dataType: "xml",
        url: "http://localhost:8080/mi_asset-management/rest/assets/manufacturers",
        success: function(xml) {

            $(xml).find('assets_infoes').each(function() {

                $(this).find("_manufacturer").each(function() {
                    name = $(this).text();

                    $("#manufacturer").append("<option>" + name + "</option>");


                });




            });
        }


    });



}
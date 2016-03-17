$(document).ready(function(){
    var first = true;
    // var badges = ['images/boulder.png', 'images/cascade.png', 'images/thunder.png', 'images/rainbow.png', 'images/soul.png', 'images/marsh.png', 'images/volcano.png', 'images/earth.png', "images/zephyr.png", "images/hive.png", "images/plain.png", "images/fog.png"];
    var el      = "";
    for(var i = 0;  i < badges.length; ++i)
    {
        var badge   = badges[i];
        console.log(badge);

        var row     = i%8;
        var segment = i%4;

        if(row == 0){
            if(!first){
                el += "</diV>";
                el += "</diV>";
            }else{
                first = false;
            }
            el += "<div class='badge-row row' style='text-align:center'>";
        }

        if(segment == 0){
            if(row != 0)
                el += "</diV>";
            el += "<div class='col-xs-12 col-md-12 col-lg-6 badge-div'>";
        }

        el += "<img src="+badge+" height='42' width='42'>";

        $('#badges').html(el);

    }
});

$("document").ready(function() {
    $("#dialog").hide();

    $("#link").hover(function() {
        $("#link").addClass("open");
    }, function() {
        $("#link").removeClass("open");
    });

    $(".buy").click(function(eventObject) {
        var number =  eventObject.target.getAttribute("id");
        $.post("add", {
            id: number
        });
        $("#dialog").show().delay(500).hide("slow");
    });
});
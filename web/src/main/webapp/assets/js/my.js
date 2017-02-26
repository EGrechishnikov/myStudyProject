$("document").ready(function() {
    $("#bodyOld").hide();
    update();
    $(".amount").change(function(eventObject) {
        eventObject.target.setAttribute("value", this.value);
        var id = this.parentNode.getAttribute("id");
        $.post("change", {
            id: id,
            count: this.value
        });
        update()
    });

    $(".basket").click(function() {
        $("#bodyOld").hide();
        $("#bodyBasket").show();
    });

    $(".oldOrders").click(function() {
        $("#bodyBasket").hide();
        $("#bodyOld").show();
    });

    $(".edit-but").click(function() {
        $(location).attr("href", "linkToEdit");
    });

    $(".delete").click(function(eventObject) {
        var number = eventObject.target.parentNode.getAttribute("id");
        $.post("sub", {
            id: number
        });
        var ad = eventObject.target.parentNode.parentNode.parentNode;
        $(ad).slideUp("slow");
    });
});

function update() {
    var totalAmount = 0;
    var prices = document.getElementsByClassName("sum");
    var counters = document.getElementsByClassName("amount");
    for(var i=0; i<prices.length; i++) {
        var index = counters[i].getAttribute("value");
        totalAmount += prices[i].innerHTML * index;
    }
    $("#count").html(totalAmount);
}
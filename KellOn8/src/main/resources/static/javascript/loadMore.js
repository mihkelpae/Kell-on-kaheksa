function loadMail() {
    var x = document.getElementById("loadMail");
    var y = document.getElementById("loadMore");
    if (x.style.display === "none") {
        x.style.display = "none";
    } else {
        y.style.display = "none";
        x.style.display = "block";
    }
}
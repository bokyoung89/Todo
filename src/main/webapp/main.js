var buttons = document.querySelectorAll(".button");
for (let index = 0; index < buttons.length; index++) {
    buttons[index].addEventListener("click", function(){
        alert('hi!');
    }, false);
}

var newButton = document.querySelector(".new");
newButton.addEventListener("click", function(){
//    alert('new!');
}, false);
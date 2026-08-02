/* =====================================================
        TOUR MASTER TRAVEL AGENCY

        script.js

        FEATURES:

        ✔ Mobile Menu
        ✔ Navbar Scroll Glass Effect
        ✔ Dark Mode Toggle
        ✔ Counter Animation
        ✔ Scroll Reveal
        ✔ Back To Top
        ✔ Newsletter Validation
        ✔ Smooth Navigation
        ✔ Booking Button Interaction

===================================================== */



// ===============================
// MOBILE MENU
// ===============================


const menuBtn = document.getElementById("menuBtn");

const navLinks = document.getElementById("navLinks");



if(menuBtn){


    menuBtn.addEventListener("click",()=>{


        navLinks.classList.toggle("hidden");


        menuBtn.innerHTML =

        navLinks.classList.contains("hidden")

        ?

        `<i class="fa-solid fa-bars"></i>`

        :

        `<i class="fa-solid fa-xmark"></i>`;


    });


}




// Close mobile menu when clicking link


document
.querySelectorAll("#navLinks a")
.forEach(link=>{


    link.addEventListener("click",()=>{


        navLinks.classList.add("hidden");


        if(menuBtn){

            menuBtn.innerHTML =
            `<i class="fa-solid fa-bars"></i>`;

        }


    });


});







// ===============================
// NAVBAR SCROLL EFFECT
// ===============================


const header =
document.getElementById("header");



window.addEventListener("scroll",()=>{


    if(window.scrollY > 80){


        header.classList.add(
            "bg-dark/80",
            "backdrop-blur-xl",
            "shadow-lg"
        );


    }


    else{


        header.classList.remove(
            "bg-dark/80",
            "backdrop-blur-xl",
            "shadow-lg"
        );


    }


});







// ===============================
// DARK MODE
// ===============================


const themeToggle =
document.getElementById("themeToggle");



let darkMode =
localStorage.getItem("darkMode");

if(darkMode==="enabled"){


    document.body.classList.add(
        "dark"
    );


}

if(themeToggle){

themeToggle.addEventListener(
"click",
()=>{


document.body.classList.toggle(
"dark"
);



if(
document.body.classList.contains("dark")
){


localStorage.setItem(
"darkMode",
"enabled"
);

themeToggle.innerHTML =

`
<i class="fa-solid fa-sun"></i>
`;

}

else{

localStorage.setItem(
"darkMode",
"disabled"
);

themeToggle.innerHTML =

`
<i class="fa-solid fa-moon"></i>
`;


}

});


}
// ===============================
// SCROLL REVEAL ANIMATION
// ===============================

const revealElements =
document.querySelectorAll(
".reveal"
);

function reveal(){

revealElements.forEach(
(element)=>{
const position =
element.getBoundingClientRect()
.top;

const screen =
window.innerHeight - 100;

if(position < screen){
element.classList.add(
"active"
);
}

});
}

window.addEventListener(
"scroll",
reveal
);


reveal();
// ===============================
// COUNTER ANIMATION
// ===============================

const counters =
document.querySelectorAll(
".counter"
);

let started=false;

function startCounter(){

const section =
document.querySelector(
".counter"
);



if(!section)
return;



const top =
section.getBoundingClientRect()
.top;



if(
top < window.innerHeight
&&
!started
){


started=true;



counters.forEach(counter=>{


let target =
Number(
counter.dataset.target
);



let count=0;


let speed =
target / 100;



function update(){


count += speed;



if(count < target){


counter.innerText =
Math.ceil(count);



requestAnimationFrame(
update
);



}

else{

counter.innerText =
target + "+";
}
}
update();
});
}

}

window.addEventListener(
"scroll",
startCounter
);

// ===============================
// BACK TO TOP BUTTON
// ===============================

const topBtn =
document.getElementById(
"topBtn"
);

window.addEventListener(
"scroll",
()=>{

if(window.scrollY > 500){

topBtn.classList.remove(
"hidden"
);

}

else{

topBtn.classList.add(
"hidden"
);
}

});

if(topBtn){

topBtn.addEventListener(
"click",
()=>{


window.scrollTo({

top:0,

behavior:"smooth"

});


});


}
// ===============================
// NEWSLETTER
// ===============================

const newsletter =
document.getElementById(
"newsletterForm"
);
if(newsletter){
newsletter.addEventListener(
"submit",
(e)=>{
e.preventDefault();
const email =
newsletter.querySelector(
"input"
).value;
if(email.trim()===""){
alert(
"Please enter your email."
);
return;
}
alert(
"Thank you for subscribing to Tour Master!"
);
newsletter.reset();
});
}
// ===============================
// BOOKING BUTTON
// ===============================

const bookButtons =
document.querySelectorAll(
".book-btn"
);

bookButtons.forEach(
button=>{
button.addEventListener(
"click",
()=>{
alert(
"Booking request received. Our team will contact you soon."
);

});

});
// ===============================
// SMOOTH SCROLL
// ===============================
document
.querySelectorAll(
'a[href^="#"]'
)
.forEach(anchor=>{
anchor.addEventListener(
"click",
function(e){
const target =
document.querySelector(
this.getAttribute("href")
);

if(target){
e.preventDefault();
target.scrollIntoView({

behavior:"smooth"
});
}
});
});

// ===============================
// IMAGE LAZY LOAD
// ===============================
document
.querySelectorAll("img")
.forEach(img=>{
img.loading="lazy";
});
// ===============================
// FOOTER YEAR AUTO UPDATE
// ===============================
const yearText =
document.querySelector(
"footer p"
);

if(yearText){

yearText.innerHTML =
yearText.innerHTML.replace(
"2026",
new Date()
.getFullYear()
);

}
console.log(
"Tour Master Website Loaded Successfully 🚀"
);
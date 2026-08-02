/* ==========================================================
        TOUR MASTER TRAVEL AGENCY

        SCRIPT.JS

        FEATURES:

        ✔ Preloader
        ✔ Mobile Menu
        ✔ Navbar Scroll Effect
        ✔ Dark / Light Mode
        ✔ Back To Top Button
        ✔ Scroll Reveal Animation
        ✔ Counter Animation
        ✔ Newsletter Validation
        ✔ Smooth Navigation
        ✔ Image Lazy Loading

=========================================================== */



// ==========================
// PRELOADER
// ==========================


window.addEventListener("load", () => {


    const loader =
    document.getElementById("preloader");


    if(loader){

        loader.style.opacity="0";

        setTimeout(()=>{

            loader.style.display="none";

        },500);

    }


});





// ==========================
// MOBILE MENU
// ==========================


const menuBtn =
document.querySelector(".menu-btn");


const navLinks =
document.querySelector(".nav-links");



if(menuBtn){


    menuBtn.addEventListener("click",()=>{


        navLinks.classList.toggle("active");


        menuBtn.innerHTML =
        navLinks.classList.contains("active")

        ?

        '<i class="fa-solid fa-xmark"></i>'

        :

        '<i class="fa-solid fa-bars"></i>';



    });


}



// Close menu after clicking link


document.querySelectorAll(".nav-links a")
.forEach(link=>{


    link.addEventListener("click",()=>{


        navLinks.classList.remove("active");


        if(menuBtn){

            menuBtn.innerHTML =
            '<i class="fa-solid fa-bars"></i>';

        }


    });


});






// ==========================
// NAVBAR SCROLL EFFECT
// ==========================


const header =
document.querySelector("header");



window.addEventListener("scroll",()=>{


    if(window.scrollY > 80){


        header.classList.add("scrolled");


    }

    else{


        header.classList.remove("scrolled");


    }


});







// ==========================
// DARK / LIGHT MODE
// ==========================


const themeBtn =
document.getElementById("themeToggle");



if(themeBtn){


    themeBtn.addEventListener("click",()=>{


        document.body.classList.toggle(
            "dark-mode"
        );


        if(
            document.body.classList.contains(
                "dark-mode"
            )
        ){


            themeBtn.innerHTML =
            '<i class="fa-solid fa-sun"></i>';


            localStorage.setItem(
                "theme",
                "dark"
            );


        }


        else{


            themeBtn.innerHTML =
            '<i class="fa-solid fa-moon"></i>';


            localStorage.setItem(
                "theme",
                "light"
            );


        }


    });


}





// Remember user theme


if(
localStorage.getItem("theme")
==="dark"
){


    document.body.classList.add(
        "dark-mode"
    );


    if(themeBtn){

        themeBtn.innerHTML =
        '<i class="fa-solid fa-sun"></i>';

    }


}







// ==========================
// BACK TO TOP
// ==========================


const topBtn =
document.getElementById("topBtn");



window.addEventListener("scroll",()=>{


    if(window.scrollY > 400){


        topBtn?.classList.add("active");


    }

    else{


        topBtn?.classList.remove("active");


    }


});



topBtn?.addEventListener(
"click",
()=>{


    window.scrollTo({

        top:0,

        behavior:"smooth"

    });


});








// ==========================
// SCROLL REVEAL
// ==========================


const revealElements =
document.querySelectorAll(
".reveal"
);



function reveal(){


    revealElements.forEach(element=>{


        const windowHeight =
        window.innerHeight;


        const elementTop =
        element.getBoundingClientRect()
        .top;


        const revealPoint =
        100;



        if(
            elementTop <
            windowHeight - revealPoint
        ){


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







// ==========================
// COUNTER ANIMATION
// ==========================


const counters =
document.querySelectorAll(
".counter"
);



let counterStarted=false;



function startCounter(){


    const statsSection =
    document.querySelector(
        ".statistics"
    );


    if(!statsSection)
    return;



    const position =
    statsSection
    .getBoundingClientRect()
    .top;



    if(
        position <
        window.innerHeight
        &&
        !counterStarted
    ){


        counterStarted=true;



        counters.forEach(counter=>{


            const target =
            Number(
                counter.dataset.target
            );


            let count=0;


            const speed =
            target / 100;



            const update=()=>{


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
                    target
                    +
                    "+";


                }


            };


            update();


        });


    }


}



window.addEventListener(
"scroll",
startCounter
);








// ==========================
// NEWSLETTER VALIDATION
// ==========================


const newsletter =
document.querySelector(
".newsletter-form"
);



if(newsletter){


newsletter.addEventListener(
"submit",
(e)=>{


    e.preventDefault();



    const email =
    newsletter
    .querySelector("input")
    .value;



    if(email===""){


        alert(
        "Please enter your email address."
        );


        return;


    }



    alert(
    "Thank you for subscribing to Tour Master!"
    );



    newsletter.reset();



});


}








// ==========================
// SMOOTH SCROLL
// ==========================


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








// ==========================
// IMAGE LAZY LOADING
// ==========================


const images =
document.querySelectorAll(
"img"
);



images.forEach(img=>{


    img.setAttribute(
        "loading",
        "lazy"
    );


});








// ==========================
// PACKAGE BOOKING BUTTON
// ==========================


const bookingButtons =
document.querySelectorAll(
".book-btn"
);



bookingButtons.forEach(button=>{


button.addEventListener(
"click",
()=>{


    alert(
    "Your booking request has been received. Our team will contact you soon."
    );


});


});








// ==========================
// CURRENT YEAR FOOTER
// ==========================


const year =
document.querySelector(
".footer-bottom p"
);



if(year){


year.innerHTML =
year.innerHTML.replace(
"2026",
new Date()
.getFullYear()
);


}





/* ==========================================================
        END OF SCRIPT.JS

        TOUR MASTER WEBSITE

        JavaScript Completed:

        ✔ Interactive Navbar
        ✔ Theme System
        ✔ Counters
        ✔ Animations
        ✔ Form Handling
        ✔ Responsive Features

=========================================================== */
document.addEventListener("DOMContentLoaded", function () {
    // Dynamic Year Update in Copyright
    const yearSpan = document.getElementById("year");
    if (yearSpan) {
        yearSpan.textContent = new Date().getFullYear();
    }

    // Smooth Scroll for Contact Button
    const contactBtn = document.querySelector(".btn-contact");
    if (contactBtn) {
        contactBtn.addEventListener("click", function (e) {
            e.preventDefault();
            const target = document.querySelector("#contact");
            if (target) {
                target.scrollIntoView({
                    behavior: "smooth"
                });
            }
        });
    }
});
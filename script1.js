document.addEventListener("DOMContentLoaded", () => {
    // Reveal animation on scroll (Optional)
    const cards = document.querySelectorAll('.review-card');
    
    cards.forEach((card, index) => {
        card.style.opacity = "0";
        card.style.transform = "translateY(20px)";
        card.style.transition = "all 0.6s ease " + (index * 0.15) + "s";
        
        setTimeout(() => {
            card.style.opacity = "1";
            card.style.transform = "translateY(0)";
        }, 100);
    });
});
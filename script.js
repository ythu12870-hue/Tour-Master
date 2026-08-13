document.addEventListener("DOMContentLoaded", () => {
    loadDestinationsFromDB();
});

async function loadDestinationsFromDB() {
    const cardsGrid = document.querySelector('.cards-grid');
    if (!cardsGrid) return;

    const promoCard = document.querySelector('.promo-card');

    try {
        const response = await fetch('http://localhost:3000/api/destinations');
        const dbData = await response.json();

        if (!dbData || dbData.length === 0) return;

        dbData.forEach(item => {
            const cardHTML = `
                <div class="destination-card">
                    <div class="card-img-wrapper">
                        ${item.status === 'Active' ? '<span class="badge">Popular</span>' : ''}
                        <img src="../${item.image || 'p1.jpg'}" alt="${item.name}">
                    </div>
                    <div class="card-content">
                        <h3>${item.name}</h3>
                        <p>${item.description || 'No description available.'}</p>
                        <div class="card-tags">
                            <span><i class="fa-regular fa-clock"></i> 3 Days</span>
                            <span><i class="fa-solid fa-star"></i> 4.5</span>
                            <span><i class="fa-solid fa-user-group"></i> 1.2k+</span>
                        </div>
                        <div class="card-footer">
                            <div class="price-box">
                                <span class="price-label">Location</span>
                                <span class="price-val">${item.location || 'Myanmar'}</span>
                            </div>
                            <a href="#" class="explore-link">Explore &rarr;</a>
                        </div>
                    </div>
                </div>
            `;

            if (promoCard) {
                cardsGrid.insertBefore(createElementFromHTML(cardHTML), promoCard);
            } else {
                cardsGrid.innerHTML += cardHTML;
            }
        });

    } catch (error) {
        console.error("Database connection Error:", error);
    }
}

function createElementFromHTML(htmlString) {
    const div = document.createElement('div');
    div.innerHTML = htmlString.trim();
    return div.firstElementChild;
}

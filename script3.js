// Data Array
const servicesData = [
    {
        icon: "🧳",
        title: "Tour Packages",
        description: "Choose from a wide variety of carefully planned travel packages covering Myanmar's most popular destinations."
    },
    {
        icon: "🏛️",
        title: "Online Booking",
        description: "Book your trip anytime with a fast and convenient online booking system that saves time and reduces paperwork."
    },
    {
        icon: "🏕️",
        title: "Hotel Reservation",
        description: "Reserve quality hotels and resorts with multiple room options for individuals, couples, families, or groups."
    },
    {
        icon: "🛫",
        title: "Transportation",
        description: "Arrange flights, buses, trains, and private car rentals to make every trip comfortable and convenient."
    },
    {
        icon: "💸",
        title: "Secure Payments",
        description: "Support secure payment methods with instant booking records, digital receipts, and payment status tracking."
    },
    {
        icon: "📈",
        title: "Travel Reports",
        description: "Generate booking summaries, customer reports, and financial records quickly through the administration dashboard."
    }
];

// Function to Render Cards Dynamically
function renderServices() {
    const gridContainer = document.getElementById('servicesGrid');
    
    gridContainer.innerHTML = servicesData.map(service => `
        <div class="service-card">
            <div class="icon-box">${service.icon}</div>
            <h3 class="card-title">${service.title}</h3>
            <p class="card-description">${service.description}</p>
        </div>
    `).join('');
}

// Execute when DOM is loaded
document.addEventListener("DOMContentLoaded", renderServices);
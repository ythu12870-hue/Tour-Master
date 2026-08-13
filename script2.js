/**
 * Package Data Array (Package ၁ ခုစီတွင် Normal နှင့် VIP Option ၂ မျိုးလုံး ပါဝင်ပါသည်)
 */
const packagesData = [
    {
        id: 1,
        package_name: "Bagan Sunrise Adventure",
        description: "Experience the magical sunrise over thousands of ancient temples, enjoy guided historical tours, delicious local cuisine, and a memorable hot-air balloon experience.",
        duration_days: 5,
        duration_nights: 4,
        image_path: "images2/photo1.jpg",
        options: {
            normal: {
                price: 8100000,
                max_people: 20,
                transport: "Bus"
            },
            vip: {
                price: 12000000,
                max_people: 2,
                transport: "Car"
            }
        }
    },
    {
        id: 2,
        package_name: "Kalaw Mountain Trek",
        description: "Trek through pine forests, visit local villages, waterfalls, tea plantations, and enjoy breathtaking mountain landscapes with professional guides.",
        duration_days: 4,
        duration_nights: 3,
        image_path: "images2/photo2.jpg",
        options: {
            normal: {
                price: 4400000,
                max_people: 15,
                transport: "Bus"
            },
            vip: {
                price: 7500000,
                max_people: 2,
                transport: "Car"
            }
        }
    },
    {
        id: 3,
        package_name: "Yangon Heritage Tour",
        description: "Visit the famous Shwedagon Pagoda, colonial architecture, Chinatown, Kandawgyi Lake, and experience the city's vibrant culture.",
        duration_days: 2,
        duration_nights: 1,
        image_path: "images2/photo3.jpg",
        options: {
            normal: {
                price: 5000000,
                max_people: 25,
                transport: "Bus"
            },
            vip: {
                price: 8000000,
                max_people: 2,
                transport: "Car"
            }
        }
    },
    {
        id: 4,
        package_name: "Hpa-An Explorer",
        description: "Explore spectacular caves, Mount Zwegabin, beautiful lakes, pagodas, and scenic countryside on this unforgettable adventure.",
        duration_days: 3,
        duration_nights: 2,
        image_path: "images2/photo4.jpg",
        options: {
            normal: {
                price: 6500000,
                max_people: 18,
                transport: "Bus"
            },
            vip: {
                price: 9500000,
                max_people: 2,
                transport: "Car"
            }
        }
    },
    {
        id: 5,
        package_name: "Ngwe Saung Beach Holiday",
        description: "Enjoy luxury beachfront resorts, water sports, fresh seafood, breathtaking sunsets, and a relaxing tropical vacation.",
        duration_days: 3,
        duration_nights: 2,
        image_path: "images2/photo5.jpg",
        options: {
            normal: {
                price: 8500000,
                max_people: 30,
                transport: "Bus"
            },
            vip: {
                price: 13000000,
                max_people: 2,
                transport: "Car"
            }
        }
    }
];

// 1. Render All Package Cards
function renderPackages(packages) {
    const container = document.getElementById('packagesContainer');
    if (!container) return;

    container.innerHTML = '';

    packages.forEach(pkg => {
        // Default အနေဖြင့် Normal Option စတင်ပြမည်
        const currentOption = pkg.options.normal;

        const cardHTML = `
            <div class="package-card" id="card-${pkg.id}">
                <div>
                    <div class="package-img-wrapper">
                        <img src="${pkg.image_path}" alt="${pkg.package_name}">
                        
                        <!-- VIP / Normal Toggle Switcher -->
                        <div class="type-switcher">
                            <button class="switcher-btn active" onclick="switchType(${pkg.id}, 'normal')">Normal</button>
                            <button class="switcher-btn" onclick="switchType(${pkg.id}, 'vip')">VIP</button>
                        </div>
                    </div>
                    
                    <div class="package-content">
                        <h3 class="package-title">${pkg.package_name}</h3>
                        <p class="package-desc">${pkg.description}</p>
                    </div>
                </div>

                <div>
                    <div class="package-details">
                        <div class="detail-item">
                            <i class="fa-regular fa-calendar-check"></i>
                            <span>${pkg.duration_days} Days / ${pkg.duration_nights} Night${pkg.duration_nights > 1 ? 's' : ''}</span>
                        </div>
                        <div class="detail-item">
                            <i class="fa-solid fa-users"></i>
                            <span class="max-people-text">Max ${currentOption.max_people} People</span>
                        </div>
                        <div class="detail-item">
                            <i class="fa-solid fa-van-shuttle"></i>
                            <span class="transport-text">Trans: ${currentOption.transport}</span>
                        </div>
                    </div>
                    
                    <div class="package-footer">
                        <span class="package-price">${currentOption.price.toLocaleString()} MMK</span>
                        <button class="btn-book" onclick="bookPackage(${pkg.id})">Book Now</button>
                    </div>
                </div>
            </div>
        `;

        container.insertAdjacentHTML('beforeend', cardHTML);
    });
}

// 2. Switch between Normal & VIP Logic
function switchType(packageId, selectedType) {
    const pkg = packagesData.find(p => p.id === packageId);
    if (!pkg) return;

    const card = document.getElementById(`card-${packageId}`);
    const option = pkg.options[selectedType];

    // Toggle Button Active Style Update
    const buttons = card.querySelectorAll('.switcher-btn');
    buttons.forEach(btn => {
        if (btn.innerText.toLowerCase() === selectedType) {
            btn.classList.add('active');
        } else {
            btn.classList.remove('active');
        }
    });

    // Dynamic UI Field Updates
    card.querySelector('.package-price').innerText = `${option.price.toLocaleString()} MMK`;
    card.querySelector('.max-people-text').innerText = `Max ${option.max_people} People`;
    card.querySelector('.transport-text').innerText = `Trans: ${option.transport}`;
}

// 3. Book Now Action Handler
function bookPackage(packageId) {
    const card = document.getElementById(`card-${packageId}`);
    const activeType = card.querySelector('.switcher-btn.active').innerText;
    const pkg = packagesData.find(p => p.id === packageId);
    const selectedOption = pkg.options[activeType.toLowerCase()];
    
    alert(`Package: ${pkg.package_name}\nOption: ${activeType}\nPrice: ${selectedOption.price.toLocaleString()} MMK\nTransport: ${selectedOption.transport}`);
}

// Initialize on Document Ready
document.addEventListener('DOMContentLoaded', () => {
    renderPackages(packagesData);
});
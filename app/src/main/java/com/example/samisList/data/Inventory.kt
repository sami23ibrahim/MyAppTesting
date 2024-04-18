package com.example.littlelemon.data

import com.example.littlelemon.R
//======================================================================================================================================================================
val grilladesCategories = listOf(
    Categories("Weekly Specials", R.drawable.special),
    Categories("Daily Plates", R.drawable.daily_plate),
    Categories("Shawarma", R.drawable.shawarma3),
    Categories("Salads", R.drawable.salad3),
    Categories("Pizza", R.drawable.pizza2),
    Categories("Dessert", R.drawable.dessert3),
    Categories("Soups", R.drawable.soup4)
)


val grills = listOf(

    // Daily Plates
    Item("grills",1, "Chicken Parmesan Plate", 13.99,
        "Crispy chicken breast topped with marinara and melted cheese, served with pasta.",
        R.drawable.chickenparmesan, "Daily Plates",false,1),
    Item("grills",2, "Vegetable Stir Fry", 12.99,
        "Fresh vegetables stir-fried with a savory sauce, served over rice or noodles.",
        R.drawable.vegetablestir, "Daily Plates",false,1),
    Item("grills",3, "Beef Taco Platter", 14.99,
        "Three beef tacos with all the fixings, served with rice and beans.",
        R.drawable.beeftacos, "Daily Plates",true,1),

    // Shawarma
    Item("grills",4, "Classic Chicken Shawarma", 9.99,
        "Marinated chicken, wrapped in a pita with garlic sauce, fries, and pickles.",
        R.drawable.chickenshawarma, "Shawarma",false,1),
    Item("grills",5, "Beef Shawarma Plate", 11.99,
        "Thinly sliced beef shawarma served with hummus, salad, and pita bread.",
        R.drawable.beefshawarmaplate, "Shawarma",false,1),
    Item("grills",9, "Beef Shawarma", 8.99,
        "Beef with tahini sauce, wrapped in a pita with vegetables.",
        R.drawable.shawarmabeef, "Shawarma",true,1),

    // Salads
    Item("grills",6, "Greek Salad", 7.99,
        "Tomatoes, cucumber, olives, onion, feta cheese, and dressing.",
        R.drawable.greeksaladd, "Salads",false,1),
    Item("grills",7, "Caesar Salad", 6.99,
        "Romaine lettuce, parmesan cheese, croutons, and Caesar dressing.",
        R.drawable.ceasar, "Salads",true,1),
    Item("grills",8, "Quinoa Salad", 8.99,
        "Quinoa, mixed greens, veggies, and a light vinaigrette.",
        R.drawable.quinoasalad, "Salads",false,1),

    // Pizza
    Item("grills",9, "Margherita Pizza", 10.99,
        "Tomato, mozzarella, basil, and extra virgin olive oil.",
        R.drawable.margheritapizza, "Pizza",false,1),
    Item("grills",10, "Pepperoni Pizza", 11.99,
        "Pepperoni, tomato sauce, and mozzarella cheese.",
        R.drawable.papperoni, "Pizza",true,1),
    Item("grills",11, "Veggie Pizza", 12.99,
        "Bell peppers, onions, mushrooms, olives, tomato sauce, and mozzarella.",
        R.drawable.veggiepizza, "Pizza",false,1),

    // Dessert
    Item("grills",12, "Chocolate Lava Cake", 6.99,
        "Warm chocolate cake with a gooey center, served with vanilla ice cream.",
        R.drawable.chocolatelava, "Dessert",false,1),
    Item("grills",13, "Cheesecake", 5.99,
        "Classic cheesecake with a graham cracker crust and berry compote.",
        R.drawable.cheesecake, "Dessert",false,1),
    Item("grills",14, "Baklava", 4.99,
        "Sweet dessert pastry made of layers of filo filled with chopped nuts and sweetened with syrup.",
        R.drawable.baklava, "Dessert",true,1),
// Soups
    Item("grills",15, "Tomato Basil Soup", 5.99,
        "Creamy tomato soup flavored with basil and spices.",
        R.drawable.tomatosoup, "Soups",true,1),
    Item("grills",16, "Chicken Noodle Soup", 6.99,
        "Classic chicken noodle soup with vegetables and herbs.",
        R.drawable.noodlesoup, "Soups",false,1),
    Item("grills",17, "Lentil Soup", 5.99,
        "Hearty lentil soup with vegetables, seasoned with spices.",
        R.drawable.lentilsoup, "Soups",false,1)
)



//========================================================================================
val fruitsCategories = listOf(
    Categories("Weekly Specials", R.drawable.special),
    Categories("Tropical Treasures", R.drawable.fruitspicks),
    Categories("Berry Bonanza", R.drawable.berry),
    Categories("Orchard Offerings", R.drawable.orchard),
    Categories("Citrus Specials", R.drawable.mandarin),
    Categories("Exotic Selections", R.drawable.dragon),
    Categories("Melon Medley", R.drawable.melon)
)

val fruits = listOf(

    // Tropical Treasures
    Item("fruits",18, "Mango Madness", 4.99,
        "Juicy, ripe mangoes perfect for any dish.",
        R.drawable.mango, "Tropical Treasures",true,2),
    Item("fruits",19, "Pineapple Perfection", 3.99,
        "Sweet and tangy pineapples, freshly picked.",
        R.drawable.ananas, "Tropical Treasures",true,2),
    Item("fruits",20, "Coconut Cluster", 5.99,
        "Fresh coconuts for a taste of the tropics.",
        R.drawable.coconutcluster, "Tropical Treasures",false,2),

    // Berry Bonanza
    Item("fruits",21, "Strawberry Surprise", 6.99,
        "Plump, sweet strawberries for your delight.",
        R.drawable.strawberry, "Berry Bonanza",false,2),
    Item("fruits",22, "Blueberry Bounty", 7.99,
        "Bursting with flavor, our blueberries are a must-try.",
        R.drawable.blueberry, "Berry Bonanza",true,2),
    Item("fruits",23, "Raspberry Riches", 8.99,
        "Tart and sweet raspberries, perfect for snacking.",
        R.drawable.rasberry, "Berry Bonanza",false,2),

    // Orchard Offerings
    Item("fruits",24, "Apple Assortment", 5.99,
        "A mix of the finest apples from our orchards.",
        R.drawable.apple, "Orchard Offerings",false,2),
    Item("fruits",25, "Peach Paradise", 6.99,
        "Juicy peaches, ripe and ready for eating.",
        R.drawable.peach, "Orchard Offerings",false,2),
    Item("fruits",26, "Pear Pleasures", 5.99,
        "Crisp pears, a delightful addition to any meal.",
        R.drawable.pear, "Orchard Offerings",false,2),

    // Citrus Specials
    Item("fruits",27, "Lemon Loot", 3.99,
        "Zesty lemons, great for cooking and beverages.",
        R.drawable.lemon, "Citrus Specials",false,2),
    Item("fruits",28, "Orange Oasis", 4.99,
        "Sweet, juicy oranges to brighten your day.",
        R.drawable.orange, "Citrus Specials",false,2),
    Item("fruits",29, "Grapefruit Gains", 4.99,
        "Ruby red grapefruits, a tangy treat.",
        R.drawable.grape, "Citrus Specials",false,2),

    // Exotic Selections
    Item("fruits",30, "Dragon Fruit Dream", 9.99,
        "Stunningly beautiful and deliciously sweet dragon fruit.",
        R.drawable.dragonfruits, "Exotic Selections",true,2),
    Item("fruits",31, "Passion Fruit Paradise", 10.99,
        "Tart and sweet, passion fruits are an exotic delight.",
        R.drawable.passionfruit, "Exotic Selections",false,2),
    Item("fruits",32, "Guava Glory", 8.99,
        "Tropical guavas, a sweet and unique flavor.",
        R.drawable.guavw, "Exotic Selections",false,2),

    // Melon Medley
    Item("fruits",33, "Watermelon Waves", 7.99,
        "Juicy watermelon slices, a summertime favorite.",
        R.drawable.watermelon, "Melon Medley",false,2),
    Item("fruits",34, "Cantaloupe Crush", 6.99,
        "Sweet cantaloupe, perfect for a refreshing snack.",
        R.drawable.canta, "Melon Medley",false,2),
    Item("fruits",35, "Honeydew Highlights", 6.99,
        "Light and sweet honeydew melon, a hydrating treat.",
        R.drawable.honeydew, "Melon Medley",false,2)
)
//======================================================================================================================================================================
val dairyCategories = listOf(
    Categories("Weekly Specials", R.drawable.special),
    Categories("Cheese Selections", R.drawable.cheese),
    Categories("Milk & Cream", R.drawable.milk2),
    Categories("Yogurt Varieties", R.drawable.yogurt),
    Categories("Butter & Spreads", R.drawable.butter),
    Categories("Ice Cream Delights", R.drawable.crepe)
)

val dairy = listOf(
    // Cheese Selections
    Item("dairy",36, "Artisan Cheddar", 5.99,
        "Aged cheddar with a rich, deep flavor and smooth texture.",
        R.drawable.artisan, "Cheese Selections",false,3),
    Item("dairy",37, "Gourmet Brie", 6.99,
        "Creamy and soft brie, perfect for cheese boards.",
        R.drawable.gourmet, "Cheese Selections",false,3),
    Item("dairy",38, "Smoked Gouda", 7.99,
        "Richly flavored with a smoky undertone, ideal for melting.",
        R.drawable.gouda, "Cheese Selections",false,3),

    // Milk & Cream
    Item("dairy",39, "Organic Whole Milk", 3.99,
        "Rich and creamy milk from grass-fed cows.",
        R.drawable.wholemilk, "Milk & Cream",false,3),
    Item("dairy",40, "Fresh Heavy Cream", 2.99,
        "Perfect for cooking, baking, or whipping into cream.",
        R.drawable.milkcream, "Milk & Cream",true,3),
    Item("dairy",41, "Barista Almond Milk", 4.99,
        "Specially formulated for coffee, froths beautifully.",
        R.drawable.almond, "Milk & Cream",false,3),

    // Yogurt Varieties
    Item("dairy",42, "Greek Yogurt", 1.99,
        "Thick and creamy, high in protein.",
        R.drawable.greek, "Yogurt Varieties",false,3),
    Item("dairy",43, "Icelandic Skyr", 2.49,
        "Traditionally thick and creamy, with a mild flavor.",
        R.drawable.icelandic, "Yogurt Varieties",false,3),
    Item("dairy",44, "Flavored Kefir", 2.99,
        "Probiotic-rich, comes in various fruit flavors.",
        R.drawable.kefir, "Yogurt Varieties",false,3),

    // Butter & Spreads
    Item("dairy",45, "Cultured Butter", 3.99,
        "Made from fermented cream, with a tangy taste.",
        R.drawable.clusteredbutter, "Butter & Spreads",false,3),
    Item("dairy",46, "Gourmet Truffle Butter", 5.99,
        "Infused with real truffles, elevates any dish.",
        R.drawable.truffle, "Butter & Spreads",false,3),
    Item("dairy",47, "Almond Butter", 6.99,
        "Smooth, made from roasted almonds, perfect for spreading.",
        R.drawable.almondbutter, "Butter & Spreads",false,3),

    // Ice Cream Delights
    Item("dairy",48, "Classic Vanilla Bean", 4.99,
        "Creamy ice cream made with real vanilla beans.",
        R.drawable.vanilla, "Ice Cream Delights",false,3),
    Item("dairy",49, "Rich Chocolate Gelato", 5.49,
        "Decadent gelato with deep chocolate flavor.",
        R.drawable.gelato, "Ice Cream Delights",false,3),
    Item("dairy",50, "Salted Caramel Swirl", 5.99,
        "Sweet and salty, with chunks of caramel.",
        R.drawable.salted, "Ice Cream Delights",false,3)
)

// android:icon="@mipmap/ic_launcher"

val vegetableCategories = listOf(
    Categories("Weekly Specials", R.drawable.special),
    Categories("Leafy Greens", R.drawable.leafygreens),
    Categories("Root Vegetables", R.drawable.beetroot),
    Categories("Nightshades", R.drawable.aubergine),
    Categories("Cruciferous", R.drawable.cabbage),
    Categories("Legumes", R.drawable.vegetable2)
)

val vegetables = listOf(
    // Leafy Greens
    Item("vegetables",51, "Spinach Bunch", 2.99,
        "Fresh, organic spinach, perfect for salads and cooking.",
        R.drawable.spinach, "Leafy Greens",false,4),
    Item("vegetables",52, "Kale", 3.49,
        "Organic kale, rich in nutrients and perfect for smoothies or chips.",
        R.drawable.leafy, "Leafy Greens",false,4),
    Item("vegetables",53, "Swiss Chard", 2.99,
        "Colorful, nutrient-packed leaves, ideal for sautéing.",
        R.drawable.chard, "Leafy Greens",false,4),

    // Root Vegetables
    Item("vegetables",54, "Carrots", 1.99,
        "Crunchy, sweet, and versatile, great for snacking or cooking.",
        R.drawable.carrots, "Root Vegetables",false,4),
    Item("vegetables",55, "Beets", 2.49,
        "Earthy flavor, perfect for roasting or in salads.",
        R.drawable.beets, "Root Vegetables",false,4),
    Item("vegetables",56, "Sweet Potatoes", 3.99,
        "Rich in flavor and nutrients, ideal for baking or roasting.",
        R.drawable.potatoes, "Root Vegetables",false,4),

    // Nightshades
    Item("vegetables",57, "Tomatoes", 2.99,
        "Juicy and flavorful, great for salads or sauces.",
        R.drawable.tomatoes, "Nightshades",false,4),
    Item("vegetables",58, "Bell Peppers", 3.99,
        "Sweet and colorful, perfect for grilling or stuffing.",
        R.drawable.peppers, "Nightshades",true,4),
    Item("vegetables",59, "Eggplants", 4.49,
        "Versatile and meaty, excellent for baking or grilling.",
        R.drawable.eggplants, "Nightshades",false,4),

    // Cruciferous
    Item("vegetables",60, "Broccoli", 2.49,
        "Fresh and crunchy, great for steaming or stir-fries.",
        R.drawable.brocolli, "Cruciferous",true,4),
    Item("vegetables",61, "Cauliflower", 2.99,
        "Mild and versatile, can be roasted, mashed, or used in rice dishes.",
        R.drawable.cauliflower, "Cruciferous",false,4),
    Item("vegetables",62, "Brussels Sprouts", 3.49,
        "Nutty and sweet when roasted, a delicious side dish.",
        R.drawable.brussels, "Cruciferous",false,4),

    // Legumes
    Item("vegetables",63, "Green Beans", 2.99,
        "Crisp and tender, perfect for a quick sauté or steam.",
        R.drawable.beans, "Legumes",false,4),
    Item("vegetables",64, "Peas", 1.99,
        "Sweet and fresh, great in salads or as a side.",
        R.drawable.peas, "Legumes",false,4),
    Item("vegetables",65, "Lentils", 1.49,
        "Hearty and nutritious, excellent for soups and stews.",
        R.drawable.lentils, "Legumes",false,4)
)


val drinkCategories = listOf(
    Categories("Weekly Specials", R.drawable.special),
    Categories("Coffee & Tea", R.drawable.cup),
    Categories("Soft Drinks", R.drawable.can),
    Categories("Juices & Smoothies", R.drawable.orangejuice),
    Categories("Energy Drinks", R.drawable.energy),
    Categories("Water & Sparkling Water", R.drawable.water)
)

val drinks = listOf(
    // Coffee & Tea
    Item("drinks",66, "Classic Espresso", 2.99,
        "Rich and robust espresso, the perfect pick-me-up.",
        R.drawable.espresso, "Coffee & Tea",false,5),
    Item("drinks",67, "Green Tea", 1.99,
        "Fresh and soothing, with a subtle caffeine kick.",
        R.drawable.tea, "Coffee & Tea",false,5),
    Item("drinks",68, "Iced Latte", 3.49,
        "Chilled and creamy, with a strong espresso base.",
        R.drawable.latte, "Coffee & Tea",false,5),

    // Soft Drinks
    Item("drinks",69, "Cola", 1.49,
        "Classic and refreshing, with a caffeine boost.",
        R.drawable.cola, "Soft Drinks",false,5),
    Item("drinks",70, "Lemon-Lime Soda", 1.49,
        "Crisp and tart, perfect for a quick refresh.",
        R.drawable.lemonsoda, "Soft Drinks",false,5),
    Item("drinks",71, "Root Beer", 1.49,
        "Sweet and creamy, with a unique sassafras flavor.",
        R.drawable.rootbeer, "Soft Drinks",true,5),

    // Juices & Smoothies
    Item("drinks",72, "Mango Smoothie", 4.99,
        "Tropical and sweet, blended with ripe mangoes.",
        R.drawable.mangosmoothie, "Juices & Smoothies",false,5),
    Item("drinks",73, "Orange Juice", 2.99,
        "Freshly squeezed, full of vitamin C.",
        R.drawable.orangejuice, "Juices & Smoothies",false,5),
    Item("drinks",74, "Berry Blast Smoothie", 4.99,
        "Antioxidant-rich, with a mix of fresh berries.",
        R.drawable.berrysmoothie, "Juices & Smoothies",false,5),

    // Energy Drinks
    Item("drinks",75, "Tropical Energy", 2.99,
        "Energizing and refreshing, with a tropical twist.",
        R.drawable.tropical, "Energy Drinks",true,5),
    Item("drinks",76, "Sugar-Free Boost", 2.99,
        "High energy, zero sugar, with a crisp taste.",
        R.drawable.boost, "Energy Drinks",false,5),
    Item("drinks",77, "Berry Energy", 2.99,
        "Berry-flavored uplift, for when you need a quick boost.",
        R.drawable.berryenergy, "Energy Drinks",false,5),

    // Water & Sparkling Water
    Item("drinks",78, "Spring Water", 0.99,
        "Pure and refreshing, sourced from natural springs.",
        R.drawable.sparklingwater, "Water & Sparkling Water",false,5),
    Item("drinks",79, "Lemon Sparkling Water", 1.49,
        "Zesty lemon flavor, bubbly and refreshing.",
        R.drawable.lemonwater, "Water & Sparkling Water",false,5),
    Item("drinks",80, "Cucumber Mint Sparkling Water", 1.49,
        "Cooling cucumber and mint, a refreshing twist.",
        R.drawable.cucumberwater, "Water & Sparkling Water",false,5)
)



val meatCategories = listOf(
    Categories("Weekly Specials", R.drawable.special),
    Categories("Beef & Steak", R.drawable.beef),
    Categories("Poultry", R.drawable.chickenico),
    Categories("Pork", R.drawable.meat),
    Categories("Lamb", R.drawable.chop),
    Categories("Seafood", R.drawable.shrimp)
)

val meats = listOf(
    // Beef & Steak
    Item("meats",81, "Ribeye Steak", 14.99,
        "Premium cut, perfect for grilling, rich and flavorful.",
        R.drawable.birbeye, "Beef & Steak",true,6),
    Item("meats",82, "Ground Beef", 8.99,
        "Versatile and lean, ideal for burgers and sauces.",
        R.drawable.groundbeef, "Beef & Steak",false,6),
    Item("meats",83, "Beef Brisket", 12.99,
        "Slow-cook to perfection, tender and juicy.",
        R.drawable.brisket, "Beef & Steak",false,6),

    // Poultry
    Item("meats",84, "Whole Chicken", 9.99,
        "Fresh and natural, perfect for roasting.",
        R.drawable.chicken, "Poultry",false,6),
    Item("meats",85, "Chicken Thighs", 7.99,
        "Juicy and flavorful, ideal for grilling or baking.",
        R.drawable.thighs, "Poultry",false,6),
    Item("meats",86, "Turkey Breast", 11.99,
        "Lean and healthy, great for slicing or roasting.",
        R.drawable.breast, "Poultry",false,6),

    // Pork
    Item("meats",87, "Pork Chops", 10.99,
        "Thick-cut and bone-in, full of flavor.",
        R.drawable.porkchops, "Pork",true,6),
    Item("meats",88, "Bacon", 5.99,
        "Crispy and smoky, a breakfast favorite.",
        R.drawable.beacon, "Pork",false,6),
    Item("meats",89, "Pork Belly", 12.99,
        "Rich and succulent, perfect for slow roasting or braising.",
        R.drawable.belly, "Pork",false,6),

    // Lamb
    Item("meats",90, "Lamb Chops", 15.99,
        "Tender and rich, excellent for grilling.",
        R.drawable.lambchops, "Lamb",false,6),
    Item("meats",91, "Ground Lamb", 9.99,
        "Flavorful and versatile, great for Mediterranean dishes.",
        R.drawable.goundlamb, "Lamb",false,6),
    Item("meats",92, "Lamb Shank", 14.99,
        "Hearty and delicious, ideal for slow-cooked meals.",
        R.drawable.leg, "Lamb",false,6),

    // Seafood
    Item("meats",93, "Salmon Fillet", 13.99,
        "Fresh and rich in omega-3, perfect for grilling or baking.",
        R.drawable.salmon, "Seafood",false,6),
    Item("meats",94, "Shrimp", 12.99,
        "Versatile and quick to cook, great for a variety of dishes.",
        R.drawable.shrimps, "Seafood",false,6),
    Item("meats",95, "Scallops", 14.99,
        "Sweet and tender, ideal for searing.",
        R.drawable.scallops, "Seafood",false,6)
)

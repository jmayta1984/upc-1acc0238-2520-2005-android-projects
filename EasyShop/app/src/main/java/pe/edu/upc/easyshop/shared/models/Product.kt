package pe.edu.upc.easyshop.shared.models

data class Product(
    val name: String,
    val price: Double,
    val image: String
)

val products = listOf(
    Product(
        name = "Nike React Infinity Run Fly knit",
        price = 180.0,
        image = "https://www.fit2run.com/cdn/shop/files/DH5392-007-PHSRH001-1500.png"
    ),
    Product(
        name = "Nike React Miler",
        price = 140.0,
        image = "https://i.ebayimg.com/images/g/SoIAAOSwEXpmIQ~7/s-l400.png"
    ),
    Product(
        name = "Nike Air Zoom Pegasus 37",
        price = 120.0,
        image = "https://d2cva83hdk3bwc.cloudfront.net/nike-air-zoom-pegasus-37-white-cyber-1.jpg"
    )

)
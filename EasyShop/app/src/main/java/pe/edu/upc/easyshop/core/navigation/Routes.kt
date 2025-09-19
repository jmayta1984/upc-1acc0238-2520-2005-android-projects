package pe.edu.upc.easyshop.core.navigation

sealed class Routes(val route: String) {
    object Login: Routes("login")
    object Main: Routes("main")
    object ProductDetail: Routes("product_detail")
}
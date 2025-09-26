package pe.edu.upc.easyshop.core.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easyshop.core.root.Main
import pe.edu.upc.easyshop.features.auth.presentation.login.Login
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.auth.presentation.di.PresentationModule.getLoginViewModel

@Composable
fun AppNav() {

    val navNavController = rememberNavController()


    NavHost(navNavController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            Login(getLoginViewModel()) {
                navNavController.navigate(Routes.Main.route)
            }
        }

        composable(Routes.Main.route) {
            Main {
                navNavController.navigate(Routes.ProductDetail.route)
            }
        }

        composable(Routes.ProductDetail.route) {
            Text("Product")
        }
    }

}

@Preview
@Composable
fun AppNavPreview() {
    EasyShopTheme {
        AppNav()
    }
}
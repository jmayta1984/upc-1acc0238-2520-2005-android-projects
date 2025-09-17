package pe.edu.upc.easyshop.core.navigation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easyshop.core.root.Main
import pe.edu.upc.easyshop.features.auth.presentation.Login
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme

@Composable
fun AppNav() {

    val navNavController = rememberNavController()
    NavHost(navNavController, startDestination = "login") {
        composable("login") {
            Login {
                navNavController.navigate("main")
            }
        }

        composable("main") {
            Main {
                navNavController.navigate("product")
            }
        }

        composable("product") {
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
package pe.edu.upc.easyshop

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.upc.easyshop.ui.theme.EasyShopTheme

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
            Main()
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
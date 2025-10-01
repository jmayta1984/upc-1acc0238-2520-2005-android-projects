package pe.edu.upc.easyshop.core.navigation

import android.util.Log
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import pe.edu.upc.easyshop.core.root.Main
import pe.edu.upc.easyshop.core.ui.theme.EasyShopTheme
import pe.edu.upc.easyshop.features.auth.presentation.login.Login
import pe.edu.upc.easyshop.features.home.presentation.productdetail.ProductDetail
import pe.edu.upc.easyshop.features.home.presentation.productdetail.ProductDetailViewModel

@Composable
fun AppNav() {

    val navNavController = rememberNavController()


    NavHost(navNavController, startDestination = Routes.Login.route) {
        composable(Routes.Login.route) {
            Login {
                navNavController.navigate(Routes.Main.route)
            }
        }

        composable(Routes.Main.route) {
            Log.d("AppNav", "Main")
            Main { id ->
                navNavController.navigate("${Routes.ProductDetail.route}/$id")
            }
        }

        composable(
            route = Routes.ProductDetail.routeWithArgument,
            arguments = listOf(navArgument(Routes.ProductDetail.argument) {
                type = NavType.IntType
            })
        ) { backStackEntry ->
            backStackEntry.arguments?.let { arguments ->
                val id = arguments.getInt(Routes.ProductDetail.argument)
                val productDetailViewModel: ProductDetailViewModel = hiltViewModel()
                Log.d("AppNav", id.toString())
                productDetailViewModel.getProductById(id)
                ProductDetail(productDetailViewModel)
            }

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